package org.example;

public class UserAccount {
    private long userID;
    private String name;
    private String emailAddress;

    public UserAccount(long userID, String name, String emailAddress) {
        this.userID = userID;
        this.name = name;
        this.emailAddress = emailAddress;
    }

    // Getters
    public long getUserID() {
        return userID;
    }
    public String getName() {
        return name;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    // To string of UserAccount
    @Override
    public String toString() {
        String str = "";

        str += "User ID: " + userID + "\n";
        str += "Name: " + name + "\n";
        str += "Email Address: " + emailAddress + "\n";

        return str;
    }
}
