package com.smart.plug.module.ui.main;

import com.smart.plug.domain.entity.SoonBean;
import com.smart.plug.module.base.BaseModel;
import com.smart.plug.module.base.BasePresenter;
import com.smart.plug.module.base.BaseView;

import java.util.List;

/**
 * author: smart
 * time: 2016/7/25
 */
public interface MainInterface {

    interface View extends BaseView{
        void navigateToLogin();
        void displayRecyclerView(List<SoonBean.SubjectsBean> list);
    }

    interface Presenter extends BasePresenter{
        void freshenData();
        void setView(MainInterface.View view);
    }

    interface Model extends BaseModel{

        void getSoonMovie(int start,int count);
        void setOnSoonMovieListener(MainModel.OnSoonMovieListener onSoonMovieListener);

    }
}
