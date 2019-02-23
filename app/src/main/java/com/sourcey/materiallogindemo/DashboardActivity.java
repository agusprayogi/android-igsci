package com.sourcey.materiallogindemo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.widget.FrameLayout;

import com.sourcey.materiallogindemo.R;


public class DashboardActivity extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private DasboardFragment dashboardFragment;
    private SertifikasiFragment sertifikasiFragment;
    private PelatihanFragment pelatihanFragment;
    private AccountFragment accountFragment;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        dashboardFragment = new DasboardFragment();
        sertifikasiFragment = new SertifikasiFragment();
        pelatihanFragment = new PelatihanFragment();
        accountFragment = new AccountFragment();


        setFragment(dashboardFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())   {

                    case R.id.nav_dashboard :
                        mMainNav.setItemBackgroundResource(R.color.primary);
                        setFragment(dashboardFragment);
                        return true;

                    case R.id.nav_sertifikasi :
                        mMainNav.setItemBackgroundResource(R.color.accent);
                        setFragment(sertifikasiFragment);
                        return true;

                    case R.id.nav_pelatihan :
                        mMainNav.setItemBackgroundResource(R.color.primary);
                        setFragment(pelatihanFragment);
                        return true;

                    case R.id.nav_account :
                        mMainNav.setItemBackgroundResource(R.color.accent);
                        setFragment(accountFragment);
                        return true;

                        default:
                            return false;

                }


            }

        });

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager() .beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();


    }
}

