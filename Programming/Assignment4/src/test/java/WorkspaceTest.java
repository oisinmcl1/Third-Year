import org.example.UserAccount;
import org.example.Workspace;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class WorkspaceTest {
    // Normally would write tests here to test creating workspace obj, constructor etc

    /**
     * Test if you can add a collaborator to a workspace
     *
     * @asserts collaborator is added to the workspace
     */
    @Test
    public void testAddCollaborator() {
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

        //public Workspace(String workspaceName, String workspaceDescription, UserAccount owner)
        Workspace w = new Workspace(
                "Dunder Mifflin",
                "Paper Company",
                u1
        );

        w.addCollaborator(u2);

        assertEquals(u2, w.getCollaborators().get(0));
        ;
    }

    /**
     * Test toString of Workspace
     *
     * @asserts formatted string with workspaceName and collaborators
     */
    @Test
    public void testToString() {
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

        Workspace w = new Workspace(
                "Dunder Mifflin",
                "Paper Company",
                u1
        );
        w.addCollaborator(u2);

        /*str += "Workspace Name: " + workspaceName + "\n";

        str += "Collaborators: \n";
        for (UserAccount u : collaborators) {
            str += u.getName() + "\n";
        }*/

        String expected =
                "Workspace Name: " +
                "Dunder Mifflin\n" +
                "Collaborators: \n" +
                "Dwight Schrute\n";

        assertEquals(expected, w.toString());
    }

    /**
     * Tests for question h, parts a-c
     * Populates an arraylist using data from a CSV file (from old q)
     * Creates a hashmap with UserAccount as key and List of Workspaces as value
     * The idea is to associate users with their workspaces
     * Maps owner (key) to the workspace (value)
     * Then gets the workspace of the owner
     *
     * @throws IOException
     */
    @Test
    public void testMap() throws IOException {
        // Using csv from UserAccountTest to create UserAccount objects again
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


        // Using hashmap for associating users with their workspaces (UserAccount is key, List of Workspaces is value)
        Map<UserAccount, List<Workspace>> uwMap = new HashMap<>();

        // Michael is going to be our owner
        UserAccount o = users.get(0);
        Workspace w = new Workspace(
                "Dunder Mifflin",
                "Paper Company",
                o
        );

        // Add some collaborators to the workspace (from pos 4 and 7 from users)
        // Idk if you want pos 3 and 6 or 4 and 7??
//        w.addCollaborator(users.get(4));
//        w.addCollaborator(users.get(7));
        w.addCollaborator(users.get(3));
        w.addCollaborator(users.get(6));

        // Using hashmap for owner, workspace must be in arraylist tho
        List<Workspace> workspaces = new ArrayList<>();
        workspaces.add(w);
        uwMap.put(o, workspaces);

        // Get workspace of owner (michael) from hashmap
        System.out.println(uwMap.get(o));
    }
}
