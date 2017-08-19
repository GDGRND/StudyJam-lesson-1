package ru.webant.studyjam.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by vdaron on 19.08.17.
 */

public class ArticleActivity extends AppCompatActivity {

    public static final String ARGUMENT_URL = "argument-url";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        setContentView(webView);

        String url = getIntent().getExtras().getString(ARGUMENT_URL);
        webView.loadUrl(url);

    }
}
