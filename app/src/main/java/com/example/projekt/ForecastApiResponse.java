package com.example.projekt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastApiResponse {
    @SerializedName("cod")
    int cod;
    @SerializedName("message")
    double message;
    @SerializedName("cnt")
    int cnt;
    @SerializedName("list")
    List<ForecastItem> forecastList;





}
