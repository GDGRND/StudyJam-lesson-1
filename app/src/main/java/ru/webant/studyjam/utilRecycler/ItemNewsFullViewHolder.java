package ru.webant.studyjam.utilRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ru.webant.studyjam.R;
import ru.webant.studyjam.models.Article;

/**
 * Created by vdaron on 19.08.17.
 */

class ItemNewsFullViewHolder extends RecyclerView.ViewHolder {

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
    }

    void bind(Article article) {

    }

}
