package com.smart.plug.domain.http;

import com.smart.plug.domain.entity.SoonBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * author: smart
 * time: 2016/8/10
 */
public interface ApiService {

    @GET("coming_soon")
    Observable<SoonBean> getSoonMovie(@Query("start") int start, @Query("count") int count);
}
