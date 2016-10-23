package com.smart.plug.module.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.smart.plug.R;
import com.smart.plug.app.component.AppComponent;
import com.smart.plug.app.component.DaggerMainComponent;
import com.smart.plug.app.component.HasComponent;
import com.smart.plug.app.component.MainComponent;
import com.smart.plug.app.module.MainModule;
import com.smart.plug.databinding.ActivityMainBinding;
import com.smart.plug.module.base.BaseActivity;
import com.smart.plug.module.ui.main.event.SearchViewClickAtoPEvent;
import com.smart.plug.module.ui.main.event.SearchViewClickPtoAEvent;
import com.smart.plug.module.ui.moviedetails.MovieDetailsActivity;
import com.smart.plug.module.ui.moviedetails.event.IntentMovieDetailsEvent;
import com.smart.plug.module.ui.search.SearchActivity;
import com.smart.plug.utils.RxBus;

import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent>{

    ActivityMainBinding binding;

    private MainComponent mainComponent;

    private Subscription subscription;

    private Subscription searchSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initializeActivity(savedInstanceState);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        subscription = RxBus.getInstance().toObserverable(IntentMovieDetailsEvent.class)
                .subscribe(new Action1<IntentMovieDetailsEvent>() {
                    @Override
                    public void call(IntentMovieDetailsEvent intentMovieDetailsEvent) {
                        navigateToMovieDetails(intentMovieDetailsEvent);
                    }
                });
    }

    @Override
    protected void onPause() {
        if (!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {

        if (!searchSubscription.isUnsubscribed()){
            searchSubscription.unsubscribe();
        }

        super.onDestroy();
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        mainComponent =  DaggerMainComponent.builder()
                .appComponent(getAppComponent())
                .mainModule(new MainModule(this))
                .build();

    }

    private void initView(){
        binding.toolbar.setTitle(getString(R.string.main_title));

        searchSubscription = RxBus.getInstance().toObserverable(SearchViewClickPtoAEvent.class)
                .subscribe(new Action1<SearchViewClickPtoAEvent>() {
                    @Override
                    public void call(SearchViewClickPtoAEvent event) {
                        navigateToSearch();
                    }
                });


        binding.filterEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxBus.getInstance().post(new SearchViewClickAtoPEvent());
            }
        });
    }

    public void navigateToMovieDetails(IntentMovieDetailsEvent event) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra("IntentMovieDetailsEvent",event);
        startActivity(intent);
    }

    public void navigateToSearch() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onFinish() {
       this.finish();
    }


    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fl_fragment, MainFragment.newInstance(), MainFragment.class.getSimpleName());
        } else {

        }
    }

    @Override
    public MainComponent getComponent() {
        return mainComponent;
    }
}
