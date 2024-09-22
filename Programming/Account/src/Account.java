public class Account {
    private static int counter = 0;
    private int accountNumber;
    private double balance;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        counter++;
    }

    public Account(int accountNumber, double balance) {
        this(accountNumber);
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static int getInstanceCount() {
        return counter;
    }

    public double makeDeposit(double amount) {
        balance += amount;
        return balance;
    }

    public double makeWithdrawal(double amount) {
        return (balance >= amount) ? balance -= amount : balance;
    }

    public static void main(String[] args) {
        Account a = new Account(123);
        System.out.println(a.accountNumber);
        System.out.println(counter);
    }
}