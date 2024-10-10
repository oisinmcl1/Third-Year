import java.util.List;

/**
 * Groups expenses by category and prints them in a structured format.
 * Each category is printed along with its respective expenses.
 *
 * @author Oisin Mc Laughlin
 * 22441106
 */
public class PrinterByLabel implements ExpensePrinter {

    /**
     * Prints the expenses grouped by their categories.
     *
     * @param expenses The list of expenses to be printed
     */
    @Override
    public void printExpenses(List<Expense> expenses) {
        for (Category category : Category.values()) {
            boolean hasExpenses = false;
            for (Expense expense : expenses) {
                if (expense.getExpenseCategory().equals(category)) {
                    if (!hasExpenses) {
                        System.out.println(category);
                        hasExpenses = true;
                    }
                    System.out.println(expense + "\n");
                }
            }
        }
    }
}
