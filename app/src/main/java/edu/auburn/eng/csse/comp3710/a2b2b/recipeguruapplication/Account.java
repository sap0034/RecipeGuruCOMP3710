package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication;

import java.util.Date;
import java.util.UUID;

public class Account {

    private UUID myAccountID;
    private String myFirstName;
    private String myLastName;
    private String myEmailAddress;
    private String myPassword;
    private Date myCreationDate;
    private boolean myIsArchived;

    public Account() {
        myAccountID = UUID.randomUUID();
        myCreationDate = new Date();
    }

    public UUID getAccountID() {
        return myAccountID;
    }

    public void setAccountID(UUID accountID) {
        myAccountID = accountID;
    }

    public String getFirstName() {
        return myFirstName;
    }

    public void setFirstName(String firstName) {
        myFirstName = firstName;
    }

    public String getLastName() {
        return myLastName;
    }

    public void setLastName(String lastName) {
        myLastName = lastName;
    }

    public String getEmailAddress() {
        return myEmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        myEmailAddress = emailAddress;
    }

    public String getPassword() {
        return myPassword;
    }

    public void setPassword(String password) {
        myPassword = password;
    }

    public Date getCreationDate() {
        return myCreationDate;
    }

    public void setCreationDate(Date creationDate) {
        myCreationDate = creationDate;
    }

    public boolean isArchived() {
        return myIsArchived;
    }

    public void setArchived(boolean archived) {
        myIsArchived = archived;
    }
}
