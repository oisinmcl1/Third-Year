import org.example.UserAccount;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Oisin Mc Laughlin
 * 22441106
 */

public class UserAccountTest {
    /**
     * Test to see if you can create a UserAccount object
     *
     * @asserts UserAccount object is not null
     */
    @Test
    public void testUserAccountObj() {
        // Test you can create a UserAccount object
        UserAccount u = new UserAccount(0, null, null);
        assertNotNull(u);
    }

    /**
     * Test to see if you can get the userID from a UserAccount object
     *
     * @asserts userID is equal to 420
     */
    @Test
    public void testUserAccountUserID() {
        // Test you can get userID
        UserAccount u = new UserAccount(420, null, null);
        assertEquals(420, u.getUserID());
    }

    /**
     * Test to see if you can get the name from a UserAccount object
     *
     * @asserts name is equal to "Oisín"
     */
    @Test
    public void testUserAccountName() {
        // Test you can get name
        UserAccount u = new UserAccount(0, "Oisín", null);
        assertEquals("Oisín", u.getName());
    }

    /**
     * Test to see if you can get the emailAddress from a UserAccount object
     *
     * @asserts emailAddress is equal to "o.mclaughlin2@universityofgalway.ie"
     */
    @Test
    public void testUserAccountEmailAddress() {
        // Test you can get emailAddress
        UserAccount u = new UserAccount(0, null, "o.mclaughlin2@universityofgalway.ie");
        assertEquals("o.mclaughlin2@universityofgalway.ie", u.getEmailAddress());
    }

    /**
     * Tests account toString method to see if it returns a formatted string with userID, name, emailAddress
     *
     * @asserts formatted string with userID, name, emailAddress is equal to expected string
     */
    @Test
    public void testUserAccountToString() {
        // Test you can get a string representation of UserAccount
        UserAccount u = new UserAccount(
                420,
                "Oisín",
                "o.mclaughlin2@universityofgalway.ie"
        );

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

    /**
     * Test to see jf you can load users from a CSV file
     * Populates a list of UserAccount objects with data from a CSV file
     * Each line in the CSV file is a new UserAccount object which has a userID, name and emailAddress
     *
     * @throws IOException
     * @asserts size of list is equal to 10 which is the number of lines in the CSV file
     * @asserts first user in list has userID 123, name "Michael Scott" and emailAddress "michael@dundermifflin.com" (same as first line in CSV file)
     * @asserts last user in list has userID 192, name "Andy Bernard" and emailAddress "andy@dundermifflin.com" (same as last line in CSV file)
     */
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

    /**
     * Test natural ordering of UserAccount objects by emailAddress
     * Sorts a list of UserAccount objects by emailAddress
     *
     * @asserts first and last user before sorting (should be in order added)
     * @asserts first and last user after sorting (should be in order of email address)
     */
    @Test
    public void testNaturalOrderEmail() {
        // Add users to list
        List<UserAccount> users = new ArrayList<>();

        users.add(
                new UserAccount(
                        123,
                        "Michael Scott",
                        "michael@dundermifflin.com"
                )
        );
        users.add(
                new UserAccount(
                        456,
                        "Dwight Schrute",
                        "dwight@dundermifflin.com"
                )
        );
        users.add(
                new UserAccount(
                        789,
                        "Jim Halpert",
                        "jim@dundermifflin.com"
                )
        );

        // Before sorting list should be in order Michael, Dwight, Jim (order added)
        // Comparing first and last values
        assertEquals("Michael Scott", users.get(0).getName());
        assertEquals("Jim Halpert", users.get(2).getName());

        // Sort the list
        // Order should now be Dwight, Jim, Michael
        Collections.sort(users);

        // Comparing first and last values after sorting
        assertEquals("Dwight Schrute", users.get(0).getName());
        assertEquals("Michael Scott", users.get(2).getName());
    }

    /**
     * Test equals method for UserAccount
     * Compares two UserAccount objects to see if they are equal
     * Two UserAccount objects are equal if their userID is the same
     *
     * @asserts true if object is compared to itself
     * @asserts false if object is compared to null
     * @asserts false if object is compared to a different object
     * @asserts true if userID's are equal
     */
    @Test
    public void testUserAccountEquals() {
        // Create user accounts
        UserAccount u1 = new UserAccount(
                123,
                "Michael Scott",
                "michael@dundermifflin.com"
        );
        UserAccount u2 = new UserAccount(
                456,
                "Dwight Schrute",
                "dwight@dundermifflin.com"
        );
        UserAccount u3 = new UserAccount(
                123,
                "David Brent (Office UK)",
                "david@wernhamhogg.co.uk"
        );

        // Check u1 with u1 (should be equal)
        assertTrue(u1.equals(u1));

        // Check comparing u1 with null (should not be equal)
        assertFalse(u1.equals(null));

        // Check comparing u1 with a different object (should not be equal)
        assertFalse(u1.equals("This is NOT a UserAccount object in anyway shape or form"));

        // Check u1 with u3 (should be equal)
        assertTrue(u1.equals(u3));

        // Check u1 with u2 (should not be equal)
        assertFalse(u1.equals(u2));
    }

    /**
     * Test hashCode method for UserAccount
     * Tests that hashCodes are equal for two UserAccount objects that are the same
     * Tests that hashCodes are not equal for two UserAccount objects that are different
     *
     * @asserts hashCodes are equal for two UserAccount objects that are the same
     * @asserts hashCodes are not equal for two UserAccount objects that are different
     */
    @Test
    public void testUserAccountHashCode() {
        // Create user accounts
        UserAccount u1 = new UserAccount(
                123,
                "Michael Scott",
                "michael@dundermifflin.com"
        );
        UserAccount u2 = new UserAccount(
                456,
                "Dwight Schrute",
                "dwight@dundermifflin.com"
        );
        /*
        UserAccount u3 = new UserAccount(
                456,
                "Jim Halpert",
                null
        );
         */


        // Check hashCodes are equal for two UserAccount objects that are the same (should be equal)
        assertEquals(u1.hashCode(), u1.hashCode());

        // Check hashCodes are not equal for two UserAccount objects that are different (should not be equal)
        assertNotEquals(u1.hashCode(), u2.hashCode());

        // EDGE CASE!
//        assertNotEquals(u3.hashCode(), u3.hashCode());
    }
}
