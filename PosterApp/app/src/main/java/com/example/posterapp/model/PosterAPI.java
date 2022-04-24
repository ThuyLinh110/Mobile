package com.example.posterapp.model;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface PosterAPI {
    @GET("Norviah/animal-crossing/master/json/data/Posters.json")

Single<List<Poster>> getPosters();
}
