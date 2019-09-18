package com.news.mvcnewsapp.models;



import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface Api {

    String BASE_URL = "https://newsapi.org/v2/";
    //Call<List<NewsGetSet>> getnews();
    //Call<List<NewsGetSet>> getnews(@Query("api")api: String, @Query("Country")Country: String));
    @GET("top-headlines/")
    Call<NewsGetSet> getnews(@QueryMap Map<String,String> params);
}
