package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.example.exceptions.InsufficientFundsException;
import org.example.exceptions.NegativeBalanceException;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

/**
 * Account class for CT326 Assignment 5 (24/25)
 * @author Adrian Clear
 */
public class Account implements Serializable {

	// Define serialVersionUID which is used during object deserialization to verify that the sender and receiver of a serialized
	// object have loaded classes for that object that are compatible - will throw InvalidClassException if not compatible
	// IDEs will often auto generate this value for you when creating new Java classes

	private static final long serialVersionUID = 202010191519L;

	private int accnum;
	private Money balance;

	// Date and Time account object was first created or loaded from storage
	private LocalDateTime activated;

	/**
	 * Creates an account with a given account number and balance.
	 * @param accnum the account number
	 * @param balance the initial balance of the account
	 * @throws NegativeBalanceException if the initial balance is negative
	 */
	public Account (int accnum, Money balance) throws NegativeBalanceException {
		setBalance(balance);
		this.accnum = accnum;
		activated = LocalDateTime.now();
	}

	/**
	 * Make a deposit to the account of the given amount
	 * @param amount the amount to deposit
	 */
	public void makeDeposit(Money amount) {
		if(amount.isGreaterThan(Money.of(CurrencyUnit.EUR, 0)) ) {
			balance.plus(amount);
		}
	}
//	public void makeDeposit(Money amount) throws NegativeBalanceException {
//		if(amount.isGreaterThan(Money.of(CurrencyUnit.EUR, 0)) ) {
//			setBalance(balance.plus(amount));
//		}
//	}

	/**
	 * Make a withdrawal from the account of the given amount
	 * @param amount the amount to withdraw
	 * @throws InsufficientFundsException if the amount to withdraw is greater than the current balance
	 */
	public void makeWithdrawal(Money amount) throws InsufficientFundsException {
		try {
			setBalance(balance.minus(amount));
		} catch (NegativeBalanceException e) {
			throw new InsufficientFundsException();
		}
	}

	/**
	 * Set the balance of the account to the given amount.
	 * @param balance the new balance of the account
	 * @throws NegativeBalanceException if the balance is negative
	 */
	private void setBalance(Money balance) throws NegativeBalanceException {
		if (balance.isLessThan(Money.of(CurrencyUnit.EUR, 0))) throw new NegativeBalanceException("Negative Balance Not Allowed!");
		this.balance = balance;
	}

	/**
	 * Get the balance of the account
	 * @return the balance of the account
	 */
	public Money getBalance() {
		return balance;
	}

	/**
	 * Get the account number of the account
	 * @return the account number of the account
	 */
	public int getAccountNumber() {
		return accnum;
	}

	/**
	 * Get the activation date of the account
	 * @return the activation date of the account
	 */
	public LocalDateTime getActivated() {
		return activated;
	}

	// This method is called when we are deserializing an instance of an Account object
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException,IOException {
		balance = (Money) aInputStream.readObject();
		accnum = aInputStream.readInt();
		// Reinitialise value for the LocalDateTime activated variable
		activated = LocalDateTime.now();
	}

	// This method is called when we serialize an instance of an Account object
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException {
		aOutputStream.writeObject(balance);
		aOutputStream.writeInt(accnum);
		// We don't write value for the LocalDateTime activated variable as we will reinitialise this when reloading the object
	}

	@Override
	public String toString() {
		return String.format("Account %d has a balance of %s.", accnum, balance);
	}

}
