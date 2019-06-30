package com.example.projekt;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WeatherItem implements Serializable {
    @SerializedName("id")
    int id;
    @SerializedName("main")
    String main;
    @SerializedName("description")
    String description;
    @SerializedName("icon")
    String icon;

}
