package com.himotech.mapdemo;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapDetailFragment extends Fragment {

    private FrameLayout frame_detail;
    private GoogleMap mGoogleMapView;
    private SupportMapFragment mSupportMapDetail;
    private LatLng mLatnogGujOne=new LatLng(18.9158, 72.8267);
    private Timer t;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.map_detail_screen, container,false);
        frame_detail = (FrameLayout) mView.findViewById(R.id.frame_detail);
        intView();
       
        return mView;
    }

    
    
    @Override
    public void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	
    	
    }
    
    private void intView() {
    	
        mSupportMapDetail = new SupportMapFragment();
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(frame_detail.getId(), mSupportMapDetail);
        ft.commit();

        try{
            t = new Timer();
            
            t.schedule(new TimerTask() {

                @Override
                public void run() {
                    getActivity().runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            if(mSupportMapDetail!=null){
                                mGoogleMapView=mSupportMapDetail.getMap();
                                if(mGoogleMapView!=null){
                                    mGoogleMapView.getUiSettings().setZoomControlsEnabled(true);
                                    mGoogleMapView.getUiSettings().setCompassEnabled(true);
                                    mGoogleMapView.getUiSettings().setZoomGesturesEnabled(true);
                                    mGoogleMapView.getUiSettings().setScrollGesturesEnabled(true);
                                    mGoogleMapView.getUiSettings().setRotateGesturesEnabled(true);
                                    mGoogleMapView.getUiSettings().setTiltGesturesEnabled(true);
                                    mGoogleMapView.setMyLocationEnabled(true);

                                    MarkerOptions mMarkerOption=new MarkerOptions();
                                    mMarkerOption.title("Map One").position(mLatnogGujOne).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).snippet("My Name is");
                                    mGoogleMapView.addMarker(mMarkerOption);
                                    mGoogleMapView.animateCamera(CameraUpdateFactory.newLatLngZoom(mLatnogGujOne,8));
                                    t.cancel();
                                }
                            }
                        }
                    });

                }
            }, 500);
            
            
           // t.schedule(, 0, 500);
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
   
}
