package com.smart.plug.module.ui.moviedetails;

import com.smart.plug.domain.http.HttpMethods;

/**
 * author: smart
 * time: 2016/8/24
 */
public class MovieDetailsModel implements MovieDetailsInterface.Model {

    private HttpMethods httpMethods;

    public MovieDetailsModel(HttpMethods httpMethods) {
        this.httpMethods = httpMethods;
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }
}
