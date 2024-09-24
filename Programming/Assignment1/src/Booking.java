import java.time.LocalDateTime;

/*
Oisin Mc Laughlin
22441106
 */

public class Booking {
    private int patientNum;
    private HealthPractice hP;
    private LocalDateTime dateTime;

    public Booking(int patientNum, HealthPractice hP, LocalDateTime dateTime) {
        this.patientNum = patientNum;
        this.hP = hP;
        this.dateTime = dateTime;
    }

    // Getters
    public int getPatientNum() {
        return patientNum;
    }
    public HealthPractice getHealthPractice() {
        return hP;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // Setters
    public void setPatientNum(int patientNum) {
        this.patientNum = patientNum;
    }
}
