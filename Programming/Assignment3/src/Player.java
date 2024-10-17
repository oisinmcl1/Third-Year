import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/*
Oisin Mc Laughlin
22441106
 */

public class Player implements Serializable {
    private String pId;
    private String pUsername;
    private Country pCountry;
    private LocalDate pJoinDate;
    private List<Achievement> pAchievements;

    public Player(String pId, String pUsername, Country pCountry, LocalDate pJoinDate, List<Achievement> pAchievements) {
        this.pId = pId;
        this.pUsername = pUsername;
        this.pCountry = pCountry;
        this.pJoinDate = pJoinDate;
        this.pAchievements = pAchievements;
    }

    // Getters
    public String getPId() {
        return pId;
    }
    public String getPUsername() {
        return pUsername;
    }
    public Country getPCountry() {
        return pCountry;
    }
    public LocalDate getPJoinDate() {
        return pJoinDate;
    }
    public List<Achievement> getPAchievements() {
        return pAchievements;
    }
}
