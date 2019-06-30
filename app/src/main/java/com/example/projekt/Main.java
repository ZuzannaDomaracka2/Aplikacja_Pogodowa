package com.example.projekt;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Main implements Serializable {
    @SerializedName("temp")
    double temp;
    @SerializedName("pressure")
    double pressure;
    @SerializedName("humidity")
    int humidity;
    @SerializedName("temp_min")
    double temp_min;
    @SerializedName("temp_max")
    double temp_max;
    @SerializedName("sea_level")
    double sea_level;
    @SerializedName("grnd_level")
    double grnd_level;
}
