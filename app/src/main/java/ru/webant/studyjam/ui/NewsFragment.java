package ru.webant.studyjam.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.webant.studyjam.BuildConfig;
import ru.webant.studyjam.R;
import ru.webant.studyjam.api.MyServiceGenerator;
import ru.webant.studyjam.api.RestServiceApi;
import ru.webant.studyjam.models.NewsFormat;
import ru.webant.studyjam.utilRecycler.MyAdapter;

/**
 * Created by atomofiron on 8/19/17.
 */

public class NewsFragment extends Fragment {

	private RecyclerView myRecyclerView;
	private MyAdapter myAdapter;
	private NewsFormat myNews;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final RestServiceApi restServiceApi = MyServiceGenerator.createService(RestServiceApi.class);
		restServiceApi.getNews(BuildConfig.API_KEY).enqueue(new Callback<NewsFormat>() {
			@Override
			public void onResponse(Call<NewsFormat> call, Response<NewsFormat> response) {
				if (response.isSuccessful()) {
					Toast.makeText(getContext(), "it's ok!", Toast.LENGTH_SHORT).show();
					myNews = response.body();
					showNews();
				} else {
					Log.i("Call API", "it's a not NewsFormat");
				}
			}

			@Override
			public void onFailure(Call<NewsFormat> call, Throwable t) {
				Toast.makeText(getContext(), "it's fail", Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);

		myRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

		if (myNews != null)
			showNews();

		return view;
	}

	private void showNews() {
		myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		myAdapter = new MyAdapter(myNews.getResults(), (MainActivity) getActivity());
		myRecyclerView.setAdapter(myAdapter);
	}
}
