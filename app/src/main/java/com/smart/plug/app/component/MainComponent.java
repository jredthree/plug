package com.smart.plug.app.component;

import com.smart.plug.app.module.MainModule;
import com.smart.plug.app.qualifier.ActivityScope;
import com.smart.plug.module.ui.main.MainFragment;
import com.smart.plug.module.ui.main.MainInterface;

import dagger.Component;

/**
 * author: smart
 * time: 2016/7/25
 */

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {MainModule.class}
)
public interface MainComponent {
       void inject(MainFragment mainFragment);

       MainInterface.Presenter getPresenter();
}
