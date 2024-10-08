import java.util.List;
import java.util.ArrayList;

/*
Oisin Mc Laughlin
22441106
 */

public class ExpensesPortal {
    private List<Expense> expenses = new ArrayList<>();

    // Method to add expense to list
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    // Method to print expenses
    public void printExpenses(ExpensePrinter printer) {
        printer.print(expenses);
    }
}
