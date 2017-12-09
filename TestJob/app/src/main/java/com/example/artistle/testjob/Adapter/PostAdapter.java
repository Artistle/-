package com.example.artistle.testjob.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.artistle.testjob.Activity.UsersInfoActivity;
import com.example.artistle.testjob.Model.PostModel;
import com.example.artistle.testjob.R;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ArrayList<PostModel> posts;

    public PostAdapter(ArrayList<PostModel> posts) {
        this.posts = posts;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_model_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        PostModel post = posts.get(position);

        holder.company.setText(post.getCompany().getName_company());
        holder.email.setText(post.getEmail());
        holder.name.setText(post.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, UsersInfoActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView company;
        TextView email;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            company = (TextView)itemView.findViewById(R.id.company);
            email = (TextView)itemView.findViewById(R.id.email);

        }

    }
}
