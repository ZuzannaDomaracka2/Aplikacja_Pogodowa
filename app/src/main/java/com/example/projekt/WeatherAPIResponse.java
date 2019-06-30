package com.example.projekt;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WeatherAPIResponse implements Serializable {
    @SerializedName("coord")
    Coord coord;
    @SerializedName("weather")
    List<WeatherItem> weather;
    @SerializedName("base")
    String base;
    @SerializedName("main")
    Main main;
    @SerializedName("wind")
    Wind wind;
    @SerializedName("clouds")
    Clouds clouds;
    @SerializedName("dt")
    long dt;
    @SerializedName("sys")
    Sys sys;
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("cod")
    int cod;




}

