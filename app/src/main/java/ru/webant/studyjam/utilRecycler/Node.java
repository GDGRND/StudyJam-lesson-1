package ru.webant.studyjam.utilRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import ru.webant.studyjam.models.Article;

/**
 * Created by atomofiron on 8/19/17.
 */

public final class Node {
	private Article article = null;
	private Creator creator = null;

	private Node() {}

	Node(Creator creator) {
		this.creator = creator;
	}

	Node(Creator creator, Article article) {
		this(creator);
		this.article = article;
	}

	Item create(ViewGroup parent) {
		return creator.create(parent);
	}

	Article getArticle() {
		return article;
	}

	interface Creator {
		Item create(ViewGroup parent);
	}

	public abstract static class Item extends RecyclerView.ViewHolder implements View.OnClickListener {
		private ArticleClickListener articleClickListener = null;
		private Article article = null;

		Item(View itemView) {
			super(itemView);
			itemView.setOnClickListener(this);
		}

		void bind(Article article, ArticleClickListener listener) {
			this.article = article;
			articleClickListener = listener;
		}

		@Override
		public void onClick(View v) {
			if (articleClickListener != null)
				articleClickListener.onClick(article);
		}

		public interface ArticleClickListener {
			void onClick(Article article);
		}
	}
}
