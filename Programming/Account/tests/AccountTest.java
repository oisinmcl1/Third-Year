import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountTest {
    @Test
    void test1() {
        Account a = new Account(123);
        assertNotNull(a);
    }
}
