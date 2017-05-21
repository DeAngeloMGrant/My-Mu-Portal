package com.v0lture.deAngelo.mymu.cards_folder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.v0lture.deAngelo.mymu.R;
import com.v0lture.deAngelo.mymu.schedule_folder.Card2;

import java.util.List;

/**
 * Created by De'Angelo on 1/7/2017.
 */
    public class Schedule_CardAdapter extends RecyclerView.Adapter<com.v0lture.deAngelo.mymu.cards_folder.Schedule_CardAdapter.MyViewHolder> {
        private Context mContext;
        private List<Card> cardList;
        private ClickListener clicklistener =null;
        public Schedule_CardAdapter(List<Card>cardList){
            this.cardList = cardList;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{
            public CardView cardView;
            public TextView title, details;
            public ImageView thumbnail;
            private RelativeLayout layout;

            public MyViewHolder(final View itemView) {
                super(itemView);
                cardView = (CardView)itemView.findViewById(R.id.card_view);
                title = (TextView) itemView.findViewById(R.id.title);
                details = (TextView) itemView.findViewById(R.id.detail);
                thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
                layout = (RelativeLayout) itemView.findViewById(R.id.layout);
                layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(itemView.getContext(), "Position:"+ Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();
                        if(clicklistener !=null){
                            clicklistener.CardClicked(view,getAdapterPosition());
                        }

                    }
                });
            }
        }
        public void setClickListener(ClickListener clickListener){
            this.clicklistener = clickListener;
        }
        public Schedule_CardAdapter(Context mContext, List<Card> cardList){
            this.mContext = mContext;
            this.cardList = cardList;
        }

        @Override
        public Schedule_CardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView  = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card, parent, false);

            return new com.v0lture.deAngelo.mymu.cards_folder.Schedule_CardAdapter.MyViewHolder(itemView);
        }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Card card = cardList.get(position);
        holder.title.setText(card.getName());
        holder.details.setText(card.getDetails());

        Glide.with(mContext).load(card.getThumbnail()).into(holder.thumbnail);

        if(position==0){
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), Card2.class));
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==1){
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), Card2.class));
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==2){
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), Card2.class));
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==3){
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), Card2.class));
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==4){
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), Card2.class));
                    mContext.startActivity(intent);
                }
            });
        }
        if(position==5){
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= (new Intent(view.getContext(), Card2.class));
                    mContext.startActivity(intent);
                }
            });
        }
    }



        @Override
        public int getItemCount() {
            return cardList.size();
        }
    }


