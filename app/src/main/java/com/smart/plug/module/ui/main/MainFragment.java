package com.smart.plug.module.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.red.databindingadapterhelp.adapter.RecyclerBaseAdapter;
import com.smart.plug.R;
import com.smart.plug.app.component.MainComponent;
import com.smart.plug.databinding.FragmentMainBinding;
import com.smart.plug.domain.entity.SoonBean;
import com.smart.plug.module.base.BaseFragment;
import com.smart.plug.module.ui.main.adapter.SoonMovieAdapter;
import com.smart.plug.widget.AutoLoadRecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * author: smart
 * time: 2016/8/9
 */
public class MainFragment extends BaseFragment implements MainInterface.View  {

    @Inject
    MainInterface.Presenter presenter;

    private FragmentMainBinding binding ;

    private AutoLoadRecyclerView mAutoLoadRecyclerView;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private SoonMovieAdapter mAdapter;

    private List<SoonBean.SubjectsBean> mList;

    private SwipeRefreshLayout.OnRefreshListener onRefreshListener;

    public MainFragment() {
        super();

    }

    public static MainFragment newInstance() {
        MainFragment userDetailsFragment = new MainFragment();
        return userDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(MainComponent.class).inject(this);
        presenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding  = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        presenter.setView(this);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        onRefreshListener.onRefresh();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        }, 0);

    }

    @Override
    public void onDestroy() {
        presenter.destory();
        super.onDestroy();

    }

    private void init(){
        mAutoLoadRecyclerView = binding.includers.recyclerView;
        mSwipeRefreshLayout = binding.includers.swipeRefreshLayout;
        mAutoLoadRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mList = new ArrayList<>();
        mAdapter = new SoonMovieAdapter(mList);
        mAutoLoadRecyclerView.setAdapter(mAdapter);

        mAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                presenter.recyclerOnClick(position,mAdapter.getItemObject(position));
            }
        });

        onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.initCount();
                presenter.freshenData();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        };

        mSwipeRefreshLayout.setOnRefreshListener(onRefreshListener);
    }

    @Override
    public void displayRecyclerView(List<SoonBean.SubjectsBean> list) {
        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }
}
