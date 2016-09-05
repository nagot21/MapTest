package com.nagot.maptest;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivityBackup extends FragmentActivity implements OnMapReadyCallback {

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


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(2);

        // Add a marker in Sydney and move the camera
        LatLng backbarrow = new LatLng(54.25928, -2.9885);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(backbarrow, 18);
        //mMap.addMarker(new MarkerOptions().position(backbarrow).title("Marker in Backbarrow"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(backbarrow));
        mMap.moveCamera(update);

        //CustomInfoWindowAdpater customInfoWindowAdpater = new CustomInfoWindowAdpater(this);
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this.getLayoutInflater()));


        Marker m1 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(54.2592819, -2.9885092))
                .anchor(0.5f, 0.5f)
                .title("Start")
                .snippet("Narration"));
        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.arrow_left));

        //mMap.setInfoWindowAdapter(customInfoWindowAdpater.getInfoWindow(m1));

        Marker m2 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(54.2591503, -2.9890217))
                .anchor(0.5f, 0.5f)
                .title("The Blue Factory")
                .snippet("Richard Sanderson"));
    }
}
