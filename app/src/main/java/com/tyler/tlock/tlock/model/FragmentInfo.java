package com.tyler.tlock.tlock.model;


import android.support.v4.app.Fragment;

/**
 * @创建者 Tyler.
 * @创建时间 2016/10/6  14:51.
 * @描述 ${TODO}.
 */
public class FragmentInfo {
    public Fragment fragment;
    public String title;

    public FragmentInfo(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }
}
