package com.tyler.tlock.tlock.presenter;

import com.tyler.tlock.tlock.view.MainView;

/**
 * @创建者 Tyler.
 * @创建时间 2016/10/6  12:38.
 * @描述 ${TODO}.
 */
public class MainPresenterImpl implements MainPresenter {
    private MainView mMainView;

    public MainPresenterImpl(MainView mainView) {
        this.mMainView = mainView;
    }

    /**
     * 初始化所有APP信息
     */
    @Override
    public void initApp() {

    }
}
