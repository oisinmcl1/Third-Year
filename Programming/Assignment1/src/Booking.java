import java.time.LocalDateTime;

public class Booking {
    private int pNum;
    private HealthPractice hP;
    private LocalDateTime dateTime;

    public Booking(int pNum, HealthPractice hP, LocalDateTime dateTime) {
        this.pNum = pNum;
        this.hP = hP;
        this.dateTime = dateTime;
    }
}
