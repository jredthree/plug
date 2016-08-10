package com.smart.plug.app.component;

import android.content.Context;

import com.smart.plug.app.module.AppModule;
import com.smart.plug.module.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * author: smart
 * time: 2016/7/25
 */

@Singleton
@Component( modules = {
        AppModule.class
})

public interface AppComponent {
    void inject(BaseActivity baseActivity);

    Context context();


}
