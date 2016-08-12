package com.smart.plug.domain.http;

import com.smart.plug.domain.entity.SoonBean;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author: smart
 * time: 2016/8/10
 */
public class HttpMethods {

  private ApiService apiService;


  public HttpMethods( ApiService apiService) {
    this.apiService = apiService;
  }

  public void getSoonMovie(Subscriber<SoonBean> subscriber, int start,int count){

    Observable<SoonBean> observable = apiService.getSoonMovie(start,count);

    toSubscribe(observable,subscriber);

 }

  private <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
    o.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(s);
  }
}
