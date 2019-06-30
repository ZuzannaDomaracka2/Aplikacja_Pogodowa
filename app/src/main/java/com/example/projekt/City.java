package com.example.projekt;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("coord")
    Coord coord;
    @SerializedName("country")
    String country;

}
