package com.tyler.tlock.tlock.view;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.tyler.tlock.tlock.R;
import com.tyler.tlock.tlock.adapter.AppAdapter;
import com.tyler.tlock.tlock.dao.DBUtil;
import com.tyler.tlock.tlock.model.AppInfo;
import com.tyler.tlock.tlock.presenter.AllAppPresenterImpl;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * @创建者 Tyler.
 * @创建时间 2016/10/6  13:57.
 * @描述 ${TODO}.
 */
public class AllAppFragment extends Fragment implements AllAppView, AdapterView.OnItemClickListener {

    @Bind(R.id.lv_allapplist)
    ListView mLvContent;
    private AllAppPresenterImpl mAllAppPresenter;
    private List<AppInfo> mAllAppInfos;
    private AppAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.layout_allapp, null);
        ButterKnife.bind(this, contentView);
        mAllAppPresenter = new AllAppPresenterImpl(getContext(), this);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mAllAppInfos = mAllAppPresenter.getAllAppInfos();
        mAdapter = new AppAdapter(mAllAppInfos);
        mLvContent.setAdapter(mAdapter);
        mLvContent.setOnItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //        Switch sw = (Switch) view.findViewById(R.id.sw_item);
        //        boolean selected = sw.isSelected();
        //        sw.setChecked(!selected);

        AppInfo appInfo = mAllAppInfos.get(position);
        String packageName = appInfo.packageName;
        boolean isLocked = appInfo.isLocked;
        ImageView iv = (ImageView) view.findViewById(R.id.iv_item_lock);
        iv.setImageResource(isLocked ? R.mipmap.btn_l_lock : R.mipmap.btn_l_onlock);
        DBUtil.saveStatuToDB(this.getContext(), packageName, !isLocked);
        mAdapter.notifyDataSetChanged();
    }
}
