import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Oisin Mc Laughlin
 * 22441106
 */

/**
 * Tests for the Category class
 * Just ensures that the categories are correct, it's not really needed but it's here for completeness and to practice TDD
 */
public class CategoryTest {
    @Test
    void testExpenseCategories() {
        assertEquals(Category.TRAVEL_AND_SUBSISTENCE, Category.valueOf("TRAVEL_AND_SUBSISTENCE"));
        assertEquals(Category.SUPPLIES, Category.valueOf("SUPPLIES"));
        assertEquals(Category.ENTERTAINMENT, Category.valueOf("ENTERTAINMENT"));
        assertEquals(Category.EQUIPMENT, Category.valueOf("EQUIPMENT"));
        assertEquals(Category.OTHER, Category.valueOf("OTHER"));
    }
}
