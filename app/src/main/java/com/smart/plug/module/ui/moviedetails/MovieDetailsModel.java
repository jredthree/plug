package com.smart.plug.module.ui.moviedetails;

import com.smart.plug.domain.entity.MovieBean;
import com.smart.plug.domain.http.HttpMethods;

import rx.Subscriber;

/**
 * author: smart
 * time: 2016/8/24
 */
public class MovieDetailsModel implements MovieDetailsInterface.Model {

    private HttpMethods httpMethods;
    private OnMovieDetailsListener listener;

    public MovieDetailsModel(HttpMethods httpMethods) {
        this.httpMethods = httpMethods;
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void getMovieDetails(String id) {
        httpMethods.getMovieDetails(new Subscriber<MovieBean>() {
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
