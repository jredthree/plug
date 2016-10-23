package com.smart.plug.app.module;

import android.support.annotation.NonNull;

import com.smart.plug.domain.api.ApiInterface;
import com.smart.plug.domain.http.HttpMethods;
import com.smart.plug.module.ui.moviedetails.MovieDetailsActivity;
import com.smart.plug.module.ui.moviedetails.MovieDetailsInterface;
import com.smart.plug.module.ui.moviedetails.MovieDetailsModel;
import com.smart.plug.module.ui.moviedetails.MovieDetailsPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * author: smart
 * time: 2016/8/24
 */

@Module
public class MovieDetailsModule {

    private MovieDetailsActivity activity;

    public MovieDetailsModule(MovieDetailsActivity activity){
        this.activity = activity;
    }

    @Provides
    @Singleton
    public MovieDetailsActivity provideActivity(){
        return activity;
    }

    @Provides
    public MovieDetailsInterface.Model provideModel(ApiInterface apiInterface){
        return new MovieDetailsModel(apiInterface);
    }

    @Provides
    public MovieDetailsInterface.Presenter providePresenter(@NonNull MovieDetailsInterface.Model model){
        return new MovieDetailsPresenter(model);
    }


}
