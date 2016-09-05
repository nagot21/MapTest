package com.nagot.maptest;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Nagot on 25/08/2016.
 */
class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    LayoutInflater inflater = null;

    public CustomInfoWindowAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View popup = inflater.inflate(R.layout.marker_info_window, null);
        TextView tv = (TextView) popup.findViewById(R.id.title);

        tv.setText(marker.getTitle());
        tv = (TextView) popup.findViewById(R.id.snippet);
        tv.setText(marker.getSnippet());

        return (popup);
    }
}
