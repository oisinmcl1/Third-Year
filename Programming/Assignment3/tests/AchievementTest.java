import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Oisin Mc Laughlin
 * 22441106
 */
public class AchievementTest {
    /**
     * Test to see if the achievement object can be created
     * @asserts the object is not null
     */
    @Test
    void testAchievementCreateObj() {
        Achievement a = new Achievement(null, null, null);
        assertNotNull(a);
    }

    /**
     * Test to see if the achievement object can be created with a name
     * @asserts expected name matches actual name
     */
    @Test
    void testAchievmentName() {
        Achievement a = new Achievement("MVP", null, null);
        assertEquals("MVP", a.getAName());
    }

    /**
     * Test to see if the achievement object can be created with a description
     * @asserts expected description matches actual description
     */
    @Test
    void testAchievementDescription() {
        Achievement a = new Achievement(null, "Earned in Snooker varsities", null);
        assertEquals("Earned in Snooker varsities", a.getADescription());
    }

    /**
     * Test to see if the achievement object can be created with a date
     * @asserts expected date matches actual date
     */
    @Test
    void testAchievementDate() {
        Achievement a = new Achievement(null, null, LocalDate.of(2021, 1, 1));
        assertEquals(LocalDate.of(2021, 1, 1), a.getADate());
    }
}
