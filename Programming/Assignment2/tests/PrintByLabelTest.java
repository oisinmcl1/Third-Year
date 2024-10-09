import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/*
Oisin Mc Laughlin
22441106
 */

public class PrintByLabelTest {
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

        // Print expenses
        ep.printExpenses(printer);

        // Print by label should print the category of the expense
        printer.printExpenses(ep.getExpenses());
    }
}
