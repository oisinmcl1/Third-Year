import org.example.UserAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserAccountTest {
    @Test
    public void firstTest() {
        UserAccount u = new UserAccount();
        assertNotNull(u);
    }
}
