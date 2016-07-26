package com.smart.plug.app.component;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.smart.plug.app.module.ActivityModule;
import com.smart.plug.app.qualifier.ActivityScope;

import dagger.Component;

/**
 * author: smart
 * time: 2016/7/26
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = ActivityModule.class
)

public interface ActivityComponent {

    Activity activity();
}
