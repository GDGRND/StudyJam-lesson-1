package ru.webant.studyjam.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.webant.studyjam.BuildConfig;
import ru.webant.studyjam.api.MyServiceGenerator;
import ru.webant.studyjam.api.RestServiceApi;
import ru.webant.studyjam.models.Article;
import ru.webant.studyjam.models.NewsFormat;
import ru.webant.studyjam.utilRecycler.ArticleClickListener;
import ru.webant.studyjam.utilRecycler.MyAdapter;
import ru.webant.studyjam.R;
import ru.webant.studyjam.utilRecycler.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity implements ArticleClickListener {

    private RecyclerView myRecyclerView;
    private MyAdapter myAdapter;
    private ArrayList<String> listNews = new ArrayList<>();
    private NewsFormat myNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        final RestServiceApi restServiceApi = MyServiceGenerator.createService(RestServiceApi.class);

        restServiceApi.getNews(BuildConfig.API_KEY).enqueue(new Callback<NewsFormat>() {
            @Override
            public void onResponse(Call<NewsFormat> call, Response<NewsFormat> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "it's ok!", Toast.LENGTH_SHORT).show();
                    myNews = response.body();
                    myRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    myAdapter = new MyAdapter(myNews.getResults(), MainActivity.this);
                    myRecyclerView.setAdapter(myAdapter);

                } else {
                    Log.i("Call API", "it's a not NewsFormat");
                }
            }

            @Override
            public void onFailure(Call<NewsFormat> call, Throwable t) {
                Toast.makeText(MainActivity.this, "it's fail", Toast.LENGTH_SHORT).show();
            }
        });

        for (int i = 0; i < 10; i++) {
            listNews.add(getResources().getString(R.string.news_title, Integer.toString(i)));
        }
    }

    @Override
    public void onClick(Article article) {
        Intent intent = new Intent(this, ArticleActivity.class);
        intent.putExtra(ArticleActivity.ARGUMENT_URL, article.getUrl());
        startActivity(intent);
    }
}
