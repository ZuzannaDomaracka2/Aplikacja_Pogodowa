package com.example.projekt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastItem {
    @SerializedName("dt")
    long dt;
    @SerializedName("main")
    Main main;
    @SerializedName("weather")
    List<WeatherItem> weather;
    @SerializedName("clouds")
    Clouds clouds;
    @SerializedName("wind")
    Wind wind;
    @SerializedName("sys")
    Sys sys;
    @SerializedName("dt_txt")
    String dt_txt;

}
