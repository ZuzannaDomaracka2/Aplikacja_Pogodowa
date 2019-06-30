package com.example.projekt;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Wind implements Serializable {
    @SerializedName("speed")
    double speed;
    @SerializedName("deg")
    double deg;
}
