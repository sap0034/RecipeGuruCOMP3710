package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

import edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.Entity.Account;

@Dao
public interface AccountDao {

    @Query("SELECT * FROM Account")
    List<Account> getAll();

    @Query("SELECT * FROM Account where FirstName LIKE  :FirstName AND LastName LIKE :LastName")
    Account findByName(String FirstName, String LastName);

    @Query("SELECT * FROM Account where EmailAddress LIKE :EmailAddress")
    Account findByEmailAddress(String EmailAddress);

    @Query("SELECT COUNT(*) from Account")
    int countAccounts();

    @Insert
    void insertAll(Account... accounts);

    @Delete
    void delete(Account account);


}
