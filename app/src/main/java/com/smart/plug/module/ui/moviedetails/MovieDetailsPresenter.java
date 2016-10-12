package com.smart.plug.module.ui.moviedetails;

import android.util.Log;

import com.smart.plug.app.qualifier.ActivityScope;
import com.smart.plug.domain.entity.MovieBean;

/**
 * author: smart
 * time: 2016/8/24
 */
@ActivityScope
public class MovieDetailsPresenter implements MovieDetailsInterface.Presenter,MovieDetailsInterface.Model.OnMovieDetailsListener{

    private MovieDetailsInterface.View view;
    private MovieDetailsInterface.Model model;

    public MovieDetailsPresenter(MovieDetailsInterface.Model model) {
        this.model = model;
        this.model.setMovieDetailsListener(this);
    }

    @Override
    public void setView(MovieDetailsInterface.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void freshenData() {
        model.getMovieDetails(view.getMovieId());
    }


    @Override
    public void onSuccess(MovieBean movieBean) {
        Log.d("TAG","-----"+movieBean.getAlt());
        view.displayView(movieBean);
    }

    @Override
    public void onFailed(Throwable e) {
        Log.d("TAG","-----details:"+ e.toString());
    }
}
