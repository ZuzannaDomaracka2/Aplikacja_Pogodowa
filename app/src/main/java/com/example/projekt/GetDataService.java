package com.example.projekt;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    @GET("data/2.5/weather?")
    Call<WeatherAPIResponse> getweather(@Query("appid") String appid, @Query("lat") String lat_val, @Query("lon") String lon_val, @Query("units") String units);
    @GET("data/2.5/forecast?")
    Call<ForecastApiResponse>getforecast(@Query("appid") String appid, @Query("lat") String lat_val, @Query("lon") String lon_val, @Query("units") String units);


}
