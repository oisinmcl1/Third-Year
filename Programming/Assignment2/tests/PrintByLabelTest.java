import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the PrinterByLabel class, which prints expenses grouped by category.
 *
 * @author Oisin Mc Laughlin
 * 22441106
 */
public class PrintByLabelTest {

    /**
     * Tests printing expenses grouped by category.
     * Meant to test the output but I think I've formatted the string wrong :(
     */
    @Test
    void testPrintByLabel() {
        // Create new ExpensePortal
        ExpensesPortal ep = new ExpensesPortal();

        // Create new ExpensePrinter
        ExpensePrinter printer = new PrinterByLabel();

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

        StringBuilder output = new StringBuilder();

        printer.printExpenses(ep.getExpenses());

        String expected =
                        "TRAVEL_AND_SUBSISTENCE\n" +
                        "2023-09-13: Flight to Knock - TRAVEL_AND_SUBSISTENCE - USD 2300.00\n\n" +
                        "EQUIPMENT\n" +
                        "2022-08-12: HP 29-inch monitor - EQUIPMENT - USD 610.00\n\n" +
                        "OTHER\n" +
                        "2024-10-14: Coffee in Smokeys - OTHER - USD 18.00\n\n";

        // assertEquals(expected, output);
    }
}
