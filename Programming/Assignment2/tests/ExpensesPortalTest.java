import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/*
Oisin Mc Laughlin
22441106
 */

public class ExpensesPortalTest {

    @Test
    void testAddExpensesLambda() {
        ExpensesPortal ep = new ExpensesPortal();

        // Add some expenses
        ep.addExpense(new Expense(
                LocalDate.of(2022, 8, 12),
                "HP 29-inch monitor",
                Category.EQUIPMENT,
                Money.of(CurrencyUnit.EUR, 610.00)
        ));
        ep.addExpense(new Expense(
                LocalDate.of(2023, 9, 13),
                "Flight to Knock",
                Category.TRAVEL_AND_SUBSISTENCE,
                Money.of(CurrencyUnit.EUR, 2300.00)
        ));
        ep.addExpense(new Expense(
                LocalDate.of(2024, 10, 14),
                "Coffee in Smokeys",
                Category.OTHER,
                Money.of(CurrencyUnit.EUR, 18.00)
        ));

        // Use lambda expression to print expenses that were added
        // String output = "";
        StringBuilder sb = new StringBuilder();

        ep.printExpenses(expenses -> {
            for (Expense expense : expenses) {
                System.out.println(expense);
                // output += expense + "\n";
                sb.append(expense).append("\n");
            }
        });

        // Test correct number of expensees added and correct output
        assertEquals(3, ep.getExpenses().size());
        // assertEquals(expected, output);
        String expected = "" +
                "2022-08-12: HP 29-inch monitor - EQUIPMENT - EUR 610.00\n" +
                "2023-09-13: Flight to Knock - TRAVEL_AND_SUBSISTENCE - EUR 2300.00\n" +
                "2024-10-14: Coffee in Smokeys - OTHER - EUR 18.00\n";

        assertEquals(expected, sb.toString());
    }

    @Test
    void testSumExpensesInnerClass() {
        ExpensesPortal ep = new ExpensesPortal();

        // Add some expenses
        ep.addExpense(new Expense(
                LocalDate.of(2022, 8, 12),
                "HP 29-inch monitor",
                Category.EQUIPMENT,
                Money.of(CurrencyUnit.USD, 610.00)
        ));
        ep.addExpense(new Expense(
                LocalDate.of(2023, 9, 13),
                "Flight to Knock",
                Category.TRAVEL_AND_SUBSISTENCE,
                Money.of(CurrencyUnit.USD, 2300.00)
        ));
        ep.addExpense(new Expense(
                LocalDate.of(2024, 10, 14),
                "Coffee in Smokeys",
                Category.OTHER,
                Money.of(CurrencyUnit.USD, 18.00)
        ));

        StringBuilder sb = new StringBuilder();

        // Use anonymous inner class to print expenses that were added
        ep.printExpenses(new ExpensePrinter() {
            @Override
            public void printExpenses(List<Expense> expenses) {
                Money total = ep.sumExpenses();
                sb.append("There are ").append(expenses.size()).append(" expenses in the system totaling EUR ").append(total).append("\n");

                System.out.println("There are " + expenses.size() + " expenses in the system totaling EUR " + total);
            }
        });
        String expected = "There are 3 expenses in the system totaling EUR EUR 2605.92\n";

        // Test correct number of expenses added and correct output
        assertEquals(expected, sb.toString());
    }
}
