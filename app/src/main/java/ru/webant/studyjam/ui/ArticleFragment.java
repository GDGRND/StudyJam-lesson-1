package ru.webant.studyjam.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import ru.webant.studyjam.R;
import ru.webant.studyjam.models.Article;

/**
 * Created by atomofiron on 8/19/17.
 */

public class ArticleFragment extends Fragment {

	public static ArticleFragment newInstance(Article article) {
		ArticleFragment fragment = new ArticleFragment();
		Bundle bundle = new Bundle();
		bundle.putString("URL", article.getUrl());
		fragment.setArguments(bundle);

		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_article, container, false);

		((WebView) view.findViewById(R.id.web_view)).loadUrl(getArguments().getString("URL"));

		return view;
	}

}
