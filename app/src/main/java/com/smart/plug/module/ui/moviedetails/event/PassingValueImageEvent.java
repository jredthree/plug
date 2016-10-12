package com.smart.plug.module.ui.moviedetails.event;

/**
 * author: smart
 * time: 2016/10/12
 */

public class PassingValueImageEvent {

    private String imageUrl;

    public PassingValueImageEvent(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
