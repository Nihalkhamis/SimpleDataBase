package app.MadarSoft.SimpleDataBase.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Table_User")
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    int ID;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "age")
    private String age;
    @ColumnInfo(name = "job")
    private String job;
    @ColumnInfo(name = "gender")
    private String gender;

    public UserModel(String name, String age, String job, String gender) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
