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


public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
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
        TextView time = (TextView) listViewItem.findViewById(R.id.time);

        if (currentEarthQuake != null) {
            magnitude.setText(currentEarthQuake.getMagnitude());
            place.setText(currentEarthQuake.getPlace());
            time.setText(currentEarthQuake.getTime());
        }

        return listViewItem;
    }
}
