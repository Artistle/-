package com.example.artistle.rv_firebase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by artistle on 31.10.17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {



    List<UserModel> list;

    public UserAdapter(List<UserModel> list) {
        this.list = list;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        UserModel user = list.get(position);

        holder.textName.setText(user.firstName + " " + user.lastName);
        holder.textAge.setText(user.age);
        holder.textJob.setText(user.jod);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textJob;
        TextView textAge;
        public UserViewHolder(View itemView) {
            super(itemView);
            textName = (TextView)itemView.findViewById(R.id.textName);
            textJob = (TextView)itemView.findViewById(R.id.job);
            textAge = (TextView)itemView.findViewById(R.id.age);
        }
    }


}
