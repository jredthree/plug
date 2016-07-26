package com.smart.plug.app.module;

import android.app.Activity;

import com.smart.plug.app.qualifier.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * author: smart
 * time: 2016/7/26
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }


    @Provides
    @ActivityScope
    Activity provideActivity() {
        return this.activity;
    }
}
