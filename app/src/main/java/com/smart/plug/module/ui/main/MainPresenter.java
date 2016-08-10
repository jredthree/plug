package com.smart.plug.module.ui.main;

import android.app.Activity;

import com.smart.plug.app.module.MainModule;
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

    public MainPresenter(MainInterface.Model model) {
        this.model = model;
    }

    @Override
    public void setView(MainInterface.View view) {
        this.view = view;
    }

    @Override
    public void freshenData() {
        model.test("a");
        view.navigateToLogin();
    }


    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }
}
