package ru.webant.studyjam.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.webant.studyjam.models.NewsFormat;

/**
 * Created by vdaron on 12.08.17.
 */

public interface RestServiceApi {

@GET("svc/topstories/v2/home.json")
    Call<NewsFormat> getNews(@Query("api-key") String apiKey);

}
