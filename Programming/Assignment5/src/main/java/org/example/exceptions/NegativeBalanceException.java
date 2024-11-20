package org.example.exceptions;

/**
 * An exception representing an instance where a negative balance is set to an account
 * @author Adrian Clear
 */
public class NegativeBalanceException extends Exception {
	public NegativeBalanceException(String message) {
		super(message);
	}
}
