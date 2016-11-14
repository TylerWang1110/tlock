package com.tyler.tlock.tlock.global;

import android.app.Application;
import android.content.Context;

/**
 * @创建者 Tyler.
 * @创建时间 2016/11/14  19:56.
 * @描述 ${TODO}.
 */
public class app extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        mContext = getApplicationContext();
        super.onCreate();
    }
}
