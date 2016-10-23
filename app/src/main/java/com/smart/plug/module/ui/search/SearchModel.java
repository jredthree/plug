package com.smart.plug.module.ui.search;

import com.smart.plug.domain.api.ApiInterface;
import com.smart.plug.domain.entity.SoonBean;

import rx.Subscriber;

/**
 * 作者：洪三
 * 时间： 2016/10/22.
 * 邮箱：redthree3333@gmail.com
 */

public class SearchModel implements SearchInterface.Model {

    private ApiInterface api;

    private OnSearchMovieResult listener;

    public SearchModel(ApiInterface api) {
        this.api = api;
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void searchMovie(String q, String tag,int start,int count) {
        api.getSearchMovie(new Subscriber<SoonBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.onFailed(e);
            }

            @Override
            public void onNext(SoonBean soonBean) {
                listener.onSuccess(soonBean);
            }
        },q,tag,start,count);
    }

    @Override
    public void setListener(OnSearchMovieResult result) {
        this.listener = result;
    }
}
