package ru.webant.studyjam.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.webant.studyjam.models.Article;
import ru.webant.studyjam.utilRecycler.ArticleClickListener;
import ru.webant.studyjam.R;

public class MainActivity extends AppCompatActivity implements ArticleClickListener {
    private FragmentManager fragmentManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentById(R.id.container) == null)
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new NewsFragment())
                    .commitAllowingStateLoss();
    }

    @Override
    public void onClick(Article article) {
        fragmentManager.beginTransaction()
                .addToBackStack("article")
                .replace(R.id.container, ArticleFragment.newInstance(article))
                .commitAllowingStateLoss();
    }
}
