package com.example.artistle.message_chat_for_loading.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.artistle.message_chat_for_loading.MainActivity;
import com.example.artistle.message_chat_for_loading.R;
import com.example.artistle.message_chat_for_loading.dto.message_dto;

import java.util.List;

/**
 * Created by artistle on 31.10.17.
 */

public class Message_adapter extends RecyclerView.Adapter<Message_adapter.RemindViewHolder> {
    private List<message_dto> data;

    public Message_adapter(List<message_dto> data) {
        this.data = data;
    }
    public Message_adapter(){

    }
    @Override
    public Message_adapter.RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new RemindViewHolder(view);
    }
    //fix
    @Override
    public void onBindViewHolder(Message_adapter.RemindViewHolder holder, int position) {
        holder.title.setText(data.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class RemindViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        CardView cardView;
        public RemindViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
        }

        public TextView getTitle() {
            return title;
        }
    }
}
