package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

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
        TextView date = (TextView) listViewItem.findViewById(R.id.date);
        TextView time = (TextView) listViewItem.findViewById(R.id.time);

        if (currentEarthQuake != null) {
            magnitude.setText(currentEarthQuake.getMagnitude());
            place.setText(currentEarthQuake.getPlace());

            Date dateObject = new Date(currentEarthQuake.getTimeInMillis());
            date.setText(formatDate(dateObject));
            time.setText(formatTime(dateObject));
        }

        return listViewItem;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, YYYY");
        return dateFormatter.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("hh:mm");
        return dateFormatter.format(dateObject);
    }
}
