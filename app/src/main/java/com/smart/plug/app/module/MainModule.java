package com.smart.plug.app.module;

import android.support.annotation.NonNull;

import com.smart.plug.module.ui.main.MainActivity;
import com.smart.plug.module.ui.main.MainInterface;
import com.smart.plug.module.ui.main.MainModel;
import com.smart.plug.module.ui.main.MainPresenter;
import com.smart.plug.module.ui.main.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * author: smart
 * time: 2016/7/25
 */

@Module
public class MainModule {

    private MainActivity activity;

    public MainModule(MainActivity activity){
       this.activity = activity;
    }

    @Provides
    @Singleton
    public MainActivity provideActivity(){
        return activity;
    }

    @Provides
    public MainInterface.Model provideModel(@NonNull User user){
        return new MainModel(user);
    }

    @Provides
    public MainInterface.Presenter providePresenter(@NonNull MainInterface.Model model){
        return new MainPresenter(model);
    }

}
