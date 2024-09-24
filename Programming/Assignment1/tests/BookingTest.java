import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
Oisin Mc Laughlin
22441106
 */

public class BookingTest {
    @Test
    void testBookingNotNull() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2020, 8, 12, 16, 30);
        Booking b = new Booking(420, movilleHealth, bDate);

        // Test booking not null
        assertNotNull(b);
    }

    @Test
    void testPatientNumberIsCorrect() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2020, 8, 12, 16, 30);
        Booking b = new Booking(420, movilleHealth, bDate);

        // Test patient number is set correct
        assertEquals(420, b.getPatientNum());
    }

    @Test
    void testHealthPracticeIsCorrect() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2020, 8, 12, 16, 30);
        Booking b = new Booking(420, movilleHealth, bDate);

        // Test health practice set correctly
        assertEquals("Moville GP", b.getHealthPractice().getHealthPracticeName());
    }

    @Test
    void testDateTimeIsCorrect() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2020, 8, 12, 16, 30);
        Booking b = new Booking(420, movilleHealth, bDate);

        // Test datetime set correctly
        assertEquals(bDate, b.getDateTime());
    }

    @Test
    void testSetPatientNumber() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2020, 8, 12, 16, 30);
        Booking b = new Booking(420, movilleHealth, bDate);

        // Test set patient number
        b.setPatientNum(69);
        assertEquals(69, b.getPatientNum());
    }
}
