package exceptions;

/**
 * Thrown when an expense is created with an invalid amount (negative or zero).
 *
 * @author Oisin Mc Laughlin
 * 22441106
 */
public class InvalidExpenseAmount extends RuntimeException {

    /**
     * Constructs a new InvalidExpenseAmountException with the specified detail message.
     *
     * @param message The detail message
     */
    public InvalidExpenseAmount(String message) {
        super(message);
    }
}
