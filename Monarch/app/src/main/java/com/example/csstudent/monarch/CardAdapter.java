package com.example.csstudent.monarch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by csstudent on 11/30/2016.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {
    private Context mContext;
    private List<Card> cardList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title, details;
        public ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            details = (TextView) itemView.findViewById(R.id.detail);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }
    public CardAdapter(Context mContext, List<Card> cardList){
        this.mContext = mContext;
        this.cardList = cardList;
    }
    @Override
    public CardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardAdapter.MyViewHolder holder, int position) {
        Card card = cardList.get(position);
        holder.title.setText(card.getName());
        holder.details.setText(card.getDetails());

        Glide.with(mContext).load(card.getThumbnail()).into(holder.thumbnail);
    }


    @Override
    public int getItemCount() {
        return cardList.size();
    }
}
