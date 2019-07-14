package app.MadarSoft.SimpleDataBase.DataBase;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import app.MadarSoft.SimpleDataBase.Adapters.UsersAdapter;
import app.MadarSoft.SimpleDataBase.Models.UserModel;

public class UserRepository {
    public static class getAllUsersAsyncTask extends AsyncTask<Void, Void, Void> {
        RecyclerView recycleview;
        TextView no_data;
        ArrayList<UserModel> userModels;
        AppDataBase appDataBase;
        UsersAdapter usersAdapter;
        Context mContext;

        public getAllUsersAsyncTask(Context mContext,RecyclerView recycleview, TextView no_data, ArrayList<UserModel> userModels, AppDataBase appDataBase, UsersAdapter usersAdapter) {
            this.recycleview = recycleview;
            this.no_data = no_data;
            this.userModels = userModels;
            this.appDataBase = appDataBase;
            this.usersAdapter = usersAdapter;
            this.mContext= mContext;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                userModels = (ArrayList<UserModel>) appDataBase.userDao().getAllUsers();
                if (userModels.isEmpty()) {
                    recycleview.setVisibility(View.GONE);
                    no_data.setVisibility(View.VISIBLE);
                } else {
                    recycleview.setVisibility(View.VISIBLE);
                    no_data.setVisibility(View.GONE);
                    usersAdapter.notifyDataSetChanged();

                }

            } catch (Exception e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            usersAdapter = new UsersAdapter(mContext, userModels);
            recycleview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayout.VERTICAL, false));
            recycleview.setAdapter(usersAdapter);        }
    }
    public static class InserAsyncTask extends AsyncTask<Void, Void, Void> {
        Context mcontext;
        UserModel userModel;
        AppDataBase appDataBase;

        public InserAsyncTask(Context mcontext, UserModel userModel, AppDataBase appDataBase) {
            this.mcontext = mcontext;
            this.userModel = userModel;
            this.appDataBase = appDataBase;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            appDataBase.userDao().insertUser(userModel);
            return null;
        }
    }

}
