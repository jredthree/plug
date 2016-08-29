package com.smart.plug.module.ui.moviedetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart.plug.R;
import com.smart.plug.app.component.MovieDetailsComponent;
import com.smart.plug.databinding.FragmentMovieDetailsBinding;
import com.smart.plug.module.base.BaseFragment;

/**
 * author: smart
 * time: 2016/8/24
 */
public class MovieDetailsFragment extends BaseFragment implements MovieDetailsInterface.View {


    private FragmentMovieDetailsBinding binding ;

    public MovieDetailsFragment() {
        super();

    }

    public static MovieDetailsFragment newInstance() {
        MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();
        return movieDetailsFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(MovieDetailsComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding  = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
