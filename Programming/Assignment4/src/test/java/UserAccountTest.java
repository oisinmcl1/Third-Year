import org.example.UserAccount;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class UserAccountTest {
    @Test
    public void testUserAccountObj() {
        // Test you can create a UserAccount object
        UserAccount u = new UserAccount(0, null, null);
        assertNotNull(u);
    }

    @Test
    public void testUserAccountUserID() {
        // Test you can get userID
        UserAccount u = new UserAccount(420, null, null);
        assertEquals(420, u.getUserID());
    }

    @Test
    public void testUserAccountName() {
        // Test you can get name
        UserAccount u = new UserAccount(0, "Oisín", null);
        assertEquals("Oisín", u.getName());
    }

    @Test
    public void testUserAccountEmailAddress() {
        // Test you can get emailAddress
        UserAccount u = new UserAccount(0, null, "o.mclaughlin2@universityofgalway.ie");
        assertEquals("o.mclaughlin2@universityofgalway.ie", u.getEmailAddress());
    }

    @Test
    public void testUserAccountToString() {
        // Test you can get a string representation of UserAccount
        UserAccount u = new UserAccount(420, "Oisín", "o.mclaughlin2@universityofgalway.ie");

        /*
        str += "User ID: " + userID + "\n";
        str += "Name: " + name + "\n";
        str += "Email Address: " + emailAddress + "\n";
         */
        String expected =
                        "User ID: 420\n" +
                        "Name: Oisín\n" +
                        "Email Address: o.mclaughlin2@universityofgalway.ie\n";

//        System.out.println(u.toString());
//        System.out.println(expected);

        assertEquals(expected, u.toString());
    }

    @Test
    public void testLoadUsersFromCsv() throws IOException {
        // Test you can load users from a CSV file
        List<UserAccount> users = new ArrayList<>();
        Scanner scanner = new Scanner(new File("src/main/resources/users.csv"));

        // Populate users with data from CSV file by looping through each line and creating obj for each
        // UserAccount(long userID, String name, String emailAddress)
        while (scanner.hasNextLine()) {
            String l = scanner.nextLine();
            String[] p = l.split(", ");

            // Get the userID, name and email address from the line
            long userID = Long.parseLong(p[0]);
            String name = p[1];
            String emailAddress = p[2];

            // Create the object and add it to the list
            UserAccount u = new UserAccount(userID, name, emailAddress);
            users.add(u);
        }
        scanner.close();

        assertEquals(10, users.size());

        // Verify first user
        assertEquals(123, users.get(0).getUserID());
        assertEquals("Michael Scott", users.get(0).getName());
        assertEquals("michael@dundermifflin.com", users.get(0).getEmailAddress());

        // Verify last user
        assertEquals(192, users.get(9).getUserID());
        assertEquals("Andy Bernard", users.get(9).getName());
        assertEquals("andy@dundermifflin.com", users.get(9).getEmailAddress());
    }
}
