package com.example.middledemo.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
public class DogBreed implements Serializable {

    @SerializedName("id")
    @PrimaryKey
    private int id;

    @SerializedName("name")
    @ColumnInfo
    private String name;

    @ColumnInfo
    @SerializedName("life_span")
    private String lifeSpan;

    @ColumnInfo
    @SerializedName("origin")
    private String origin;

    @ColumnInfo
    @SerializedName("url")
    private String url;

    @ColumnInfo
    @SerializedName("bred_for")
    private String breedFor;

    @ColumnInfo
    @SerializedName("breed_group")
    private String breedGroup;

    @ColumnInfo
    @SerializedName("temperament")
    private String temperament;



    public DogBreed(int id, String name, String lifeSpan, String origin, String url, String breedFor, String breedGroup, String temperament) {
        this.id = id;
        this.name = name;
        this.lifeSpan = lifeSpan;
        this.origin = origin;
        this.url = url;
        this.breedFor = breedFor;
        this.breedGroup = breedGroup;
        this.temperament = temperament;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBreedFor() {
        return breedFor;
    }

    public void setBreedFor(String breedFor) {
        this.breedFor = breedFor;
    }

    public String getBreedGroup() {
        return breedGroup;
    }

    public void setBreedGroup(String breedGroup) {
        this.breedGroup = breedGroup;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }



    @BindingAdapter("srcImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(imageUrl).into(view);
    }
}
