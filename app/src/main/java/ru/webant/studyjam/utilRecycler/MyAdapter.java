package ru.webant.studyjam.utilRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ru.webant.studyjam.models.Article;

public class MyAdapter extends RecyclerView.Adapter {

    private ArrayList<Article> listNews;
    private List<Node> nodes = new ArrayList<>();
    private Node.Item.ArticleClickListener listener;
    private Node.Creator itemDividerCreator;
    private Node.Creator itemEmptyCreator;
    private Node.Creator itemFullNewsCreator;
    private Node.Creator itemNewsCreator;

    public MyAdapter(ArrayList<Article> listNews, Node.Item.ArticleClickListener listener) {
        this.listNews = listNews;
        this.listener = listener;

        itemDividerCreator = ItemDividerViewHolder.getCreator();
        itemEmptyCreator = ItemEmptyViewHolder.getCreator();
        itemFullNewsCreator = ItemNewsFullViewHolder.getCreator();
        itemNewsCreator = ItemNewsViewHolder.getCreator();

        buildAdapter();
    }

    private void buildAdapter() {
        nodes.clear();
        Collections.sort(listNews, new Comparator<Article>() {
            @Override
            public int compare(Article article1, Article article2) {
                return article1.getSection().equalsIgnoreCase(article2.getSection()) ? 1 : -1;
            }
        });
        for (int i = 0; i < listNews.size(); i++) {
            Article article = listNews.get(i);
            boolean isFirstInSection = isFirstInSection(listNews, article);
            if (isFirstInSection) {
                nodes.add(new Node(itemEmptyCreator));
                nodes.add(new Node(itemFullNewsCreator, article));
            } else {
                nodes.add(new Node(itemDividerCreator));
                nodes.add(new Node(itemNewsCreator, article));
            }
        }
        notifyDataSetChanged();
    }


    private boolean isFirstInSection(List<Article> list, Article article) {
        try {
            Article lastArticle = list.get(list.indexOf(article) - 1);
            return !lastArticle.getSection().equalsIgnoreCase(article.getSection());
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return nodes.get(viewType).create(parent);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemNewsViewHolder || holder instanceof ItemNewsFullViewHolder)
            ((Node.Item) holder).bind(nodes.get(position).getArticle(), listener);
    }

    @Override
    public int getItemCount() {
        return nodes.size();
    }

}
