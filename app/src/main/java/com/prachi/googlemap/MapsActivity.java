package com.prachi.googlemap;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.prachi.googlemap.model.LatitudeLongitude;

import java.util.ArrayList;
import java.util.List;

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

        List<LatitudeLongitude> latLings= new ArrayList<>();
        latLings.add(new LatitudeLongitude(27.706195,85.3300396,"merocollege"));
        latLings.add(new LatitudeLongitude(27.70482,85.3293997,"Goapl dai ko chatamari"));

        CameraUpdate center, zoom;
        for (int i=0;i<latLings.size();i++){
            center=CameraUpdateFactory.newLatLng(new LatLng(latLings.get(i).getLat(),
                    latLings.get(i).getLon()));
            zoom=CameraUpdateFactory.zoomTo(16);
            mMap.addMarker(new MarkerOptions().position(new LatLng(latLings.get(i).getLat(),latLings.get(i).getLon())).title(latLings.get(i).getMarker()));
            mMap.moveCamera(center);
            mMap.animateCamera(zoom);
            mMap.getUiSettings().setZoomControlsEnabled(true);
        }
       /* // Add a marker in Sydney and move the camera
        LatLng meroCollege = new LatLng(27.706195, 85.3300396);
        mMap.addMarker(new MarkerOptions().position(meroCollege).title("Marker in meroCollege"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(meroCollege));*/
    }
}
//3d27.706195!4d85.3300396