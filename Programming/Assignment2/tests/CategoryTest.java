import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
