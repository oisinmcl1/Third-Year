import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Oisin Mc Laughlin
 * 22441106
 */

public class Player implements Serializable {
    private String pId;
    private String pUsername;
    private Country pCountry;
    private LocalDate pJoinDate;
    // Achievements should not be serialized therefore is transient
    private transient List<Achievement> pAchievements;

    /**
     * Player constructor
     *
     * @param pId
     * @param pUsername
     * @param pCountry
     * @param pJoinDate
     * @param pAchievements (transient)
     */
    public Player(String pId, String pUsername, Country pCountry, LocalDate pJoinDate, List<Achievement> pAchievements) {
        this.pId = pId;
        this.pUsername = pUsername;
        this.pCountry = pCountry;
        this.pJoinDate = pJoinDate;
        this.pAchievements = pAchievements;
    }

    /**
     * Player ID Getter
     *
     * @return pID
     */
    public String getPId() {
        return pId;
    }

    /**
     * Player Username Getter
     *
     * @return pUsername
     */
    public String getPUsername() {
        return pUsername;
    }

    /**
     * Player Country Getter
     *
     * @return pCountry
     */
    public Country getPCountry() {
        return pCountry;
    }

    /**
     * Player Join Date Getter
     *
     * @return pJoinDate
     */
    public LocalDate getPJoinDate() {
        return pJoinDate;
    }

    /**
     * Player Achievements Getter
     *
     * @return pAchievements
     */
    public List<Achievement> getPAchievements() {
        return pAchievements;
    }

    /**
     * Player write object
     * Uses serializable to write object to object output stream
     * Writes default object as well as writing achievements to csv
     * Closes writer
     *
     * @param os
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream os) throws IOException {
        // Write default object
        os.defaultWriteObject();

        // Write achievements to csv
        FileWriter writer = new FileWriter("achievements.csv", true);

        for (Achievement a : pAchievements) {
            writer.append(pId + "," + a.getAName() + "," + a.getADescription() + "," + a.getADate() + "\n");
        }
        // Close
        writer.close();
    }

    /**
     * Player read object
     * Uses serializable to read object from object input stream
     * Reads default object as well as reading achievements from csv
     * Identifies player ID and matches achievements
     * Closes reader
     *
     * @param is
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        // Read default object
        is.defaultReadObject();

        // Read achievements from csv
        pAchievements = new ArrayList<>();
        String playerID = getPId();
        Scanner scanner = new Scanner(new File("achievements.csv"));

        while (scanner.hasNextLine()) {
            String l = scanner.nextLine();
            String[] p = l.split(",");

            // Match player ID with achievements
            if (p[0].equals(playerID)) {
                String aName = p[1];
                String aDesc = p[2];
                LocalDate aDate = LocalDate.parse(p[3]);

                // Create achievement object and add to list
                Achievement a = new Achievement(aName, aDesc, aDate);
                pAchievements.add(a);
            }
        }
        // Close
        scanner.close();
    }
}
