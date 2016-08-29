package com.smart.plug.module.ui.main;

import android.util.Log;

import com.smart.plug.app.qualifier.ActivityScope;
import com.smart.plug.domain.entity.SoonBean;

/**
 * author: smart
 * time: 2016/7/25
 */
@ActivityScope
public class MainPresenter implements MainInterface.Presenter,MainModel.OnSoonMovieListener {

    private MainInterface.View view;
    private MainInterface.Model model;
    private int start;
    private int count;
    public MainPresenter(MainInterface.Model model) {
        this.model = model;
        this.model.setOnSoonMovieListener(this);
    }

    @Override
    public void setView(MainInterface.View view) {
        this.view = view;
    }

    @Override
    public void recyclerOnClick(int position, SoonBean.SubjectsBean bean) {
        view.navigateToMovieDetails();
    }

    @Override
    public void freshenData() {
        model.getSoonMovie(start,count);
    }


    @Override
    public void start() {
         start = 0;
         count = 20;
    }

    @Override
    public void destory() {

    }

    @Override
    public void onSuccess(SoonBean soonBean) {
        view.displayRecyclerView(soonBean.getSubjects());
    }

    @Override
    public void onFailed(Throwable e) {
        Log.d("TAG","-----"+ e.toString());
    }
}
