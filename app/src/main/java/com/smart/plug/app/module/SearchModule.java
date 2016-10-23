package com.smart.plug.app.module;

import android.support.annotation.NonNull;

import com.smart.plug.domain.api.ApiInterface;
import com.smart.plug.module.ui.search.SearchActivity;
import com.smart.plug.module.ui.search.SearchInterface;
import com.smart.plug.module.ui.search.SearchModel;
import com.smart.plug.module.ui.search.SearchPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：洪三
 * 时间： 2016/10/22.
 * 邮箱：redthree3333@gmail.com
 */

@Module
public class SearchModule {

    private SearchActivity activity;

    public SearchModule(SearchActivity activity){
        this.activity = activity;
    }

    @Provides
    @Singleton
    public SearchActivity provideActivity(){
        return activity;
    }

    @Provides
    public SearchInterface.Model provideModel(ApiInterface apiInterface){
        return new SearchModel(apiInterface);
    }

    @Provides
    public SearchInterface.Presenter providePresenter(@NonNull SearchInterface.Model model){
        return new SearchPresenter(model);
    }

}

