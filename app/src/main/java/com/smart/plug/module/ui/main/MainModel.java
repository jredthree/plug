package com.smart.plug.module.ui.main;

import android.util.Log;

/**
 * author: smart
 * time: 2016/7/25
 */
public class MainModel implements MainInterface.Model {
    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void test(String name) {
        Log.d("TAG",name);
    }
}
