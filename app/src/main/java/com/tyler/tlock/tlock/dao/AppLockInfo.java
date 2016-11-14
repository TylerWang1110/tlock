package com.tyler.tlock.tlock.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @创建者 Tyler.
 * @创建时间 2016/11/14  19:10.
 * @描述 ${AppLock 数据库bean}.
 */
@DatabaseTable(tableName = "AppLockInfo")
public class AppLockInfo {

    //定义id，
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "packageName")
    private String packageName;

    @DatabaseField(columnName = "isLocked")
    private boolean isLocked;

    //无参数构造函数必须要，否则会报错
    public AppLockInfo() {
    }

    public AppLockInfo(String packageName, boolean isLocked) {
        this.packageName = packageName;
        this.isLocked = isLocked;
    }

    public int getId() {
        return id;
    }

    public String getPackageName() {
        return packageName;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
