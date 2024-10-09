package exceptions;

public class InvalidExpenseAmount extends RuntimeException {
    public InvalidExpenseAmount(String message) {
        super(message);
    }
}
