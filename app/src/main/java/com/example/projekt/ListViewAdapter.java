package com.example.projekt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ForecastItem> {

    private List<ForecastItem> mforecasts;
    Context mcontext;

    private static class ViewHolder{
        TextView hour;
        TextView temp;

    }

    public ListViewAdapter(List<ForecastItem> forecasts, Context context)
    {
        super(context,R.layout.forecast_item,forecasts);
        this.mforecasts=forecasts;
        this.mcontext=context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ForecastItem forecastItem=getItem(position);
        ViewHolder viewHolder;
        final View result;
        if(convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.forecast_item,parent,false);
            viewHolder.hour=convertView.findViewById(R.id.textView_hour);
            viewHolder.temp=convertView.findViewById(R.id.textView_temp);
            result=convertView;
            convertView.setTag(viewHolder);

        }
        else
        {
            viewHolder=(ViewHolder)convertView.getTag();
            result=convertView;
        }

        viewHolder.hour.setText(forecastItem.dt_txt);
        viewHolder.temp.setText(String.valueOf(forecastItem.main.temp + " °C "));

        return convertView;


    }
}
