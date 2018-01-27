package com.face.www.blueui.viewPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Jemshid on 27-01-2018.
 * used to create slidable fragments usig vewpager
 */

public  class  slideFragmentViewPagerAdapter extends FragmentStatePagerAdapter
{
    ArrayList<Fragment> fragments=new ArrayList<Fragment>();

    public slideFragmentViewPagerAdapter(FragmentManager fm, Fragment fragment[]) {

        super(fm);
        for(Fragment f:fragment)
        {
            fragments.add(f);

        }

    }
    public slideFragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }
    public  void addFragment(Fragment fragment)
    {
        fragments.add(fragment);
        this.notifyDataSetChanged();
    }
    public  void  removeFragment(int position)
    {
        fragments.remove(position);
        this.notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);

    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}


