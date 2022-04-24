package com.midterm.nguyenthuylinh.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@Entity
public class item implements Serializable {


    @SerializedName("title")
    @ColumnInfo
    private String title;

    @SerializedName("lat")
    @ColumnInfo
    private String lat;


    @SerializedName("lng")
    @ColumnInfo
    private String lng;

    @SerializedName("desc")
    @ColumnInfo
    private String desc;

    @SerializedName("zip")
    @ColumnInfo
    private String zip;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }



    public String getTitle() {
        return title;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getDesc() {
        return desc;
    }

    public String getZip() {
        return zip;
    }

    public String getE() {
        return e;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getAddr() {
        return addr;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setE(String e) {
        this.e = e;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public item(String title, String lat, String lng, String desc, String zip, String e, String timeStamp, String addr) {
        this.title = title;
        this.lat = lat;
        this.lng = lng;
        this.desc = desc;
        this.zip = zip;
        this.e = e;
        this.timeStamp = timeStamp;
        this.addr = addr;
    }

    @SerializedName("e")
    @ColumnInfo
    private String e;

    @SerializedName("timeStamp")
    @ColumnInfo
    private String timeStamp;

    @SerializedName("addr")
    @ColumnInfo
    private String addr;
}
