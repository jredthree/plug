package com.smart.plug.app.component;

import com.smart.plug.app.module.SearchModule;
import com.smart.plug.app.qualifier.ActivityScope;
import com.smart.plug.module.ui.search.SearchFragment;
import com.smart.plug.module.ui.search.SearchInterface;

import dagger.Component;

/**
 * 作者：洪三
 * 时间： 2016/10/22.
 * 邮箱：redthree3333@gmail.com
 */

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {SearchModule.class}
)
public interface SearchComponent {

    void inject(SearchFragment searchFragment);

    SearchInterface.Presenter getPresenter();
}
