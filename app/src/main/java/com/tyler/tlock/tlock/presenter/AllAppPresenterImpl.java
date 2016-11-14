package com.tyler.tlock.tlock.presenter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;

import com.tyler.tlock.tlock.dao.DBUtil;
import com.tyler.tlock.tlock.model.AppInfo;
import com.tyler.tlock.tlock.view.AllAppView;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 Tyler.
 * @创建时间 2016/10/6  17:54.
 * @描述 ${TODO}.
 */
public class AllAppPresenterImpl implements AllAppPresenter {
    private final AllAppView mAllAppView;
    private final Context mContext;


    public AllAppPresenterImpl(Context context, AllAppView allAppView) {
        this.mAllAppView = allAppView;
        mContext = context;

    }

    @Override
    public List<AppInfo> getAllAppInfos() {
        List<AppInfo> appInfos = new ArrayList<>();
        Fragment fragment = (Fragment) mAllAppView;
        PackageManager packageManager = fragment.getActivity().getPackageManager();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
        for (ApplicationInfo installedApplication : installedApplications) {
            //获取所有非系统应用
            if ((installedApplication.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
                Drawable drawable = installedApplication.loadIcon(packageManager);
                String name = installedApplication.loadLabel(packageManager).toString();
                String packageName = installedApplication.packageName;
                boolean isLocked = DBUtil.queryIsLocked(mContext,packageName);
                AppInfo appInfo = new AppInfo(drawable, isLocked, name, packageName);
                appInfos.add(appInfo);
            }
        }
        return appInfos;
    }
}
