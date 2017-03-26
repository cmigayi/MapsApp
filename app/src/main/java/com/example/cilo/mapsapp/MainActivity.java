package com.example.cilo.mapsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity{

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1)).getMap();
        MarkerOptions markerOptions = new MarkerOptions()
                .position(new LatLng(-1.306581, 36.893629))
                .title("Delhi Haat")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
                .draggable(true).snippet("Near INA metro station");
        map.addMarker(markerOptions);
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.setMyLocationEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(false);
        map.getUiSettings().setZoomGesturesEnabled(false);
        map.getUiSettings().setCompassEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.getUiSettings().setRotateGesturesEnabled(true);
        map.getUiSettings().setTiltGesturesEnabled(true);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(-1.306581, 36.893629)).zoom(12).build();

        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }


}
