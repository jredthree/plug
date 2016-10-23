package com.smart.plug.domain.http;

import com.smart.plug.domain.entity.MovieBean;
import com.smart.plug.domain.entity.SoonBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * author: smart
 * time: 2016/8/10
 */
public interface ApiService {

    @GET("coming_soon")
    Observable<SoonBean> getSoonMovie(@Query("start") int start, @Query("count") int count);

    @GET("subject/{id}")
    Observable<MovieBean> getMovieDetails(@Path("id") String id);

    @GET("search")
    Observable<SoonBean> getSearchMovie(@Query("q") String q, @Query("tag") String tag,@Query("start") int start,@Query("count") int count);
}
