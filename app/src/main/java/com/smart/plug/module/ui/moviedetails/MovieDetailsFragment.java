package com.smart.plug.module.ui.moviedetails;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.red.databindingadapterhelp.adapter.RecyclerBaseAdapter;
import com.smart.plug.R;
import com.smart.plug.app.component.MovieDetailsComponent;
import com.smart.plug.databinding.FragmentMovieDetailsBinding;
import com.smart.plug.domain.entity.MovieBean;
import com.smart.plug.module.base.BaseFragment;
import com.smart.plug.module.ui.moviedetails.adapter.ActorIntroduceAdapter;
import com.smart.plug.module.ui.moviedetails.event.PassingValueImageEvent;
import com.smart.plug.utils.RxBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * author: smart
 * time: 2016/8/24
 */
public class MovieDetailsFragment extends BaseFragment implements MovieDetailsInterface.View {

    @Inject
    MovieDetailsInterface.Presenter presenter;

    private FragmentMovieDetailsBinding binding ;

    private String mMovieId;

    private RecyclerView mRecyclerView;

    private ActorIntroduceAdapter mAdapter;

    private MovieBean mMovieBean;

    private List<MovieBean.CastsBean> mList;

    public MovieDetailsFragment() {
        super();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mMovieId = ((MovieDetailsActivity) activity).getMoviewId();
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

        presenter.setView(this);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.freshenData();
    }

    private void init(){
        mList = new ArrayList<>();
        mRecyclerView = binding.actorRecyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        mAdapter = new ActorIntroduceAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public String getMovieId() {
        return mMovieId;
    }

    @Override
    public void displayView(MovieBean movieBean) {
        mList.clear();
        mList.addAll(movieBean.getCasts());
        mAdapter.notifyDataSetChanged();
        binding.setMovieDetails(movieBean);
        RxBus.getInstance().post(new PassingValueImageEvent(movieBean.getImages().getLarge()));
    }
}
