import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookingTest {
    @Test
    void test() {
        Booking b = new Booking();

        assertNotNull(b);
    }
}
