package app.MadarSoft.SimpleDataBase.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import app.MadarSoft.SimpleDataBase.Models.UserModel;


@Database(entities = {UserModel.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();

    private static AppDataBase instance;


    public static synchronized AppDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class, "Table_User")
                    .build();
        }
        return instance;
    }
}