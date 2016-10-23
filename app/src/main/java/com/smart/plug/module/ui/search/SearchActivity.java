package com.smart.plug.module.ui.search;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.smart.plug.R;
import com.smart.plug.app.component.AppComponent;
import com.smart.plug.app.component.DaggerSearchComponent;
import com.smart.plug.app.component.HasComponent;
import com.smart.plug.app.component.SearchComponent;
import com.smart.plug.app.module.SearchModule;
import com.smart.plug.databinding.ActivitySearchBinding;
import com.smart.plug.module.base.BaseActivity;
import com.smart.plug.module.ui.moviedetails.MovieDetailsActivity;
import com.smart.plug.module.ui.moviedetails.event.IntentMovieDetailsEvent;
import com.smart.plug.utils.RxBus;

import rx.Subscription;
import rx.functions.Action1;

/**
 * 作者：洪三
 * 时间： 2016/10/22.
 * 邮箱：redthree3333@gmail.com
 */

public class SearchActivity extends BaseActivity implements HasComponent<SearchComponent> {

    ActivitySearchBinding binding;

    private SearchComponent searchComponent;

    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        initializeActivity(savedInstanceState);
        initView();
    }

    @Override
    protected void onDestroy() {
        if (!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
        super.onDestroy();
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        searchComponent = DaggerSearchComponent.builder()
                .appComponent(getAppComponent())
                .searchModule(new SearchModule(this))
                .build();

    }

    private void initView() {
        subscription = RxBus.getInstance().toObserverable(IntentMovieDetailsEvent.class)
                .subscribe(new Action1<IntentMovieDetailsEvent>() {
                    @Override
                    public void call(IntentMovieDetailsEvent intentMovieDetailsEvent) {
                        navigateToMovieDetails(intentMovieDetailsEvent);
                    }
                });
    }

    public void navigateToMovieDetails(IntentMovieDetailsEvent event) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra("IntentMovieDetailsEvent", event);
        startActivity(intent);
        onFinish();
    }

    @Override
    protected void onFinish() {
        this.finish();
    }


    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.searchFragment, SearchFragment.newInstance(), SearchFragment.class.getSimpleName());
        } else {

        }
    }

    @Override
    public SearchComponent getComponent() {
        return searchComponent;
    }
}
