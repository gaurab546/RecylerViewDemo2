package com.example.aspirev15.newfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.ArrayList;

/**
 * Created by Aspire V15 on 12/6/2016.
 */

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    String [] title;
    ArrayList<Fragment> fragments;

    public ViewPageAdapter(android.support.v4.app.FragmentManager fm, String[] subtitle, ArrayList<Fragment> fragments) {
        super(fm);
        this.title= subtitle;
        this.fragments= fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    @Override
    public int getCount(){
    return title.length;
    }

    public CharSequence getPageTitle(int position){
        return title[position];
    }
}

