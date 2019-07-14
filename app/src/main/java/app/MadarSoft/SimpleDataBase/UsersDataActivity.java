package app.MadarSoft.SimpleDataBase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import android.widget.TextView;

import java.util.ArrayList;

import app.MadarSoft.SimpleDataBase.Adapters.UsersAdapter;
import app.MadarSoft.SimpleDataBase.DataBase.AppDataBase;
import app.MadarSoft.SimpleDataBase.DataBase.UserRepository;
import app.MadarSoft.SimpleDataBase.Models.UserModel;

public class UsersDataActivity extends AppCompatActivity {

    RecyclerView recycleview;
    TextView no_data;
    UsersAdapter usersAdapter;
    ArrayList<UserModel> userModels;

    AppDataBase appDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_data);
        no_data = findViewById(R.id.no_data);
        recycleview = findViewById(R.id.recycleview);
        userModels = new ArrayList<>();
        appDataBase = AppDataBase.getInstance(this);
        new UserRepository.getAllUsersAsyncTask(this,recycleview,no_data,userModels,appDataBase,usersAdapter).execute();
    }


}
