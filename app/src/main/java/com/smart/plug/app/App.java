package com.smart.plug.app;

import android.app.Application;
import android.content.Context;

import com.smart.plug.app.component.AppComponent;
import com.smart.plug.app.component.DaggerAppComponent;
import com.smart.plug.app.module.AppModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * author: smart
 * time: 2016/7/25
 */
public class App extends Application{

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
        installLeak();
    }

    private void setupGraph() {
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    private void installLeak(){
        LeakCanary.install(this);
    }

    public AppComponent component() {
        return component;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }
}



