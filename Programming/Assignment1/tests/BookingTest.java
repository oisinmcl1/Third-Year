import exceptions.InvalidDateException;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

/*
Oisin Mc Laughlin
22441106
 */

public class BookingTest {
    @Test
    void testBookingNotNull() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2025, 8, 12, 16, 30);
        Booking b = null;
        try {
            b = new Booking(420, movilleHealth, bDate);
        }
        catch (InvalidDateException e) {
            fail();
        }

        // Test booking not null
        assertNotNull(b);
    }

    @Test
    void testPatientNumberIsCorrect() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2025, 8, 12, 16, 30);
        Booking b = null;
        try {
            b = new Booking(420, movilleHealth, bDate);
        }
        catch (InvalidDateException e) {
            fail();
        }

        // Test patient number is set correct
        assertEquals(420, b.getPatientNum());
    }

    @Test
    void testHealthPracticeIsCorrect() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2025, 8, 12, 16, 30);
        Booking b = null;
        try {
            b = new Booking(420, movilleHealth, bDate);
        }
        catch (InvalidDateException e) {
            fail();
        }

        // Test health practice set correctly
        assertEquals("Moville GP", b.getHealthPractice().getHealthPracticeName());
    }

    @Test
    void testDateTimeIsCorrect() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2025, 8, 12, 16, 30);
        Booking b = null;
        try {
            b = new Booking(420, movilleHealth, bDate);
        }
        catch (InvalidDateException e) {
            fail();
        }

        // Test datetime set correctly
        assertEquals(bDate, b.getDateTime());
    }

    @Test
    void testSetPatientNumber() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2025, 8, 12, 16, 30);
        Booking b = null;
        try {
            b = new Booking(420, movilleHealth, bDate);
        }
        catch (InvalidDateException e) {
            fail();
        }

        // Test set patient number
        b.setPatientNum(69);
        assertEquals(69, b.getPatientNum());
    }

    @Test
    void testWithoutDate() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");

        // Test booking without date
        Booking b = new Booking(420, movilleHealth);
    }

    @Test
    void testWithoutDateOneMonthAhead() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");

        Booking b = new Booking(420, movilleHealth);

        // Test booking without date is one month ahead
        assertEquals(LocalDateTime.now().plusMonths(1).getMonth(), b.getDateTime().getMonth());
    }

    @Test
    void invalidPatientNumberException() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2025, 8, 12, 16, 30);
        Booking b = null;
        try {
            b = new Booking(420, movilleHealth, bDate);
        }
        catch (InvalidDateException e) {
            fail();
        }

        // Test invalid patient number
        try {
            b.setPatientNum(-1);
        }
        catch (IllegalArgumentException e) {
            assertEquals("Invalid patient number", e.getMessage());
        }
    }

    @Test
    void invalidDateException() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2020, 8, 12, 16, 30);

        // Test invalid date exception is thrown
        assertThrows(InvalidDateException.class, () -> {
            new Booking(420, movilleHealth, bDate);
        });
    }

    @Test
    void uniqueBookingID() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2025, 8, 12, 16, 30);

        Booking.resetBookingCounter();

        // Have to initialse it out here to null because it's not in scope when in the try block??
        Booking b1 = null;
        Booking b2 = null;

        try {
            b1 = new Booking(420, movilleHealth, bDate);
            b2 = new Booking(421, movilleHealth, bDate);
        }
        catch (InvalidDateException e) {
            fail();
        }

        // Test booking ID is unique
        assertEquals(1, b1.getBookingID());
        assertEquals(2, b2.getBookingID());
    }

    @Test
    void testBookingToString() {
        HealthPractice movilleHealth = new HealthPractice("Moville GP", "Moville");
        LocalDateTime bDate = LocalDateTime.of(2025, 8, 12, 16, 30);

        Booking.resetBookingCounter();

        Booking b = null;
        try {
            b = new Booking(420, movilleHealth, bDate);
        }
        catch (InvalidDateException e) {
            fail();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy 'at' HH:mm");
        String formattedDate = bDate.format(formatter);

        String expected = "Booking ID Number: 1\n"
                        + "Patient Number: 420\n"
                        + "Health Practice: Moville GP\n"
                        + "Address: Moville\n"
                        + "Date & Time: On " + formattedDate + "\n";

        /*
        str += "Booking ID Number: " + bookingID + "\n";
        str += "Patient Number: " + patientNum + "\n";
        str += "Health Practice: " + hP.getHealthPracticeName() + "\n";
        str += "Address: " + hP.getHealthPracticeAddress() + "\n";
        str += "Date & Time: " + dateTime + "\n";
         */

        System.out.println(b.toString());
        System.out.println(expected);

        // Test ToString method from booking is correct!
        assertEquals(expected, b.toString());
    }
}
