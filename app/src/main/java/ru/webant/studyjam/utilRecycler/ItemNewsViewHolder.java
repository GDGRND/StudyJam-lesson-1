package ru.webant.studyjam.utilRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ru.webant.studyjam.R;
import ru.webant.studyjam.models.Article;
import ru.webant.studyjam.models.ImageType;
import ru.webant.studyjam.models.Multimedia;

/**
 * Created by vdaron on 19.08.17.
 */

public class ItemNewsViewHolder extends Node.Item implements View.OnClickListener {

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
        itemView.setOnClickListener(this);
    }

    static Node.Creator getFactory() {
        return new Node.Creator() {
            @Override
            public Node.Item create(ViewGroup parent) {
                return new ItemNewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));
            }
        };
    }

    void bind(Article article, ArticleClickListener listener) {
        super.bind(article, listener);

        titleNews.setText(article.getTitle());
        descriptionNews.setText(article.getDescription());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        timeNews.setText(formatter.format(article.getCreatedDate()));

        Multimedia multimedia = article.getImageByType(ImageType.THUMBNAIL_LARGE);
        if (multimedia != null) {
            imageNews.setVisibility(View.VISIBLE);
            Picasso.with(itemView.getContext())
                    .load(multimedia.getUrl())
                    .resize(multimedia.getWidth(), multimedia.getHeight())
                    .centerCrop()
                    .into(imageNews);
        } else {
            imageNews.setVisibility(View.GONE);
        }
    }
}
