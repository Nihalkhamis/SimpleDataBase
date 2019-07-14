package app.MadarSoft.SimpleDataBase.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import app.MadarSoft.SimpleDataBase.Models.UserModel;
import app.MadarSoft.SimpleDataBase.R;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {


    private Context context;
    private ArrayList<UserModel> userModels;


    public UsersAdapter(Context context, ArrayList<UserModel> userModels) {

        this.context = context;
        this.userModels = userModels;
    }

    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersAdapter.ViewHolder holder, int position) {

        UserModel userModel = userModels.get(position);
        holder.name.setText(userModel.getName());
        holder.age.setText(userModel.getAge() + "");
        holder.job.setText(userModel.getJob() + "");
        holder.gender.setText(userModel.getGender() + "");
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,age ,job,gender;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            job = itemView.findViewById(R.id.job);
            gender = itemView.findViewById(R.id.gender);

        }
    }
}


