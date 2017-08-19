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

class ItemNewsFullViewHolder extends Node.Item implements View.OnClickListener {

    private TextView titleText;
    private TextView subtitleText;
    private TextView dateText;
    private ImageView fullImage;

    public ItemNewsFullViewHolder(View itemView) {
        super(itemView);
        titleText = (TextView) itemView.findViewById(R.id.news_full_title);
        subtitleText = (TextView) itemView.findViewById(R.id.news_full_subtitle);
        dateText = (TextView) itemView.findViewById(R.id.news_full_date);
        fullImage = (ImageView) itemView.findViewById(R.id.news_full_image);
        itemView.setOnClickListener(this);
    }

    static Node.Creator getFactory() {
        return new Node.Creator() {
            @Override
            public Node.Item create(ViewGroup parent) {
                return new ItemNewsFullViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_full, parent, false));
            }
        };
    }

    void bind(Article article, ArticleClickListener listener) {
        super.bind(article, listener);

        titleText.setText(article.getTitle());
        subtitleText.setText(article.getDescription());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        dateText.setText(formatter.format(article.getCreatedDate()));

        Multimedia multimedia = article.getImageByType(ImageType.FULL_IMAGE);
        if (multimedia != null) {
            fullImage.setVisibility(View.VISIBLE);
            Picasso.with(itemView.getContext())
                    .load(multimedia.getUrl())
                    .into(fullImage);
        } else {
            fullImage.setVisibility(View.GONE);
        }
    }
}
