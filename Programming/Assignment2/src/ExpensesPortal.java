import exceptions.InvalidExpenseAmount;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.ArrayList;

import static java.math.BigDecimal.valueOf;

/*
Oisin Mc Laughlin
22441106
 */

public class ExpensesPortal {
    private List<Expense> expenses = new ArrayList<>();

    // Method to add expense to list
    public void addExpense(Expense expense) {
        // Throw exception if expense amount is negative
        if (expense.getExpenseAmount().isNegativeOrZero()) {
            throw new InvalidExpenseAmount("Expense amount must be positive");
        }
        expenses.add(expense);
    }

    // Method to print expenses
    public void printExpenses(ExpensePrinter printer) {
        printer.printExpenses(expenses);
    }

    // Method to get expenses (mostly for testing)
    public List<Expense> getExpenses() {
        return expenses;
    }

    // Method to sum expenses and convert USD to EUR when necessary
    public Money sumExpenses() {
        Money total = Money.zero(CurrencyUnit.EUR);

        for (Expense ex : expenses) {
            Money amt = ex.getExpenseAmount();

            // If currency USD, convert to EUR with exchange rate of 0.85 and round
            if (amt.getCurrencyUnit().equals(CurrencyUnit.USD)) {
                amt = amt.convertedTo(CurrencyUnit.EUR, BigDecimal.valueOf(0.89), RoundingMode.HALF_UP);
            }

            // Add amount (in EUR) to total
            total = total.plus(amt);
        }
        return total;
    }
}
