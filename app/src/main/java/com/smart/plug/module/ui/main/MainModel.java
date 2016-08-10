package com.smart.plug.module.ui.main;

import android.util.Log;

import javax.inject.Inject;

/**
 * author: smart
 * time: 2016/7/25
 */
public class MainModel implements MainInterface.Model {

    User user;

    public MainModel(User user) {
        this.user = user;
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void test(String name) {
        user.A();
        Log.d("TAG",name);
    }
}
