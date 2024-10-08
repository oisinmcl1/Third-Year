import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/*
Oisin Mc Laughlin
22441106
 */

public class ExpensesPortalTest {
    private ExpensesPortal ep;

    @BeforeEach
    void setUp() {
        // Add some expenses to be tested
        ep = new ExpensesPortal();

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
    }
}
