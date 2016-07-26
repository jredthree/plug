package com.smart.plug.app.module;

import android.app.Activity;

import com.smart.plug.module.ui.main.MainInterface;
import com.smart.plug.module.ui.main.MainModel;
import com.smart.plug.module.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * author: smart
 * time: 2016/7/25
 */

@Module
public class MainModule {

    private MainInterface.View view;

    public MainModule(MainInterface.View view){
        this.view = view;
    }

    @Provides
    public MainInterface.View provideView(){
        return view;
    }

    @Provides
    public MainInterface.Model provideModel(){
        return new MainModel();
    }

    @Provides
    public MainInterface.Presenter providePresenter(MainInterface.View view ,MainInterface.Model model){
        return new MainPresenter(view,model);
    }



}
