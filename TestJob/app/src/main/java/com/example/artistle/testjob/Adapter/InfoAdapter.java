package com.example.artistle.testjob.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.artistle.testjob.Api.InfoUsers;
import com.example.artistle.testjob.Model.InfoModel;
import com.example.artistle.testjob.Model.PostModel;
import com.example.artistle.testjob.R;

import java.util.List;

/**
 * Created by artistle on 15.11.17.
 */

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {
    List<InfoModel> info_data;

    public InfoAdapter(List<InfoModel> info_data) {
        this.info_data = info_data;
    }

    @Override
    public InfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_model, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        InfoModel info = info_data.get(position);

        holder.name.setText(info.getTitle());
        holder.userName.setText(info.getBody());
    }


    @Override
    public int getItemCount() {
        return info_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView userName;
        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.title);
            userName = (TextView)itemView.findViewById(R.id.body);
        }
    }
}
