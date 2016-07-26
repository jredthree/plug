package com.smart.plug.app.module;

import android.app.Application;
import android.content.Context;

import com.smart.plug.app.App;
import com.smart.plug.module.base.BaseModel;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * author: smart
 * time: 2016/7/25
 * action:提供全局Appliation对象
 */
@Module
public class AppModule {

    private App app;

    @Inject
    public AppModule(App app){
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideApplication(){
        return this.app;
    }

}
