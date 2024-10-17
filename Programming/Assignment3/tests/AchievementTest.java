import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/*
Oisin Mc Laughlin
22441106
 */

public class AchievementTest {
    @Test
    void testAchievementCreateObj() {
        // Testing can create player object
        Achievement a = new Achievement(null, null, null);
        assertNotNull(a);
    }

    @Test
    void testAchievmentName() {
        // Testing can get the achievement name
        Achievement a = new Achievement("MVP", null, null);
        assertEquals("MVP", a.getAName());
    }

    @Test
    void testAchievementDescription() {
        // Testing can get the achievment description
        Achievement a = new Achievement(null, "Earned in Snooker varsities", null);
        assertEquals("Earned in Snooker varsities", a.getADescription());
    }

    @Test
    void testAchievementDate() {
        // Testomg can get achievement description
        Achievement a = new Achievement(null, null, LocalDate.of(2021, 1, 1));
        assertEquals(LocalDate.of(2021, 1, 1), a.getADate());
    }
}
