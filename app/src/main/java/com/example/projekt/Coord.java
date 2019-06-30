package com.example.projekt;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Coord implements Serializable {
    @SerializedName("lat")
    double lat;
    @SerializedName("lon")
    double lon;
}
