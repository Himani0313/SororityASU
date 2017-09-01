package com.example.himanishah.udemyadvancedcourse.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.himanishah.udemyadvancedcourse.R;
import com.example.himanishah.udemyadvancedcourse.entities.RushEvents;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by himanisha on 9/1/17.
 */

public class ActivityMaps extends BaseActivity {
    @BindView(R.id.activity_map_rush_name)
    TextView rushName;
    @BindView(R.id.activity_map_rush_time)
    TextView rushTime;
    @BindView(R.id.activity_map_rush_description)
    TextView rushDescription;
    @BindView(R.id.activity_map_rush_date)
    TextView rushDate;
    @BindView(R.id.activity_map_rush_location)
    TextView rushLocation;

    private GoogleApiClient mClient;
    private GoogleMap mMap;
    private RushEvents rushEvents;
    public static final String RUSH_EVENT_INFO = "RUSH_EVENT_INFO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
        rushEvents = getIntent().getParcelableExtra(RUSH_EVENT_INFO);
        rushName.setText(rushEvents.getEventName());
        rushDate.setText(rushEvents.getEventDate());
        rushTime.setText(rushEvents.getEventTime());
        rushDescription.setText(rushEvents.getEventDiscription());
        rushLocation.setText(rushEvents.getEventLocation());

        mClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(@Nullable Bundle bundle) {
                        updateUI();
                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                }).build();
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.activity_map_map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mClient.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mClient.disconnect();
    }

    public void updateUI(){
        LatLng rushEventPoint = new LatLng(
                rushEvents.getEventLatitude(),rushEvents.getEventsLongitude()
        );
        MarkerOptions rushEventMarker = new MarkerOptions()
                .position(rushEventPoint)
                .title("Rush Event Location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        mMap.clear();
        mMap.addMarker(rushEventMarker);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rushEventPoint,15));
    }
    public static Intent newIntent(Context context,RushEvents rushEvents){
        Intent intent = new Intent(context,ActivityMaps.class);
        intent.putExtra(RUSH_EVENT_INFO,rushEvents);
        return intent;
    }
}
