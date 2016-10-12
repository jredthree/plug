package com.smart.plug.module.ui.moviedetails.event;

import com.smart.plug.module.base.BaseEvent;

/**
 * author: smart
 * time: 2016/10/11
 */

public class IntentMovieDetailsEvent extends BaseEvent{

    private static final long serialVersionUID = 1L; // 定义序列化ID

    private String id;

    public IntentMovieDetailsEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
