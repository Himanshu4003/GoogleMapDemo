package com.himotech.mapdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity{
    
	private FragmentManager mFragmrg;
    
	public static String TAG_FRAGMENT_HOME="HomeFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initView();
    }
    
    private void initView(){
        mFragmrg=getSupportFragmentManager();
        MapHomeFragment mMapHomeFragment = new MapHomeFragment();
        FragmentTransaction mFt=mFragmrg.beginTransaction();
        mFt.replace(R.id.frame_holder, mMapHomeFragment, TAG_FRAGMENT_HOME).addToBackStack(TAG_FRAGMENT_HOME).commit();
    }
    
}
