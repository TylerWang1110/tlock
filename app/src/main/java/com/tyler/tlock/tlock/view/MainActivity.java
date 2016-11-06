package com.tyler.tlock.tlock.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

import com.astuetz.PagerSlidingTabStrip;
import com.tyler.tlock.tlock.R;
import com.tyler.tlock.tlock.adapter.MainContentAdapter;
import com.tyler.tlock.tlock.model.FragmentInfo;
import com.tyler.tlock.tlock.presenter.MainPresenterImpl;
import com.tyler.tlock.tlock.util.DensityUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    @Bind(R.id.tb_main)
    Toolbar mTbMain;
    @Bind(R.id.pstb_main)
    PagerSlidingTabStrip mPstbMain;
    @Bind(R.id.vp_content_main)
    ViewPager mVpContentMain;
    private MainPresenterImpl mMainPresenter;
    private ArrayList<FragmentInfo> mFragmentInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainPresenter = new MainPresenterImpl(this);
        mMainPresenter.initApp();
        initPagerSlidingTabStrip();
        showContent();
    }

    private void initPagerSlidingTabStrip() {
        mPstbMain.setTextColorResource(R.color.white);

        // TODO 15sp 硬编码
        mPstbMain.setTextSize(DensityUtils.sp2px(this,15));
    }


    @Override
    public void showContent() {
        mFragmentInfos = new ArrayList<>();
        mFragmentInfos.add(new FragmentInfo(new AllAppFragment(),getResources().getString(R.string.title_allapp)));
        mFragmentInfos.add(new FragmentInfo(new LockedAppFragment(),getResources().getString(R.string.title_lockedapp)));
        mFragmentInfos.add(new FragmentInfo(new UnlockAppFragment(),getResources().getString(R.string.title_unlockapp)));
        mVpContentMain.setAdapter(new MainContentAdapter(getSupportFragmentManager(),mFragmentInfos));
        mPstbMain.setViewPager(mVpContentMain);
    }
}
