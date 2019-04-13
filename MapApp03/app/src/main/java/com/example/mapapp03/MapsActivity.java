package com.example.mapapp03;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;


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

        // シドニーの緯度経度を設定して、そこにマーカーを設置ｓ
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        LatLng paris = new LatLng(48.8588377,2.2770202);
        mMap.addMarker(new MarkerOptions().position(paris).title("Marker in paris"));

        LatLng africa = new LatLng(-34.29689921,18.2471585);
        mMap.addMarker(new MarkerOptions().position(africa).title("Marker in africa"));



        //　カメラの位置
        LatLng center= new LatLng(43.831389, 34.806266);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(paris));

        //線を引く
        PolylineOptions line = new PolylineOptions();
        //、測地点,いろ、太さ
        line.add(paris);
        line.add(sydney);
        line.color(Color.YELLOW);
        line.width(4);
        line.geodesic(true);

        mMap.addPolyline(line);
        //三地点を結ぶ半透明の三角形

       // PolygonOptions options =new PolygonOptions();
       // options.add(paris,africa,sydney);
     //   options.fillColor(Color.argb(64,0,100,0));
     //   mMap.addPolygon(options);

        //三地点を結ぶ半透明の円を描くように大きさを調整
        CircleOptions circleparis = new CircleOptions();
        circleparis.center(paris);
        circleparis.radius(120000);
        mMap.addCircle(circleparis);




    }
}
