package com.example.research.musiclistapp.Adapter;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.research.musiclistapp.HomeListModel;
import com.example.research.musiclistapp.OnItemClickListner;
import com.example.research.musiclistapp.R;
import com.example.research.musiclistapp.Result;
import com.example.research.musiclistapp.RockListModel;

import java.util.List;

/**
 * Created by Research on 30/09/2017.
 */


public class RockListAdapter extends RecyclerView.Adapter <RockListAdapter.RockViewHolder> {

    List<Result> rockSongsList;
    int row;
    Context applicationContext;

    public RockListAdapter(List<Result> rockSongsList, int row, Context applicationContext) {
        this.rockSongsList = rockSongsList;
        this.row = row;
        this.applicationContext = applicationContext;
    }

    @Override
    public RockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(row,null);
        return new RockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RockViewHolder holder, int position) {

       holder.textView.setText(rockSongsList.get(position).getArtistName());


    }

    @Override
    public int getItemCount() {
        return rockSongsList.size();
    }

    public class RockViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public RockViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
        }

        public void bind(final RockListModel item, final OnItemClickListner listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onItemClick(item);

                }
            });
        }
    }
}
