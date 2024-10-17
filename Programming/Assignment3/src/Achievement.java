import java.time.LocalDate;

/*
Oisin Mc Laughlin
22441106
 */

public class Achievement {
    private String aName;
    private String aDescription;
    private LocalDate aDate;

    public Achievement(String aName, String aDescription, LocalDate aDate) {
        this.aName = aName;
        this.aDescription = aDescription;
        this.aDate = aDate;
    }

    // Getters
    public String getAName() {
        return aName;
    }
    public String getADescription() {
        return aDescription;
    }
    public LocalDate getADate() {
        return aDate;
    }
}
