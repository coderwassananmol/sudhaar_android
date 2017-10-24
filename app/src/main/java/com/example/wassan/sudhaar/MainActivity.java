package com.example.wassan.sudhaar;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends FragmentActivity {
    private static final int tl = Toast.LENGTH_LONG;
    private static final int numPages = 3;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
    /*@Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"Paused",tl).show();
        Log.i("sudhaar","application paused");
    }*/
    /*@Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"Stopped",tl).show();
        Log.i("sudhaar","application stopped");
    }*/
    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Started",tl).show();
        Log.i("sudhaar","application started");
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Welcome back",tl).show();
        Log.i("sudhaar","Resumed");
    }

    /*@Override
    protected void onSaveInstanceState(Bundle OutState) {
        super.onResume();
        Toast.makeText(this,"Saved instance",tl).show();
        Log.i("sudhaar","application saved instance");
    }*/

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new Fragment1();
        }

        @Override
        public int getCount() {
            return numPages;
        }
    }
}
