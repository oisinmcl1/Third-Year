import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Oisin Mc Laughlin
 * 22441106
 */

public class PlayerTest {
    /**
     * Tests to see if player object can be created
     *
     * @asserts Player object is not null
     */
    @Test
    void testPlayerCreateObj() {
        Player p = new Player(null, null, null, null, null);
        assertNotNull(p);
    }

    /**
     * Tests to see if player object can be created with playerID
     *
     * @asserts expected player ID matches actual player ID
     */
    @Test
    void testPlayerId() {
        Player p = new Player("1", null, null, null, null);
        assertEquals("1", p.getPId());
    }

    /**
     * Tests to see if player object can be created with player username
     *
     * @asserts expected player username matches actual player username
     */
    @Test
    void testPlayerUsername() {
        Player p = new Player(null, "Oisín", null, null, null);
        assertEquals("Oisín", p.getPUsername());
    }

    /**
     * Tests to see if player object can be created with player country
     *
     * @asserts expected player country matches actual player country
     */
    @Test
    void testPlayerCountry() {
        Player p = new Player(null, null, Country.IRELAND, null, null);
        assertEquals(Country.IRELAND, p.getPCountry());
    }

    /**
     * Tests to see if player object can be created with player join date
     *
     * @asserts expected player join date matches actual player join date
     */
    @Test
    void testPlayerJoinDate() {
        Player p = new Player(null, null, null, LocalDate.of(2021, 1, 1), null);
        assertEquals(LocalDate.of(2021, 1, 1), p.getPJoinDate());
    }

    /**
     * Tests to see if player object can be created with player achievements
     *
     * @asserts Number of player achievements is matching expected number of player achievements
     * @asserts expected player achievements matches actual player achievements
     * @asserts expected player achievements description matches actual player achievements description
     * @asserts expected player achievements date matches actual player achievements date
     */
    @Test
    void testPlayerAchievements() {
        List<Achievement> a = new ArrayList<>();
        a.add(new Achievement("MVP", "Ach1", LocalDate.of(2021, 1, 1)));

        Player p = new Player(null, null, null, null, a);

        assertEquals(1, p.getPAchievements().size());

        assertEquals("MVP", p.getPAchievements().get(0).getAName());
        assertEquals("Ach1", p.getPAchievements().get(0).getADescription());
        assertEquals(LocalDate.of(2021, 1, 1), p.getPAchievements().get(0).getADate());
    }

    /**
     * Test to see if the player object gets serialized correctly (excluding achievements)
     * Attempt to serialize the player object to a file player.ser
     *
     * @throws IOException
     * @asserts player.ser file exists
     * @asserts achievments.csv file was written
     */
    @Test
    void testPlayerSerializationandAchCsv() throws IOException {
        List<Achievement> a = new ArrayList<>();
        a.add(new Achievement("MVP", "Ach1", LocalDate.of(2021, 1, 1)));
        a.add(new Achievement("GOAT", "Ach2", LocalDate.of(2022, 2, 2)));
        a.add(new Achievement("147", "Ach3", LocalDate.of(2023, 3, 3)));

        Player p = new Player("1", "Oisín", Country.IRELAND, LocalDate.of(2021, 1, 1), a);

        ObjectOutputStream out = null;

        // Serialize the player object to a file
        out = new ObjectOutputStream(new FileOutputStream("player.ser"));
        out.writeObject(p);
        out.close();

        // Check if the file player.ser exists
        File pFile = new File("player.ser");
        assertTrue(pFile.exists());

        // Check if achievements.csv file was written
        File aFile = new File("achievements.csv");
        assertTrue(aFile.exists());
    }

    /**
     * Test to see if the player object gets deserialized correctly
     * The csv has to be deleted first since it has to be rewritten, not sure what a better approach to this would be tbh
     * As well as testing loading from achievements.csv
     *
     * @throws IOException
     * @throws ClassNotFoundException
     * @asserts expected player ID matches actual player ID from deserialized player object
     * @asserts expected player username matches actual player username from deserialized player object
     * @asserts expected player country matches actual player country from deserialized player object
     * @asserts expected player join date matches actual player join date from deserialized player object
     * @asserts expected player achievements matches actual player achievements from csv
     * @asserts expected player achievements description matches actual player achievements description from csv
     * @asserts expected player achievements date matches actual player achievements date from csv
     */
    @Test
    void testPlayerDeserializationAndAchCsv() throws IOException, ClassNotFoundException {
        // Delete csv file if it exists because it needs to be written again
        if (new File("achievements.csv").exists()) {
            new File("achievements.csv").delete();
        }


        List<Achievement> a = new ArrayList<>();
        a.add(new Achievement("MVP", "Ach1", LocalDate.of(2021, 1, 1)));
        a.add(new Achievement("GOAT", "Ach2", LocalDate.of(2022, 2, 2)));
        a.add(new Achievement("147", "Ach3", LocalDate.of(2023, 3, 3)));

        Player p = new Player("1", "Oisín", Country.IRELAND, LocalDate.of(2021, 1, 1), a);

        ObjectOutputStream out = null;

        // Serialize the player object to a file
        out = new ObjectOutputStream(new FileOutputStream("player.ser"));
        out.writeObject(p);
        out.close();

        ObjectInputStream in = null;

        // Deserialize the player object from the file
        in = new ObjectInputStream(new FileInputStream("player.ser"));
        Player desPlayer = (Player) in.readObject();
        in.close();

        // Check if the player object was deserialized correctly
        assertEquals("1", desPlayer.getPId());
        assertEquals("Oisín", desPlayer.getPUsername());
        assertEquals(Country.IRELAND, desPlayer.getPCountry());
        assertEquals(LocalDate.of(2021, 1, 1), desPlayer.getPJoinDate());

        // Check if achievements loaded from achievements.csv correctly
        assertEquals(3, desPlayer.getPAchievements().size());

        assertEquals("MVP", desPlayer.getPAchievements().get(0).getAName());
        assertEquals("Ach1", desPlayer.getPAchievements().get(0).getADescription());
        assertEquals(LocalDate.of(2021, 1, 1), desPlayer.getPAchievements().get(0).getADate());

        assertEquals("GOAT", desPlayer.getPAchievements().get(1).getAName());
        assertEquals("Ach2", desPlayer.getPAchievements().get(1).getADescription());
        assertEquals(LocalDate.of(2022, 2, 2), desPlayer.getPAchievements().get(1).getADate());

        assertEquals("147", desPlayer.getPAchievements().get(2).getAName());
        assertEquals("Ach3", desPlayer.getPAchievements().get(2).getADescription());
        assertEquals(LocalDate.of(2023, 3, 3), desPlayer.getPAchievements().get(2).getADate());
    }

    /**
     * Test to see if I can create several players with several achievements
     * Delete csv file if it exists because it needs to be written again
     * Populate players and achievements
     *
     * Serialize the list of players and write achievements to csv
     * Deserialize the list of players and read achievements from csv
     *
     * Checks player object was deserialized correctly
     * Checks achievements loaded from achievements.csv correctly
     *
     * @throws IOException
     * @throws ClassNotFoundException
     *
     * @asserts expected player ID matches actual player ID from deserialized player object
     * @asserts expected player username matches actual player username from deserialized player object
     * @asserts expected player country matches actual player country from deserialized player object
     * @asserts expected player join date matches actual player join date from deserialized player object
     *
     * @asserts expected number of player achievements matches actual number of player achievements
     * @asserts expected player achievements name matches actual player achievements name from csv
     * @asserts expected player achievements description matches actual player achievements description from csv
     * @asserts expected player achievements date matches actual player achievements date from csv
     */
    @Test
    void testSeveralPlayers() throws IOException, ClassNotFoundException {
        // Delete csv file if it exists because it needs to be written again
        if (new File("achievements.csv").exists()) {
            new File("achievements.csv").delete();
        }

        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        // Populate list of players and achievements
        List<Player> p = new ArrayList<>();
        List<Achievement> a;

        for (int i = 0; i < 5; i++) {
            a = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                a.add(new Achievement(
                        "Achievement " + i + "-" + j,
                        "Ach" + i + "-" + j,
                        LocalDate.of(2021, i + 1, j + 1)
                ));
            }
            p.add(new Player(
                    Integer.toString(i),
                    "Player " + i,
                    Country.USA,
                    LocalDate.of(2021, 1, i + 1),
                    a
            ));
        }

        // Serialize the list of players and write achievements to csv
        out = new ObjectOutputStream(new FileOutputStream("player.ser"));

        for (Player player : p) {
            out.writeObject(player);
        }

        out.close();

        // Deserialize the list of players and read achievements from csv
        in = new ObjectInputStream(new FileInputStream("player.ser"));

        for (int i = 0; i < 5; i++) {
            // For each player object, check if the player object was deserialized correctly
            Player desPlayer = (Player) in.readObject();

            assertEquals(Integer.toString(i), desPlayer.getPId());
            assertEquals("Player " + i, desPlayer.getPUsername());
            assertEquals(Country.USA, desPlayer.getPCountry());
            assertEquals(LocalDate.of(2021, 1, i + 1), desPlayer.getPJoinDate());

            assertEquals(3, desPlayer.getPAchievements().size()); // Corrected assertion

            for (int j = 0; j < 3; j++) {
                // Check if achievements loaded from achievements.csv correctly
                assertEquals("Achievement " + i + "-" + j, desPlayer.getPAchievements().get(j).getAName());
                assertEquals("Ach" + i + "-" + j, desPlayer.getPAchievements().get(j).getADescription());
                assertEquals(LocalDate.of(2021, i + 1, j + 1), desPlayer.getPAchievements().get(j).getADate());
            }
        }
        in.close();
    }
}
