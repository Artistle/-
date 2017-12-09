package com.example.artistle.prototype.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.artistle.prototype.R;
import com.example.artistle.prototype.drawDTO.itemDto;

import java.util.List;

public class RVadapter extends RecyclerView.Adapter<RVadapter.ViewHolder>{

    private List<itemDto> data;

    public RVadapter(List<itemDto> data) {
        this.data = data;
    }

    public RVadapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        CardView cardView;

            public ViewHolder(View itemView) {
                super(itemView);
                title = (TextView)itemView.findViewById(R.id.title);
                cardView = (CardView)itemView.findViewById(R.id.cardView);
            }
        }

}
