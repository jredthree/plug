package com.smart.plug.utils;


import android.util.Log;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * author: smart
 * time: 2016/8/29
 */
public class RxBus {

    private static volatile RxBus instance;
    private final Subject<Object,Object> _Bus;

    private RxBus() {
        _Bus = new SerializedSubject<>(PublishSubject.create());
    }

    public static RxBus getInstance() {
        if (null == instance) {
            synchronized (RxBus.class) {
                if (null == instance) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }

    public void post(Object event) {

        _Bus.onNext(event);
    }

    public <T> Observable<T> toObserverable(Class<T> eventType) {
        // ofType = filter + cast
        Log.i("TAG",eventType.toString()+"-----------");
        return _Bus.ofType(eventType);
    }
}
