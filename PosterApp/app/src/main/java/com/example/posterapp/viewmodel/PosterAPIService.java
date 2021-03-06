package com.example.posterapp.viewmodel;

import com.example.posterapp.model.Poster;
import com.example.posterapp.model.PosterAPI;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PosterAPIService {
    private static final String BASE_URL ="https://raw.githubusercontent.com/";
    private static PosterAPI api;

    public PosterAPIService()
    {
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(PosterAPI.class);

    }
    public Single<List<Poster>> getPosters()
    {
        return api.getPosters();
    }
}
