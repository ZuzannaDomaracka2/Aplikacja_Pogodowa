package com.example.projekt;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sys implements Serializable {
    @SerializedName("message")
    double message;
    @SerializedName("country")
    String country;
    @SerializedName("sunrise")
    double sunrise;
    @SerializedName("sunset")
    double sunset;
}
