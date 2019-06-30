package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationWeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_weather);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setDisplayShowHomeEnabled(true);
        WeatherAPIResponse weatherApiResponse = (WeatherAPIResponse) getIntent().getSerializableExtra("WeatherAPIResponse");
        double lat=getIntent().getDoubleExtra("lat",0);
        double lon=getIntent().getDoubleExtra("lon", 0);

        TextView textView=findViewById(R.id.textView_Name);
        textView.setText(weatherApiResponse.name );
        TextView textView4=findViewById(R.id.textView);
        textView4.setText(" Temperatura " + weatherApiResponse.main.temp + " °C ");
        TextView textView1=findViewById(R.id.textView_Humidity);
        textView1.setText( "Wilgotnosc : " +  String.valueOf(weatherApiResponse.main.humidity + " % "));
        TextView textView2=findViewById(R.id.textView_Pressure);
        textView2.setText( "Cisnienie : " +  String.valueOf(weatherApiResponse.main.pressure + "hPa"));
        TextView textView3=findViewById(R.id.textView_Speed);
        textView3.setText( "Predkosc wiatru  : " +  String.valueOf(weatherApiResponse.wind.speed) + " m/s ");
        TextView textView5=findViewById(R.id.textView_Prognoza);
        textView5.setText("Prognoza pogody : ");

        getforecastdata(lat,lon);

    }
    private void getforecastdata(double lat, double lon)
    {
        GetDataService service=RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ForecastApiResponse> call=service.getforecast(getString(R.string.weatherkey),String.valueOf(lat),String.valueOf(lon),getString(R.string.unitsmetric));
        call.enqueue(new Callback<ForecastApiResponse>() {
            @Override
            public void onResponse(Call<ForecastApiResponse> call, Response<ForecastApiResponse> response) {

                ForecastApiResponse forecastApiResponse = (ForecastApiResponse)response.body();
               // Toast.makeText(LocationWeatherActivity.this,String.valueOf(forecastApiResponse.message),Toast.LENGTH_LONG).show();
                ListView listView=findViewById(R.id.listview);
                ListViewAdapter adapter = new ListViewAdapter(forecastApiResponse.forecastList,LocationWeatherActivity.this);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ForecastApiResponse> call, Throwable t) {
             Toast.makeText(LocationWeatherActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
