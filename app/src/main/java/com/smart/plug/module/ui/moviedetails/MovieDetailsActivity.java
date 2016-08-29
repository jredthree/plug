package com.smart.plug.module.ui.moviedetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.smart.plug.R;
import com.smart.plug.app.component.AppComponent;
import com.smart.plug.app.component.DaggerMovieDetailsComponent;
import com.smart.plug.app.component.HasComponent;
import com.smart.plug.app.component.MovieDetailsComponent;
import com.smart.plug.app.module.MovieDetailsModule;
import com.smart.plug.app.qualifier.ActivityScope;
import com.smart.plug.databinding.ActivityMovieDetailsBinding;
import com.smart.plug.module.base.BaseActivity;


/**
 * author: smart
 * time: 2016/8/24
 */

@ActivityScope
public class MovieDetailsActivity extends BaseActivity implements HasComponent<MovieDetailsComponent>{
    ActivityMovieDetailsBinding binding;

    private MovieDetailsComponent movieDetailsComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);
        initView();
        initializeActivity(savedInstanceState);

    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        movieDetailsComponent =  DaggerMovieDetailsComponent.builder()
                .appComponent(appComponent)
                .movieDetailsModule(new MovieDetailsModule(this))
                .build();
    }

    private void initView(){
        binding.toolbar.setTitle(getString(R.string.movie_details_title));
    }


    @Override
    protected void onFinish() {
        this.finish();
    }


    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.details_fragment, MovieDetailsFragment.newInstance(), MovieDetailsFragment.class.getSimpleName());
        } else {

        }
    }

    @Override
    public MovieDetailsComponent getComponent() {
        return movieDetailsComponent;
    }

}
