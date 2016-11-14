package com.tyler.tlock.tlock.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * @创建者 Tyler.
 * @创建时间 2016/11/14  19:13.
 * @描述 ${TODO}.
 */
public class AppLockDBOpenHelper extends OrmLiteSqliteOpenHelper {
    public AppLockDBOpenHelper(Context context) {
        super(context, "AppLockInfo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, AppLockInfo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int
            newVersion) {
        try {
            // 更新表
            TableUtils.dropTable(connectionSource, AppLockInfo.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static AppLockDBOpenHelper instance;

    public static synchronized AppLockDBOpenHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (AppLockDBOpenHelper.class) {
                if (instance == null) {
                    instance = new AppLockDBOpenHelper(context);
                }
            }
        }
        return instance;
    }

    private Dao<AppLockInfo, Integer> dao;

    // 获取操作数据库的DAO
    public Dao<AppLockInfo, Integer> getAppInfoDao() throws SQLException {
        if (dao == null) {
            dao = getDao(AppLockInfo.class);
        }
        return dao;
    }

    @Override
    public void close() {
        super.close();
        dao = null;
    }
}
