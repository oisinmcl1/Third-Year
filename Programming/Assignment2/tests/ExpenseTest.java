import org.joda.money.CurrencyUnit;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.joda.money.Money;

/*
Oisin Mc Laughlin
22441106
 */

public class ExpenseTest {
    /*@Test
    void testExpenseNotNull() {
        Expense ex = new Expense();
        assertNotNull(ex);
    }*/

    // Getters and setters for Date in Expense class
    @Test
    void testExpenseGetDate() {
        Expense ex = new Expense(LocalDate.of(2022, 8, 12), null, null, null);

        // Test that the date is correct
        assertEquals(LocalDate.of(2022, 8, 12), ex.getExpenseDate());
    }
    @Test
    void testExpenseSetDate() {
        Expense ex = new Expense(null, null, null, null);
        try {
            ex.setExpenseDate(LocalDate.of(2022, 8, 12));
        }
        catch(Exception e) {
            fail("setDate() threw an exception");
        }

        // Test that set date is correct
        assertEquals(LocalDate.of(2022, 8, 12), ex.getExpenseDate());
    }

    // Getters and Setters for Description in Expense class
    @Test
    void testExpenseGetDescription() {
        Expense ex = new Expense(null, "Test Description", null, null);

        // Test that the description is correct
        assertEquals("Test Description", ex.getExpenseDescription());
    }
    @Test
    void testExpenseSetDescription() {
        Expense ex = new Expense(null, null, null, null);
        try {
            ex.setExpenseDescription("Test Description");
        }
        catch(Exception e) {
            fail("setExpenseDescription() threw an exception");
        }

        // Test that set description is correct
        assertEquals("Test Description", ex.getExpenseDescription());
    }

    // Getters and Setters for Category in Expense class
    @Test
    void testExpenseApprovedDefault() {
        Expense ex = new Expense(null, null, null, null);

        // Check default value of expenseApproved (should be false)
        assertFalse(ex.getExpenseApproved());
    }
    @Test
    void testExpenseSetApproved() {
        Expense ex = new Expense(null, null, null, null);

        try {
            ex.approve();
        }
        catch (Exception e) {
            fail("setExpenseApproved() threw an exception");
        }

        // See if expenseApproved is now true
        assertTrue(ex.getExpenseApproved());
    }

    @Test
    void testExpenseGetCategory() {
        Expense ex = new Expense(null, null, Category.EQUIPMENT, null);

        // Test that the category is correct
        assertEquals(Category.EQUIPMENT, ex.getExpenseCategory());
    }

    @Test
    void testExpenseAmount() {
        Expense ex = new Expense(null, null, null, Money.of(CurrencyUnit.EUR, 420.00));

        // Test that the amount is correct
        assertEquals(Money.of(CurrencyUnit.EUR, 420.00), ex.getExpenseAmount());
    }

    // Testing toString in Expense class
    @Test
    void testToString () {
        /*
        str += expenseDate + ": ";
        str += expenseDescription + " - ";
        str += expenseCategory + " - ";
        str += expenseAmount;
        */

        Expense ex = new Expense(
                LocalDate.of(2022, 8, 12),
                "HP 29-inch monitor",
                Category.EQUIPMENT,
                Money.of(CurrencyUnit.EUR, 610.00)
        );

        String expected = "2022-08-12: HP 29-inch monitor - EQUIPMENT - EUR 610.00";
        assertEquals(expected, ex.toString());
    }
}
