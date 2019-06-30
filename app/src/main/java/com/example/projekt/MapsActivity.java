package com.example.projekt;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.clear();
                final double lat=latLng.latitude;
                final double lon=latLng.longitude;
                mMap.addMarker(new MarkerOptions().position(latLng));
                GetDataService service=RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<WeatherAPIResponse> call=service.getweather(getString(R.string.weatherkey),String.valueOf(lat),String.valueOf(lon),getString(R.string.unitsmetric));
                call.enqueue(new Callback<WeatherAPIResponse>() {
                    @Override
                    public void onResponse(Call<WeatherAPIResponse> call, Response<WeatherAPIResponse> response) {
                        WeatherAPIResponse weatherApiResponse = (WeatherAPIResponse)response.body();
                       // Toast.makeText(MapsActivity.this,String.valueOf(weatherApiResponse.main.temp),Toast.LENGTH_LONG).show();
                        openLocationWeatherActivity(weatherApiResponse,lat,lon);
                    }

                    @Override
                    public void onFailure(Call<WeatherAPIResponse> call, Throwable t) {
                        Toast.makeText(MapsActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }


private void openLocationWeatherActivity(WeatherAPIResponse apiresponse, double lat, double lon)
{
    Intent intent= new Intent(MapsActivity.this, LocationWeatherActivity.class);
    intent.putExtra("WeatherAPIResponse",apiresponse);
    intent.putExtra("lat", lat);
    intent.putExtra("lon",lon);
    startActivity(intent);
}


}
