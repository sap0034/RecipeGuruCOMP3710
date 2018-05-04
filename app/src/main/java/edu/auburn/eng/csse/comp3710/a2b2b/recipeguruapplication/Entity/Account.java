package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Account")
public class Account {

    @PrimaryKey(autoGenerate = true)
    private int AccountID;

    @ColumnInfo(name = "FirstName")
    private String FirstName;

    @ColumnInfo(name = "LastName")
    private String LastName;

    @ColumnInfo(name = "EmailAddress")
    private String EmailAddress;

    @ColumnInfo(name = "Password")
    private String Password;

    @ColumnInfo(name = "AccountCreatedDateTime")
    private String AccountCreatedDatetime;

    //getters and setters
    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }
    public int getAccountID() {
        return this.AccountID;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getEmailAddress() {
        return this.EmailAddress;
    }

    public void setAccountCreatedDatetime(String AccountCreatedDatetime) {
        this.AccountCreatedDatetime = AccountCreatedDatetime;
    }

    public String getAccountCreatedDatetime() {
        return this.AccountCreatedDatetime;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword() {
        return this.Password;
    }

}
