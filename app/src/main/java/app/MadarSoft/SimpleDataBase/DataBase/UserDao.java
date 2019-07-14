package app.MadarSoft.SimpleDataBase.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import app.MadarSoft.SimpleDataBase.Models.UserModel;

@Dao
public interface UserDao {

    @Query("SELECT * FROM Table_User")
    List<UserModel> getAllUsers();
    @Insert
    void insertUser(UserModel... userModels);
}
