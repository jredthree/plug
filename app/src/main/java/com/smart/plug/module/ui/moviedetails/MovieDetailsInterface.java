package com.smart.plug.module.ui.moviedetails;

import com.smart.plug.domain.entity.MovieBean;
import com.smart.plug.module.base.BaseModel;
import com.smart.plug.module.base.BasePresenter;
import com.smart.plug.module.base.BaseView;

/**
 * author: smart
 * time: 2016/8/24
 */
public interface MovieDetailsInterface {

    interface View extends BaseView {
        String getMovieId();
        void displayView(MovieBean movieBean);
    }

    interface Presenter extends BasePresenter {
        void freshenData();
        void setView(MovieDetailsInterface.View view);
    }

    interface Model extends BaseModel {

        void getMovieDetails(String id);
        void setMovieDetailsListener(MovieDetailsModel.OnMovieDetailsListener listener);

        interface OnMovieDetailsListener{
            void onSuccess(MovieBean movieBean);
            void onFailed(Throwable e);
        }
    }
}
