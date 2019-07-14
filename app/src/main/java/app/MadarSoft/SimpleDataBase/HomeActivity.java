package app.MadarSoft.SimpleDataBase;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.MadarSoft.SimpleDataBase.DataBase.AppDataBase;
import app.MadarSoft.SimpleDataBase.DataBase.UserRepository;
import app.MadarSoft.SimpleDataBase.Models.UserModel;

public class HomeActivity extends AppCompatActivity {

    EditText name, age, job_title, gender;
    Button save, show_data;
    AppDataBase appDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        appDataBase = AppDataBase.getInstance(this);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        job_title = findViewById(R.id.job);
        gender = findViewById(R.id.gender);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateCorrectDate();
            }
        });
        show_data = findViewById(R.id.show_date);
        show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                startActivity(new Intent(HomeActivity.this, UsersDataActivity.class));
            }
        });
    }

    private void validateCorrectDate() {
        if (name.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please Insert Name", Toast.LENGTH_SHORT).show();
            return;

        } else if (age.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please Insert age", Toast.LENGTH_SHORT).show();
            return;


        } else if (job_title.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please Insert job title", Toast.LENGTH_SHORT).show();
            return;

        } else if (gender.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please Insert gender", Toast.LENGTH_SHORT).show();
            return;

        } else {
            insertIntoDataBase();
        }

    }

    private void insertIntoDataBase() {
        UserModel userModel = new UserModel(name.getText().toString()
                , age.getText().toString() + ""
                , job_title.getText().toString() + ""
                , gender.getText().toString() + "");
        new UserRepository.InserAsyncTask(this, userModel, appDataBase).execute();
        name.setText("");
        age.setText("");
        job_title.setText("");
        gender.setText("");
        Toast.makeText(this, "data added succesfully", Toast.LENGTH_SHORT).show();
    }

}
