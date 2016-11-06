package com.tyler.tlock.tlock.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tyler.tlock.tlock.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @创建者 Tyler.
 * @创建时间 2016/10/6  14:54.
 * @描述 ${TODO}.
 */
public class LockedAppFragment extends Fragment implements LockedAppView {


    @Bind(R.id.lv_lockedapplist)
    ListView mLvLockedapplist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.layout_lockedapp, null);
        ButterKnife.bind(this, contentView);
        return contentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
