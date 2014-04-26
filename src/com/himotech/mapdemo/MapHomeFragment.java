package com.himotech.mapdemo;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ViewSwitcher;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapHomeFragment extends Fragment implements GoogleMap.OnInfoWindowClickListener,View.OnClickListener {

    private GoogleMap mMapView;
    private FragmentManager mFragMrg;
    private SupportMapFragment mSupportMapFragment;

    private LatLng mLatnogGuj=new LatLng(23.0626, 72.5809);
    private LatLng mLatnogGujOne=new LatLng(18.9158, 72.8267);
    private LatLng mLatnogGujTwo=new LatLng(24.5925, 72.7156);
    private LatLng mLatnogGuj3=new LatLng(34.0837,74.7974);
    private LatLng mLatnogGuj4=new LatLng(23.2245, 72.6379);
    private LatLng mLatnogGuj5=new LatLng(12.9716, 77.5946);
    private LatLng mLatnogGuj6=new LatLng(23.0396, 72.5660);
    private LatLng mLatnogGuj7=new LatLng(22.3140, 73.1748);
    private LatLng mLatnogGuj8=new LatLng(20.5732, 73.7442);
    private LatLng mLatnogGuj9=new LatLng(21.1785, 72.8191);
    private LatLng mLatnogGuj10=new LatLng(28.6644, 77.2349);
    private Button mBtnMapDetail;
    private ViewSwitcher mViewSwitcher;
    private MapDetailFragment mMapDetailFragment;
    private FrameLayout fram_map_home_fragment;
    private Timer t;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View mView=inflater.inflate(R.layout.home_map, container, false);
        fram_map_home_fragment = (FrameLayout) mView.findViewById(R.id.fram_map_home_fragment);
        initView(mView);
        return mView;
    }


    private void initView(View mView){
       
    	mViewSwitcher=(ViewSwitcher)mView.findViewById(R.id.viewSwitcher);
       
        mViewSwitcher.showNext();

        try{
            MapsInitializer.initialize(getActivity());
        }catch(Exception Exc){
            Exc.printStackTrace();
        }

        mBtnMapDetail=(Button)mView.findViewById(R.id.btn_mapdetail);
        mBtnMapDetail.setOnClickListener(this);

        mFragMrg=getActivity().getSupportFragmentManager();//getFragmentManager();
        mSupportMapFragment = new SupportMapFragment();
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(fram_map_home_fragment.getId(), mSupportMapFragment);
        ft.commit();

        try{
            t = new Timer();
            t.schedule(new TimerTask() {

                @Override
                public void run() {
                    getActivity().runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                                if(mSupportMapFragment!=null){
                                    mMapView=mSupportMapFragment.getMap();
                                    if(mMapView!=null){
                                        mMapView.getUiSettings().setZoomControlsEnabled(true);
                                        mMapView.getUiSettings().setCompassEnabled(true);
                                        mMapView.getUiSettings().setZoomGesturesEnabled(true);
                                        mMapView.getUiSettings().setScrollGesturesEnabled(true);
                                        mMapView.getUiSettings().setRotateGesturesEnabled(true);
                                        mMapView.getUiSettings().setTiltGesturesEnabled(true);
                                        mMapView.setMyLocationEnabled(true);
                                        mMapView.setOnInfoWindowClickListener(MapHomeFragment.this);
                                        mMapView.setInfoWindowAdapter(new CustomInfoViewAdapter(getActivity()));

                                        MarkerOptions mMarkerOption=new MarkerOptions();
                                        mMarkerOption.title("Map One").position(mLatnogGuj).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                        mMapView.addMarker(mMarkerOption);


                                        MarkerOptions mMarkerOption1=new MarkerOptions();
                                        mMarkerOption1.title("Map One").position(mLatnogGujOne).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                        mMapView.addMarker(mMarkerOption1);

                                        MarkerOptions mMarkerOption2=new MarkerOptions();
                                        mMarkerOption2.title("Map One").position(mLatnogGujTwo).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                        mMapView.addMarker(mMarkerOption2);

                                        MarkerOptions mMarkerOption3=new MarkerOptions();
                                        mMarkerOption3.title("Map One").position(mLatnogGuj3).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                        mMapView.addMarker(mMarkerOption3);


                                        MarkerOptions mMarkerOption4=new MarkerOptions();
                                        mMarkerOption4.title("Map One").position(mLatnogGuj4).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                        mMapView.addMarker(mMarkerOption4);

                                        MarkerOptions mMarkerOption5=new MarkerOptions();
                                        mMarkerOption5.title("Map One").position(mLatnogGuj5).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                        mMapView.addMarker(mMarkerOption5);


                                        MarkerOptions mMarkerOption6=new MarkerOptions();
                                        mMarkerOption6.title("Map One").position(mLatnogGuj6).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                        mMapView.addMarker(mMarkerOption6);


                                        MarkerOptions mMarkerOption7=new MarkerOptions();
                                        mMarkerOption7.title("Map One").position(mLatnogGuj7).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                        mMapView.addMarker(mMarkerOption7);

                                        MarkerOptions mMarkerOption8=new MarkerOptions();
                                        mMarkerOption8.title("Map One").position(mLatnogGuj8).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                        mMapView.addMarker(mMarkerOption8);

                                        MarkerOptions mMarkerOption9=new MarkerOptions();
                                        mMarkerOption9.title("Map One").position(mLatnogGuj9).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                        mMapView.addMarker(mMarkerOption9);


                                        MarkerOptions mMarkerOption10=new MarkerOptions();
                                        mMarkerOption10.title("Map One").position(mLatnogGuj10).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                        mMapView.addMarker(mMarkerOption10);

                                        mMapView.animateCamera(CameraUpdateFactory.newLatLngZoom(mLatnogGujOne,4));
                                        t.cancel();
                                    }
                                }
                        }
                    });

                }
            }, 0, 500);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public class CustomInfoViewAdapter implements GoogleMap.InfoWindowAdapter {

        View mLayoutInfo;

        public CustomInfoViewAdapter(Context _Context){
            LayoutInflater mLayoutInflater=(LayoutInflater) _Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mLayoutInfo=mLayoutInflater.inflate(R.layout.fragment_map, null);
        }

        @Override
        public View getInfoContents(Marker marker) {
            return mLayoutInfo;
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

    }


    @Override
    public void onInfoWindowClick(Marker arg0) {
    }


    @Override
    public void onClick(View v) {
        intiDetailFragment();
    }


    private void intiDetailFragment(){
        FragmentTransaction mFt=mFragMrg.beginTransaction();
        mMapDetailFragment=new MapDetailFragment();
        mFt.add(R.id.frame_holder, mMapDetailFragment, "DetailFragment").addToBackStack("DetailFragment").commit();
    }

}