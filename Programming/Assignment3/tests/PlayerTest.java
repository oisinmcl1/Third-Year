import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/*
Oisin Mc Laughlin
22441106
 */

public class PlayerTest {
    @Test
    void testPlayerCreateObj() {
        // Testing can create a Player object
        Player p = new Player(null, null, null, null, null);
        assertNotNull(p);
    }

    @Test
    void testPlayerId() {
        // Testing can get the player id
        Player p = new Player("1", null, null, null, null);
        assertEquals("1", p.getPId());
    }

    @Test
    void testPlayerUsername() {
        // Testing can get the player username
        Player p = new Player(null, "user", null, null, null);
        assertEquals("user", p.getPUsername());
    }

    @Test
    void testPlayerCountry() {
        // Testing can get the player country
        Player p = new Player(null, null, Country.IRELAND, null, null);
        assertEquals(Country.IRELAND, p.getPCountry());
    }

    @Test
    void testPlayerJoinDate() {
        // Testing can get the player join date
        Player p = new Player(null, null, null, LocalDate.of(2021, 1, 1), null);
        assertEquals(LocalDate.of(2021, 1, 1), p.getPJoinDate());
    }

    @Test
    void testPlayerAchievements() {
        // Testing can get the player achievements
        Player p = new Player(null, null, null, null,
                List.of(new Achievement(
                        "MVP",
                        "Ach1",
                        LocalDate.of(2021, 1, 1)))
        );

        assertEquals(1, p.getPAchievements().size());

        assertEquals("MVP", p.getPAchievements().get(0).getAName());
        assertEquals("Ach1", p.getPAchievements().get(0).getADescription());
        assertEquals(LocalDate.of(2021, 1, 1), p.getPAchievements().get(0).getADate());
    }
}
