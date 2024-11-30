/*
I hope everything is there, I had to restore from a backup this morning (assignment due day)
I have a uni match today so I can't spend anymore time debugging - I'd love to know why it's not working
 */

package org.example;

import org.example.exceptions.InsufficientFundsException;
import org.example.exceptions.NegativeBalanceException;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Oisin Mc Laughlin
 * 22441106
 */

public class Bank {
    private Map<Integer, Account> accounts;
    private LinkedBlockingQueue<Transaction> transactions;
    private ExecutorService tp;
    private volatile boolean running;

    /**
     * Constructor for Bank class
     * Initialises accounts map and transactions queue
     */
    public Bank() {
        accounts = new HashMap<>();
        transactions = new LinkedBlockingQueue<>();
        tp = Executors.newFixedThreadPool(2);
    }

    /**
     * Method to add an account to the bank
     * Checks if account is not null before adding
     * Maps account number to account
     *
     * @param a to be added
     */
    public void addAcc(Account a) {
        if (a != null) {
            accounts.put(a.getAccountNumber(), a);
        }
    }

    /**
     * Method to get an account given its account number
     * Gets account from map using account number as key
     *
     * @param accnum the account number of the account to get
     * @return the account with the given account number
     */
    public Account getAccById(int accnum) {
        return accounts.get(accnum);
    }

    /**
     * Method to submit a transaction to qieie for processing
     * Adds transaction to transactions queue
     *
     * @param t the transaction to be submitted
     */
    public void submitTransaction(Transaction t) {
        transactions.add(t);

//        System.out.println(transactions.toString());
//        System.out.println(transactions.size());
    }

    /**
     * Method to print accounts details (account num and balance)
     * Iterates through accounts map and prints account number and balance
     */
    public void printAccounts() {
        for (Account a : accounts.values()) {
            System.out.println(
                    "Account " +
                            a.getAccountNumber() +
                            " has a balance of " +
                            a.getBalance()
            );
        }
    }

    /**
     * Method to get collection of account numbers
     * Uses keySet method to get set of account numbers
     * Also uses return type Set to return collection
     *
     * @returns collection of account numbers
     */
    public Set<Integer> getAccountNumbers() {
        return accounts.keySet();
    }

    /**
     * Method to start two AutomatedBankClerk threads using thread pool ExecutorService
     * Submits AutomatedBankClerk objects to ExecutorService
     * Sets running to true
     * Sets running to true
     * <p>
     * Clerk 1 and Clerk 2 are created and submitted to the ExecutorService
     */
    public void openBank() {
        AutomatedBankClerk c1 = new AutomatedBankClerk("TPT1");
        AutomatedBankClerk c2 = new AutomatedBankClerk("TPT2");

        tp.submit(c1);
        tp.submit(c2);

        running = true;
    }

    /**
     * Method to close the bank by stopping two AutomatedBankClerk threads using thread pool
     * This waits for threads to finish terminating or for 10 seconds before returning
     * Sets running to false
     *
     * @throws InterruptedException if thread is interrupted
     */
    public void closeBank() {
        try {
            tp.shutdown();

            // if tp not shutdown after 10 seconds, force shutdown
            if (!tp.awaitTermination(10, TimeUnit.SECONDS)) {
                tp.shutdownNow();
            }

            // set running to false
            running = false;
        } catch (InterruptedException e) {
            // if any exception occurs, stop thread
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Getter for running
     *
     * @return running
     */
    public boolean getRunning() {
        return running;
    }

    // AutomatedBankClerk innerclass
    private class AutomatedBankClerk implements Runnable {
        private String name;
        private int dep;
        private int with;
        private int dCount;
        private int wCount;

        /**
         * Constructor for AutomatedBankClerk
         * Initialises name, deposit count and withdrawal count
         *
         * @param name of clerk
         */
        public AutomatedBankClerk(String name) {
            this.name = name;
            this.dCount = 0;
            this.wCount = 0;
        }

        /**
         * Run method for AutomatedBankClerk
         * While there are transactions in the queue, process them
         * If transaction is null, break
         * Get account associated with transaction
         * Allow 1 thread to access account at a time
         * If account not null, make deposit if amount is greater than 0
         * Otherwise make withdrawal
         * Sleep for random time between 0 and 1 sec
         *
         * @throws InterruptedException       if thread is interrupted
         * @throws InsufficientFundsException if insufficient funds for withdrawal
         */
        @Override
        public void run() {
            try {
                while (!transactions.isEmpty() || running) {
                    // Wait 5 seconds for a transaction to be available
                    Transaction t = transactions.poll(5, TimeUnit.SECONDS);
                    System.out.println("TRANSAC: " + t);

                    if (t == null) {
                        break;
                    }
                    System.out.println("\n\nHERE 2\n\n");

                    // Het account associated with transaction
                    Account a = getAccById(t.getAccountNumber());
                    System.out.println(a);

                    if (a != null) {
                        // Allow 1 thread to access account at a time
                        synchronized (a) {
                            System.out.println("\n\nHERE\n\n");
                            // If account not null make deposit
                            if (a != null) {
                                // Make deposit if amount is greater than 0
                                if (t.getAmount() > 0) {
                                    System.out.println("depositttttttttt");
                                    a.makeDeposit(Money.of(CurrencyUnit.EUR, t.getAmount()));
                                    System.out.println(
                                            name +
                                                    " processed a deposit of " +
                                                    t.getAmount() +
                                                    " to account " +
                                                    t.getAccountNumber()
                                    );
                                    dCount++;
                                }
                                // Otherwise make withdrawal
                                else {
                                    try {
                                        System.out.println("withdrawwwwwwwwwww");
                                        a.makeWithdrawal(Money.of(CurrencyUnit.EUR, t.getAmount()));
                                        System.out.println(
                                                name +
                                                        " processed a withdrawal of " +
                                                        t.getAmount() +
                                                        " from account " +
                                                        t.getAccountNumber()
                                        );
                                        System.out.println("Withdrawal: " + t.getAmount());
                                        wCount++;
                                    } catch (InsufficientFundsException e) {
                                        // Cancel transaction if insufficient funds
                                        System.out.println("Insufficient funds for withdrawal");
                                    }
                                }
                            }
                        }
                        // Sleep for random time between 0 and 1 sec
                        Thread.sleep(
                                (long) (Math.random() * 1000)
                        );
                    }
                }
            } catch (InterruptedException e) {
                // If thread interrupted, stop thread
                Thread.currentThread().interrupt();
            }
            finally {
                // Print clerk name and number of deposits and withdrawals processed
                System.out.println(
                        name +
                                " processed " +
                                dCount +
                                " deposits and " +
                                wCount +
                                " withdrawals"
                );
            }
        }
    }
}
