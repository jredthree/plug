package com.smart.plug.app.component;

import com.smart.plug.app.module.ActivityModule;
import com.smart.plug.app.qualifier.ActivityScope;
import com.smart.plug.module.ui.main.MainActivity;
import com.smart.plug.app.module.MainModule;

import dagger.Component;

/**
 * author: smart
 * time: 2016/7/25
 */

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {MainModule.class,ActivityModule.class}
)
public interface MainComponent {
       void inject(MainActivity activity);
}
