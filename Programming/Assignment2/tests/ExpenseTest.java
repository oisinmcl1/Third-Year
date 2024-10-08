import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
        Expense ex = new Expense(LocalDate.of(2022, 8, 12), null);
        try {
            ex.getExpenseDate();
        }
        catch (Exception e) {
            fail("getExpenseDate() threw an exception");
        }

        // Test that the date is correct
        assertEquals(LocalDate.of(2022, 8, 12), ex.getExpenseDate());
    }
    @Test
    void testExpenseSetDate() {
        Expense ex = new Expense(null, null);
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
        Expense ex = new Expense(null, "Test Description");
        try {
            ex.getExpenseDescription();
        }
        catch (Exception e) {
            fail("getExpenseDescription() threw an exception");
        }
    }
    @Test
    void testExpenseSetDescription() {
        Expense ex = new Expense(null, null);
        try {
            ex.setExpenseDescription("Test Description");
        }
        catch(Exception e) {
            fail("setExpenseDescription() threw an exception");
        }

        // Test that set description is correct
        assertEquals("Test Description", ex.getExpenseDescription());
    }

    //
}
