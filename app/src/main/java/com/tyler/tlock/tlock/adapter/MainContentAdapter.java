package com.tyler.tlock.tlock.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tyler.tlock.tlock.model.FragmentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 Tyler.
 * @创建时间 2016/10/6  15:11.
 * @描述 ${TODO}.
 */
public class MainContentAdapter extends FragmentPagerAdapter {
    FragmentManager mFragmentManager;
    List<FragmentInfo> mFragmentInfos;

    public MainContentAdapter(FragmentManager fm, ArrayList<FragmentInfo> fragmentInfos) {
        super(fm);
        this.mFragmentManager = fm;
        this.mFragmentInfos = fragmentInfos;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentInfos.get(position).fragment;
    }

    @Override
    public int getCount() {
        return mFragmentInfos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentInfos.get(position).title;
    }
}
