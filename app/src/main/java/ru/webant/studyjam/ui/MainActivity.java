package ru.webant.studyjam.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import ru.webant.studyjam.BuildConfig;
import ru.webant.studyjam.utilRecycler.MyAdapter;
import ru.webant.studyjam.R;
import ru.webant.studyjam.utilRecycler.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;
    private MyAdapter myAdapter;
    private ArrayList<String> listNews = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toast.makeText(this, BuildConfig.API_URL, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, BuildConfig.VERSION_NAME, Toast.LENGTH_SHORT).show();
        for (int i = 0; i < 10; i++) {
            listNews.add(getResources().getString(R.string.news_title, Integer.toString(i)));
        }

        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        myAdapter = new MyAdapter(listNews);
        myRecyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        myRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, myRecyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.news_title, Integer.toString(position)),
                        Toast.LENGTH_SHORT).show();
            }
        }));

    }
}
