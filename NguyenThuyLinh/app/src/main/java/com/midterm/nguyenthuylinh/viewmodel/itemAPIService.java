package com.midterm.nguyenthuylinh.viewmodel;

import com.midterm.nguyenthuylinh.model.item;
import com.midterm.nguyenthuylinh.model.itemAPI;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class itemAPIService {
    private static final String BASE_URL ="https://api.jsonbin.io/";
    private static itemAPI api;

    public itemAPIService()
    {
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(itemAPI.class);

    }
    public Single<List<item>> getItems()
    {
        return api.getItems();
    }
}
