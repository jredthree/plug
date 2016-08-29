package com.smart.plug.utils;


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
}
