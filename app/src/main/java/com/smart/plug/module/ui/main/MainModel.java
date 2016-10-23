package com.smart.plug.module.ui.main;

import com.smart.plug.domain.api.ApiInterface;
import com.smart.plug.domain.entity.SoonBean;

import rx.Subscriber;

/**
 * author: smart
 * time: 2016/7/25
 */
public class MainModel implements MainInterface.Model {

    private OnSoonMovieListener onSoonMovieListener;

    private ApiInterface api;

    public MainModel(ApiInterface api) {
        this.api = api;
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void getSoonMovie(int start, int count) {
        api.getSoonMovie(new Subscriber<SoonBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onSoonMovieListener.onFailed(e);
            }

            @Override
            public void onNext(SoonBean soonBean) {
                onSoonMovieListener.onSuccess(soonBean);
            }
        },start,count);
    }

    @Override
    public void setOnSoonMovieListener(OnSoonMovieListener onSoonMovieListener) {
        this.onSoonMovieListener = onSoonMovieListener;
    }

    public interface OnSoonMovieListener{
        void onSuccess(SoonBean soonBean);
        void onFailed(Throwable e);
    }

}
