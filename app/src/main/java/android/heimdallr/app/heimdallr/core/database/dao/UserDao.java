package android.heimdallr.app.heimdallr.core.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.heimdallr.app.heimdallr.core.database.models.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user LIMIT 1")
    User getSingleUser();

    @Query("SELECT * FROM user WHERE email LIKE :email")
    User findByemail(String email);

    @Query("SELECT * FROM user WHERE email LIKE :phone")
    User findByphone(String phone);

    @Query("SELECT COUNT(*) from user")
    int countUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Query("DELETE FROM user")
    void deleteAll();

    @Insert
    void insert(User user);

}
