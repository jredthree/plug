package com.smart.plug.module.ui.search;

import android.util.Log;

import com.smart.plug.domain.entity.SoonBean;
import com.smart.plug.module.ui.moviedetails.event.IntentMovieDetailsEvent;
import com.smart.plug.utils.RxBus;

import rx.Subscriber;

/**
 * 作者：洪三
 * 时间： 2016/10/22.
 * 邮箱：redthree3333@gmail.com
 */

public class SearchPresenter implements SearchInterface.Presenter ,SearchInterface.Model.OnSearchMovieResult{

    private SearchInterface.View view;
    private SearchInterface.Model model;
    private int start;
    private int count;
    private boolean isLoadMore;

    public SearchPresenter(SearchInterface.Model model) {
        this.model = model;
        model.setListener(this);
    }

    private void freshenData() {
        model.searchMovie(view.getQ(),view.getMovieTag(),start,count);
    }

    @Override
    public void setView(SearchInterface.View view) {
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
        isLoadMore = false;
        freshenData();
    }

    public void loadMore(){
        start = count;
        count += 20;
        isLoadMore = true;
        freshenData();
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void onSuccess(final SoonBean soonBean) {
        rx.Observable.create(new rx.Observable.OnSubscribe<SoonBean>() {
            @Override
            public void call(Subscriber<? super SoonBean> subscriber) {
                subscriber.onNext(soonBean);
                if(soonBean.getSubjects().size() == 20){
                    subscriber.onCompleted();
                }
            }
        }).subscribe(new Subscriber<SoonBean>() {
            @Override
            public void onCompleted() {
                view.isLoad();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SoonBean soonBean) {
                if(isLoadMore)
                    view.displayLoadMore(soonBean.getSubjects());
                else
                    view.displayRefresh(soonBean.getSubjects());
            }
        });

    }

    @Override
    public void onFailed(Throwable e) {
        Log.i("TAG",e.toString()+"---------------");
    }
}
