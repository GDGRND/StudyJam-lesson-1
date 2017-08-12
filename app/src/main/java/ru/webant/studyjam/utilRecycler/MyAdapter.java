package ru.webant.studyjam.utilRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ru.webant.studyjam.R;
import ru.webant.studyjam.models.Article;
import ru.webant.studyjam.models.Multimedia;
import ru.webant.studyjam.models.NewsFormat;

/**
 * Created by vdaron on 29.07.17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Article> listNews;

    public MyAdapter(ArrayList<Article> listNews) {
        this.listNews = listNews;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titleNews;
        public TextView descriptionNews;
        public ImageView imageNews;
        public TextView timeNews;

        public MyViewHolder(View itemView) {
            super(itemView);

            titleNews = (TextView) itemView.findViewById(R.id.title_news);
            descriptionNews = (TextView) itemView.findViewById(R.id.description_news);
            imageNews = (ImageView) itemView.findViewById(R.id.image_news);
            timeNews = (TextView) itemView.findViewById(R.id.time_news);
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

        holder.titleNews.setText(listNews.get(position).getTitle());
        holder.descriptionNews.setText(listNews.get(position).getDescription());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        holder.timeNews.setText(formatter.format(listNews.get(position).getCreatedDate()));

        ArrayList<Multimedia> multimedias = listNews.get(position).getMultimedia();
        if (multimedias != null && !multimedias.isEmpty()) {
            Picasso.with(holder.itemView.getContext())
                    .load(multimedias.get(0).getUrl())
                    .into(holder.imageNews);
        }
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }
}
