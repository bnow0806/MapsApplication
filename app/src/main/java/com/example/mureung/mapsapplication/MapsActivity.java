package com.example.mureung.mapsapplication;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    public double a=-34;
    public  double b=151;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        final TextView lat=(TextView)findViewById(R.id.lat);
        lat.setText("위도: "+a);
        final TextView lng=(TextView)findViewById(R.id.lng);
        lng.setText("경도: "+b);

        // a,b 입력받도록 변경
        LatLng sydney = new LatLng(a, b);
        MarkerOptions marker=new MarkerOptions().position(sydney);
        /*marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_icon01));아이콘 바꾸는 코드*/

        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(a, b), 17));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                mMap.clear();
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.addMarker(markerOptions);
                final TextView lat=(TextView)findViewById(R.id.lat);
                a=latLng.latitude;
                b=latLng.longitude;
                lat.setText("위도: "+a);
                final TextView lng=(TextView)findViewById(R.id.lng);
                lng.setText("경도: "+b);
        }
    });
        //lat과 lng를 넘겨주는코드//
}}