package com.smart.plug.module.ui.main;

import android.util.Log;

import com.smart.plug.app.qualifier.ActivityScope;
import com.smart.plug.domain.entity.SoonBean;
import com.smart.plug.module.ui.main.event.SearchViewClickAtoPEvent;
import com.smart.plug.module.ui.main.event.SearchViewClickPtoAEvent;
import com.smart.plug.module.ui.moviedetails.event.IntentMovieDetailsEvent;
import com.smart.plug.utils.RxBus;

import rx.Subscription;
import rx.functions.Action1;

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
    private Subscription searchSubscription;

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
        RxBus.getInstance().post(new IntentMovieDetailsEvent(bean.getId()));
    }

    @Override
    public void initCount() {
        start = 0;
        count = 20;
    }


    @Override
    public void freshenData() {
        model.getSoonMovie(start,count);
    }


    @Override
    public void start() {
        start = 0;
        count = 20;

        searchSubscription = RxBus.getInstance().toObserverable(SearchViewClickAtoPEvent.class)
                .subscribe(new Action1<SearchViewClickAtoPEvent>() {
                    @Override
                    public void call(SearchViewClickAtoPEvent event) {
                        RxBus.getInstance().post(new SearchViewClickPtoAEvent());
                    }
                });
    }

    @Override
    public void destory() {
        if (!searchSubscription.isUnsubscribed()){
            searchSubscription.unsubscribe();
        }
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
