import exceptions.InvalidExpenseAmount;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.ArrayList;

/**
 * Manages a list of employee expenses. This class allows adding expenses, printing them,
 * and summing their values (with support for multi-currency conversion).
 *
 * @author Oisin Mc Laughlin
 * 22441106
 */
public class ExpensesPortal {

    /**
     * A list of expenses in the system.
     */
    private List<Expense> expenses = new ArrayList<>();

    /**
     * Adds a new expense to the portal. This method validates that the expense amount is positive.
     *
     * @param expense The expense to be added
     * @throws InvalidExpenseAmount if the expense amount is negative or zero
     */
    public void addExpense(Expense expense) {
        if (expense.getExpenseAmount().isNegativeOrZero()) {
            throw new InvalidExpenseAmount("Expense amount must be positive.");
        }
        expenses.add(expense);
    }

    /**
     * Prints the expenses using a provided ExpensePrinter.
     *
     * @param printer The printer implementation that defines how expenses are printed
     */
    public void printExpenses(ExpensePrinter printer) {
        printer.printExpenses(expenses);
    }

    /**
     * Gets the list of expenses.
     *
     * @return A list of all expenses
     */
    public List<Expense> getExpenses() {
        return expenses;
    }

    /**
     * Sums the expenses and converts USD to EUR when necessary.
     *
     * @return The total sum of the expenses in EUR
     */
    public Money sumExpenses() {
        Money total = Money.zero(CurrencyUnit.EUR);
        for (Expense ex : expenses) {
            Money amt = ex.getExpenseAmount();
            if (amt.getCurrencyUnit().equals(CurrencyUnit.USD)) {
                amt = amt.convertedTo(CurrencyUnit.EUR, BigDecimal.valueOf(0.89), RoundingMode.HALF_UP);
            }
            total = total.plus(amt);
        }
        return total;
    }
}
