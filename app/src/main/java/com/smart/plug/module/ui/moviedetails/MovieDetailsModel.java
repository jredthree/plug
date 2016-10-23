package com.smart.plug.module.ui.moviedetails;

import com.smart.plug.domain.api.ApiInterface;
import com.smart.plug.domain.entity.MovieBean;

import rx.Subscriber;

/**
 * author: smart
 * time: 2016/8/24
 */
public class MovieDetailsModel implements MovieDetailsInterface.Model {

    private ApiInterface api;
    private OnMovieDetailsListener listener;

    public MovieDetailsModel(ApiInterface api) {
        this.api = api;
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void getMovieDetails(String id) {
        api.getMovieDetails(new Subscriber<MovieBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.onFailed(e);
            }

            @Override
            public void onNext(MovieBean movieBean) {
                listener.onSuccess(movieBean);
            }
        },id);
    }

    @Override
    public void setMovieDetailsListener(OnMovieDetailsListener listener) {
        this.listener = listener;
    }

}
