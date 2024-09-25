/*
Oisin Mc Laughlin
22441106
 */

public class HealthPractice {
    private String healthName;
    private String healthAddress;

    public HealthPractice(String healthName, String healthAddress) {
        this.healthName = healthName;
        this.healthAddress = healthAddress;
    }

    // Getters
    public String getHealthPracticeName() {
        return healthName;
    }
    public String getHealthPracticeAddress() {
        return healthAddress;
    }

    // Setters
    public void setHealthPracticeName (String healthName) {
        this.healthName = healthName;
    }
    public void setHealthPracticeAddress(String healthAddress) {
        this.healthAddress = healthAddress;
    }
}
