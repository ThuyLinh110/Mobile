package com.example.dogapp.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DogBreed implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("life_span")
    private String lifeSpan;

    @SerializedName("origin")
    private String origin;

    @SerializedName("url")
    private String url;

    @SerializedName("bred_for")
    private String breedFor;

    @SerializedName("breed_group")
    private String breedGroup;

    @SerializedName("temperament")
    private String temperament;

    @SerializedName("height")
    private HashMap<String, String> height;

    @SerializedName("weight")
    private HashMap<String, String> weight;

    public DogBreed(int id, String name, String lifeSpan, String origin, String url, String breedFor, String breedGroup, String temperament, HashMap<String,String> height, HashMap<String,String> weight) {
        this.id = id;
        this.name = name;
        this.lifeSpan = lifeSpan;
        this.origin = origin;
        this.url = url;
        this.breedFor = breedFor;
        this.breedGroup = breedGroup;
        this.temperament = temperament;
        this.height = height;
        this.weight = weight;
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

    public String getHeight() {
        return height.get("metric");
    }

    public void setHeight(HashMap<String,String> height) {
        this.height = height;
    }

    public String getWeight() {
        return weight.get("metric");
    }

    public void setWeight(HashMap<String,String> height) {
        this.weight = weight;
    }

    @BindingAdapter("srcImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(imageUrl).into(view);
    }
}
