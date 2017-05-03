package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public EarthquakeAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Earthquake> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem = convertView;
        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarthQuake = getItem(position);

        TextView magnitude = (TextView) listViewItem.findViewById(R.id.magnitude);
        TextView place = (TextView) listViewItem.findViewById(R.id.place);
        TextView primaryLocation = (TextView) listViewItem.findViewById(R.id.primaryLocation);
        TextView date = (TextView) listViewItem.findViewById(R.id.date);
        TextView time = (TextView) listViewItem.findViewById(R.id.time);

        if (currentEarthQuake != null) {
            magnitude.setText(formatMagnitude(currentEarthQuake.getMagnitude()));
            GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
            int magnitudeColor = getMagnitudeColor(currentEarthQuake.getMagnitude());
            magnitudeCircle.setColor(magnitudeColor);

            place.setText(formatPlace(currentEarthQuake.getPlace()));
            primaryLocation.setText(formatCity(currentEarthQuake.getPlace()));
            Date dateObject = new Date(currentEarthQuake.getTimeInMillis());
            date.setText(formatDate(dateObject));
            time.setText(formatTime(dateObject));
        }

        return listViewItem;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorBackgroundId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorBackgroundId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorBackgroundId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorBackgroundId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorBackgroundId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorBackgroundId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorBackgroundId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorBackgroundId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorBackgroundId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorBackgroundId = R.color.magnitude9;
                break;
            default:
                magnitudeColorBackgroundId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorBackgroundId);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, YYYY");
        return dateFormatter.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("hh:mm");
        return dateFormatter.format(dateObject);
    }

    private String formatPlace(String data) {
        String separator = " of ";
        if (data.contains(separator)) {
            String[] place = data.split(separator);
            return place[0] + separator;
        }

        return getContext().getString(R.string.near_the);
    }

    private String formatCity(String data) {
        String separator = " of ";
        if (data.contains(separator)) {
            String[] place = data.split(separator);
            return place[1];
        }

        return data;
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}
