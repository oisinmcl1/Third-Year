import java.time.LocalDate;

/**
 * @author Oisin Mc Laughlin
 * 22441106
 */

public class Achievement {
    private String aName;
    private String aDescription;
    private LocalDate aDate;

    /**
     * Achievment Constructor
     * @param aName
     * @param aDescription
     * @param aDate
     */
    public Achievement(String aName, String aDescription, LocalDate aDate) {
        this.aName = aName;
        this.aDescription = aDescription;
        this.aDate = aDate;
    }

    /**
     * Achievment Name Getter
     * @return aName
     */
    public String getAName() {
        return aName;
    }

    /**
     * Achievment Description Getter
     * @return aDescription
     */
    public String getADescription() {
        return aDescription;
    }

    /**
     * Achievment Date Getter
     * @return aDate
     */
    public LocalDate getADate() {
        return aDate;
    }
}
