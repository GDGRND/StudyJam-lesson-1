package ru.webant.studyjam.utilRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ru.webant.studyjam.R;

/**
 * Created by vdaron on 29.07.17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<String> listNews;

    public MyAdapter(ArrayList<String> listNews) {
        this.listNews = listNews;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView itemNews;

        public MyViewHolder(View itemView) {
            super(itemView);

            itemNews = (TextView) itemView.findViewById(R.id.my_news);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.item_news, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.itemNews.setText(listNews.get(position));
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }
}
