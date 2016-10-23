package com.smart.plug.module.ui.search;

import com.smart.plug.domain.entity.SoonBean;
import com.smart.plug.module.base.BaseModel;
import com.smart.plug.module.base.BasePresenter;
import com.smart.plug.module.base.BaseView;

import java.util.List;

/**
 * 作者：洪三
 * 时间： 2016/10/22.
 * 邮箱：redthree3333@gmail.com
 */

public interface SearchInterface {

    interface View extends BaseView {
        void displayLoadMore(List<SoonBean.SubjectsBean> list);
        void displayRefresh(List<SoonBean.SubjectsBean> list);
        void isLoad();
        String getQ();
        String getMovieTag();
    }

    interface Presenter extends BasePresenter {
        void setView(SearchInterface.View view);
        void recyclerOnClick(int position,SoonBean.SubjectsBean bean);
        void initCount();
        void loadMore();
    }

    interface Model extends BaseModel {
        void searchMovie(String q,String tag,int start,int count);
        void setListener(OnSearchMovieResult result);

        interface OnSearchMovieResult{
            void onSuccess(SoonBean soonBean);
            void onFailed(Throwable e);
        }
    }
}
