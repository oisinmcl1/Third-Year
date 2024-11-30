package org.example;

import org.example.exceptions.NegativeBalanceException;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.Random;

/**
 * @author Oisin Mc Laughlin
 * 22441106
 */
public class RandomTransactionGenerator implements Runnable {
    private Bank b;
    private Transaction t1, t2, t3;
    private Random r;
    private int accNum;
    private int choseAcc;

    public RandomTransactionGenerator(Bank bank) {
        this.b = bank;
        r = new Random();
    }

    @Override
    public void run() {
        try {
            // While bank is running (open for bussiness)
            while (b.getRunning() == true) {
                try {
                    choseAcc = r.nextInt(3);
                    // Randomly select an account to deposit to (1234, 5678, 2432)
                    if (choseAcc == 0) {
                        accNum = 1234;
                    }
                    else if (choseAcc == 1) {
                        accNum = 5678;
                    }
                    else {
                        accNum = 2432;
                    }
//                    System.out.println("\n\n\nRnadom Choose: " + accNum);

                    // Create a new transaction
                    Transaction t = new Transaction(accNum, randomAmount());
//                    System.out.print("\n\nAmount: " + t.getAmount());
//                    System.out.println("\nAcc: " + t.getAccountNumber());

                    // Submit the transaction to the bank
                    b.submitTransaction(t);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
//                finally {
//                    b.closeBank();
//                }
            }
            // Sleep for random time between 0 and 1 sec
            Thread.sleep(
                    (long) (Math.random() * 1000)
            );
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Generate a random amount between -10000 and 10000
     * @return
     */
    private float randomAmount() {
        return r.nextFloat() * 20000 - 10000;
    }
}
