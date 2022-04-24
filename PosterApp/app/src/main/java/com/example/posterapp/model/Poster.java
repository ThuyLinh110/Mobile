package com.example.posterapp.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

@Entity
public class Poster implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("name")
    @ColumnInfo
    private String name;

    public Poster(String name, String image, int buy, int sell) {
        this.name = name;
        this.image = image;
        this.buy = buy;
        this.sell = sell;
    }

    @SerializedName("image")
    @ColumnInfo
    private String image;

    @SerializedName("buy")
    @ColumnInfo
    private int buy;

    @SerializedName("sell")
    @ColumnInfo
    private int sell;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    @BindingAdapter("srcImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(imageUrl).into(view);
    }


}
