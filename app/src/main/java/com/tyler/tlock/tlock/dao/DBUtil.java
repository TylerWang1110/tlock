package com.tyler.tlock.tlock.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @创建者 Tyler.
 * @创建时间 2016/11/14  19:54.
 * @描述 ${TODO}.
 */
public class DBUtil {

    private static Dao<AppLockInfo, Integer> mAppInfoDao = null;


    /**
     * 查询数据库
     *
     * @param packageName
     * @return
     */
    public static boolean queryIsLocked(Context context, String packageName) {
        boolean isLocked = false;
        try {
            mAppInfoDao = new AppLockDBOpenHelper(context).getAppInfoDao();
            if (mAppInfoDao != null) {
                List<AppLockInfo> query = mAppInfoDao.queryForEq("packageName", packageName);
                if (query != null && query.size() > 0) {
                    isLocked = query.get(0).isLocked();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isLocked;
    }

    /**
     * 存储到数据库
     *
     * @param packageName
     * @param isLocked
     */
    public static void saveStatuToDB(Context context, String packageName, boolean isLocked) {
        try {
            mAppInfoDao = new AppLockDBOpenHelper(context).getAppInfoDao();
            List<AppLockInfo> query = mAppInfoDao.queryForEq("packageName", packageName);
            if (query != null && query.size() > 0) {
                mAppInfoDao.updateRaw("update AppLockInfo set isLocked = " + isLocked + "where packageName" +
                        " = ?", new String[]{packageName});
            } else {
                mAppInfoDao.create(new AppLockInfo(packageName, isLocked));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
