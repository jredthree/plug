package com.smart.plug.domain.api;

import com.smart.plug.domain.entity.MovieBean;
import com.smart.plug.domain.entity.SoonBean;

import rx.Subscriber;

/**
 * 作者：洪三
 * 时间： 2016/10/22.
 * 邮箱：redthree3333@gmail.com
 */

public interface ApiInterface {

     void getSoonMovie(Subscriber<SoonBean> subscriber, int start, int count);

     void getMovieDetails(Subscriber<MovieBean> subscriber, String id);

    void getSearchMovie(Subscriber<SoonBean> subscriber, String q, String tag,int start,int count);
}
