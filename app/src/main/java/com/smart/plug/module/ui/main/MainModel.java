package com.smart.plug.module.ui.main;

import com.smart.plug.domain.entity.SoonBean;
import com.smart.plug.domain.http.HttpMethods;

import rx.Subscriber;

/**
 * author: smart
 * time: 2016/7/25
 */
public class MainModel implements MainInterface.Model {

    private OnSoonMovieListener onSoonMovieListener;

    private HttpMethods httpMethods;

    public MainModel(HttpMethods httpMethods) {
        this.httpMethods = httpMethods;
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void getSoonMovie(int start, int count) {
        httpMethods.getSoonMovie(new Subscriber<SoonBean>() {
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
