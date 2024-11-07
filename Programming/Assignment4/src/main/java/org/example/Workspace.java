package org.example;

import java.util.ArrayList;
import java.util.List;

public class Workspace {
    private String workspaceName;
    private String workspaceDescription;
    private UserAccount owner;
    private List<UserAccount> collaborators;

    /**
     * Constructor for Workspace
     *
     * @param workspaceName
     * @param workspaceDescription
     * @param owner
     */
    public Workspace(String workspaceName, String workspaceDescription, UserAccount owner) {
        this.workspaceName = workspaceName;
        this.workspaceDescription = workspaceDescription;
        this.owner = owner;
        collaborators = new ArrayList<>();
    }

    /**
     * Method to add to collaborators list
     *
     * @param u
     */
    public void addCollaborator(UserAccount u) {
        collaborators.add(u);
    }

    /**
     * Getter for collaborators
     *
     * @return collaborators
     */
    public List<UserAccount> getCollaborators() {
        return collaborators;
    }

    /**
     * toString method for workspace
     *
     * @return formatted string with workspaceName and collaborators
     */
    @Override
    public String toString() {
        String str = "";

        str += "Workspace Name: " + workspaceName + "\n";

        str += "Collaborators: \n";
        for (UserAccount u : collaborators) {
            str += u.getName() + "\n";
        }

        return str;
    }
}
