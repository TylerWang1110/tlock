package com.tyler.tlock.tlock.model;

import android.graphics.drawable.Drawable;

/**
 * @创建者 Tyler.
 * @创建时间 2016/10/6  16:26.
 * @描述 ${TODO}.
 */
public class AppInfo {
    public boolean isLocked;
    public String name;
    public Drawable icon;

    public AppInfo(Drawable icon, boolean isLocked, String name) {
        this.icon = icon;
        this.name = name;
        this.isLocked = isLocked;
    }
}
