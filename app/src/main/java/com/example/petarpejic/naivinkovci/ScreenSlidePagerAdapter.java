package com.example.petarpejic.naivinkovci;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.Locale;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 3;
    String title;
    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return  Naslov.newInstance();
            case 1:
                return Povijest.newInstance();
            default:
                return Prijedlog.newInstance();
        }
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Naslovna";
            case 1: return "Povijest";
            case 2: return  "Prijedlog";
        }
        return "";
    }
    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
