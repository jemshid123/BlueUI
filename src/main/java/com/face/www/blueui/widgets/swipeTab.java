package com.face.www.blueui.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.face.www.blueui.R;

import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * Created by Jemshid on 27-01-2018.
 */

public class swipeTab extends RelativeLayout {
    LayoutInflater layoutInflater;
    FragmentManager fragmentManager;
    slideFragmentViewPagerAdapter viewPagerAdapter;
    ActionBar actionBar;
    ViewPager viewPager;
    View v;

    public swipeTab(Context context) {
        super(context);

        layoutInflater=LayoutInflater.from(context);
        init();
    }

    public swipeTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        layoutInflater=LayoutInflater.from(context);
        init();
    }

    public swipeTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        layoutInflater=LayoutInflater.from(context);
        init();
    }

    public swipeTab(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        layoutInflater=LayoutInflater.from(context);
        init();
    }

    public void init()
{
    v = (View)layoutInflater.inflate(R.layout.swipetablayout,this,true);
}

    public  void initialze(FragmentManager fragmentManager,ActionBar actionBar)
    {
        final ActionBar a1=actionBar;



        viewPagerAdapter=new slideFragmentViewPagerAdapter(fragmentManager);

            Log.d("view ",v.isShown()+" ");

        viewPager=(ViewPager)v.findViewById(R.id.viewpager) ;
        viewPager.setAdapter(viewPagerAdapter);
        this.fragmentManager=fragmentManager;
        this.actionBar=actionBar;
        this.actionBar.setHomeButtonEnabled(false);
        this.actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                a1.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });



    }
public  void addTab(String string,Fragment fragment)
{
   ActionBar.Tab tab= actionBar.newTab();
    tab.setText(string);
    tab.setTabListener(new ActionBar.TabListener() {
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    });
    actionBar.addTab(tab);
    addFragment(fragment);




}
    public  void addTab(String string,int resid,Fragment fragment)
    {
        ActionBar.Tab tab= actionBar.newTab();
        tab.setText(string);
        tab.setIcon(resid);
        tab.setTabListener(new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        });
        actionBar.addTab(tab);
        addFragment(fragment);



    }


    public  void addTab(String string,Drawable drawable,Fragment fragment)
    {
        ActionBar.Tab tab= actionBar.newTab();
        tab.setText(string);
        tab.setIcon(drawable);
        tab.setTabListener(new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        });
        actionBar.addTab(tab);
        addFragment(fragment);



    }

    //more flexible options
    public ActionBar.Tab getnewTab()
    {
        return actionBar.newTab();
    }

    public void addTab(ActionBar.Tab tab,Fragment fragment)
    {
        tab.setTabListener(new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        });
        actionBar.addTab(tab);
        addFragment(fragment);
    }




    private void addFragment(Fragment fragment)
    {
        viewPagerAdapter.addFragment(fragment);
    }

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



}
