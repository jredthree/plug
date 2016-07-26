package com.smart.plug.module.ui.main;

import com.smart.plug.module.base.BaseModel;
import com.smart.plug.module.base.BasePresenter;
import com.smart.plug.module.base.BaseView;

/**
 * author: smart
 * time: 2016/7/25
 */
public interface MainInterface {

    interface View extends BaseView{
        void navigateToLogin();
    }

    interface Presenter extends BasePresenter{
        void freshenData();
    }

    interface Model extends BaseModel{

        void test(String name);

    }
}
