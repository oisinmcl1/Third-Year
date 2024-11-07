package org.example;

/**
 * @author Oisin Mc Laughlin
 * 22441106
 */

public class UserAccount implements Comparable<UserAccount> {
    private long userID;
    private String name;
    private String emailAddress;

    /**
     * Constructor for UserAccount
     *
     * @param userID
     * @param name
     * @param emailAddress
     */
    public UserAccount(long userID, String name, String emailAddress) {
        this.userID = userID;
        this.name = name;
        this.emailAddress = emailAddress;
    }

    /**
     * Getters for UserAccount
     *
     * @return userID, name, emailAddress
     */
    public long getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * toString method for UserAccount
     *
     * @return formatted string with userID, name, emailAddress
     */
    @Override
    public String toString() {
        String str = "";

        str += "User ID: " + userID + "\n";
        str += "Name: " + name + "\n";
        str += "Email Address: " + emailAddress + "\n";

        return str;
    }

    /**
     * The UserAccount objects should be ordered by their emailAddresses
     * This is done using the compareTo method
     *
     * @param o
     * @return comparison of emailAddresses
     */
    @Override
    public int compareTo(UserAccount o) {
        return this.emailAddress.
                compareTo(
                        o.emailAddress
                );
    }

    /**
     * Equals method for UserAccount
     * Checks if object is compared to itself
     * Checks if object is null or not an instance of UserAccount
     * Finally checks if userID is equal to other userID
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        // Check if object is compared to itself
        if (this == o) {
            return true;
        }

        // Check if compared to null
        if (o == null) {
            return false;
        }

        // Check if object is an instance of UserAccount
        if (!(o instanceof UserAccount)) {
            return false;
        }

        // Now check if userID is equal to other userID (cast to UserAccount)
        UserAccount u = (UserAccount) o;
        return userID == u.userID;
    }

    /**
     * HashCode method for UserAccount
     * name and emailAddress are hashed and added to userID (used built in hash code method that returns an int by hashing based on the chars)
     * Multiply by 13 to add more uniqueness to the hashcode
     * @return hashcode based on userID, name, emailAddress (added together and multiplied by 13)
     */
    @Override
    public int hashCode() {
        return 13 * ((int) (userID + name.hashCode() + emailAddress.hashCode()));
    }
}
