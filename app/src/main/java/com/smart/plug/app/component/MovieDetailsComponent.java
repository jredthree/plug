package com.smart.plug.app.component;

import com.smart.plug.app.module.MovieDetailsModule;
import com.smart.plug.app.qualifier.ActivityScope;
import com.smart.plug.module.ui.moviedetails.MovieDetailsFragment;

import dagger.Component;

/**
 * author: smart
 * time: 2016/8/24
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {MovieDetailsModule.class}
)
public interface MovieDetailsComponent {

    void inject(MovieDetailsFragment movieDetailsFragment);

}
