import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookingTest {
    @Test
    void testObject() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime today = LocalDateTime.now();
        Booking b = new Booking(420, movilleHealth, today);
    }
    /*void testCreateBooking() {
        HealthPractice hP = new HealthPractice();
        Booking booking = new Booking(1, hP);
        assertNotNull(booking);
    }*/
}
