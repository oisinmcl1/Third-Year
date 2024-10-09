import java.util.List;

/*
Oisin Mc Laughlin
22441106
 */

public class PrinterByLabel implements ExpensePrinter{
    @Override
    public void printExpenses(List<Expense> expenses) {
        // Group expenses by category
        for (Category category : Category.values()) {
            boolean hasExpenses = false;

            // Check if there are any expenses in the category
            for (Expense expense : expenses) {
                if (expense.getExpenseCategory().equals(category)) {
                    if (!hasExpenses) {
                        // Only print category if there are expenses in it
                        System.out.println(category);
                        hasExpenses = true;
                    }
                    System.out.println(expense + "\n");
                }
            }
        }
    }
}
