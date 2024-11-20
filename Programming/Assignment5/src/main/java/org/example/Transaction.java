package org.example;

/**
 * A class representing an account transaction for the CT326 Assignment 5 (24/25)
 * @author Adrian Clear
 */
public class Transaction {
	private float amount;
	private int accountNumber;

	/**
	 * Create a transaction for the Account with the given account number, of the given amount.
	 * @param accNumber the account number of the transaction account
	 * @param amount the amount to withdraw/deposit. A positive value represents a deposit, a negative value represents a withdrawal
	 */
	public Transaction(int accNumber, float amount) {
		this.accountNumber = accNumber;
		this.amount = amount;
	}

	/**
	 * Get the amount of this transaction
	 * @return the amount of the transaction
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * Get the account number of the transaction
	 * @return the account number of the transaction
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	@Override
	public String toString() {
		if(amount >= 0)
			return String.format("a deposit of %f to %d", amount, accountNumber);
		else
			return String.format("a withdrawal of %f from %d", amount, accountNumber);
	}
}
