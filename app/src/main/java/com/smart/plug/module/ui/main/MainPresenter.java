package com.smart.plug.module.ui.main;

import android.app.Activity;

import com.smart.plug.app.qualifier.ActivityScope;

import javax.inject.Inject;

/**
 * author: smart
 * time: 2016/7/25
 */
@ActivityScope
public class MainPresenter implements MainInterface.Presenter {

    private MainInterface.View view;
    private MainInterface.Model model;

    public MainPresenter(MainInterface.View view, MainInterface.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void freshenData() {
        model.test("a");
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }
}
