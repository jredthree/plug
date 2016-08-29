package com.smart.plug.module.ui.moviedetails;

/**
 * author: smart
 * time: 2016/8/24
 */
public class MovieDetailsPresenter implements MovieDetailsInterface.Presenter {

    private MovieDetailsInterface.View view;
    private MovieDetailsInterface.Model model;

    public MovieDetailsPresenter( MovieDetailsInterface.Model model) {
        this.model = model;
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }
}
