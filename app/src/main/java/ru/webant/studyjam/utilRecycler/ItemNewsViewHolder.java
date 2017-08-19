package ru.webant.studyjam.utilRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import ru.webant.studyjam.R;
import ru.webant.studyjam.models.Article;
import ru.webant.studyjam.models.ImageType;
import ru.webant.studyjam.models.Multimedia;

/**
 * Created by vdaron on 19.08.17.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    private TextView titleNews;
    private TextView descriptionNews;
    private ImageView imageNews;
    private TextView timeNews;

    public ItemNewsViewHolder(View itemView) {
        super(itemView);
        titleNews = (TextView) itemView.findViewById(R.id.title_news);
        descriptionNews = (TextView) itemView.findViewById(R.id.description_news);
        imageNews = (ImageView) itemView.findViewById(R.id.image_news);
        timeNews = (TextView) itemView.findViewById(R.id.time_news);
    }

    public void bind(Article article) {
        titleNews.setText(article.getTitle());
        descriptionNews.setText(article.getDescription());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        timeNews.setText(formatter.format(article.getCreatedDate()));

        Multimedia multimedia = article.getImageByType(ImageType.THUMBNAIL_LARGE);
        if (multimedia != null) {
            imageNews.setVisibility(View.VISIBLE);
            Picasso.with(itemView.getContext())
                    .load(multimedia.getUrl())
                    .placeholder(R.drawable.ic_fiber_new_black_24dp)
                    .resize(multimedia.getWidth(), multimedia.getHeight())
                    .centerCrop()
                    .into(imageNews);
        } else {
            imageNews.setVisibility(View.GONE);
        }

    }
}
