package com.smart.plug.module.ui.search;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.red.databindingadapterhelp.adapter.RecyclerBaseAdapter;
import com.smart.plug.R;
import com.smart.plug.app.component.SearchComponent;
import com.smart.plug.databinding.FragmentSearchBinding;
import com.smart.plug.domain.entity.SoonBean;
import com.smart.plug.module.base.BaseFragment;
import com.smart.plug.module.ui.main.adapter.SoonMovieAdapter;
import com.smart.plug.widget.AutoLoadRecyclerView;
import com.smart.plug.widget.LoadFinishCallBack;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 作者：洪三
 * 时间： 2016/10/22.
 * 邮箱：redthree3333@gmail.com
 */

public class SearchFragment extends BaseFragment implements SearchInterface.View {
    @Inject
    SearchInterface.Presenter presenter;

    private FragmentSearchBinding binding ;

    private AutoLoadRecyclerView mAutoLoadRecyclerView;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private SoonMovieAdapter mAdapter;

    private List<SoonBean.SubjectsBean> mList;

    private LoadFinishCallBack mLoadFinisCallBack;

    public SearchFragment() {
        super();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    public static SearchFragment newInstance() {
        SearchFragment searchFragment = new SearchFragment();
        return searchFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(SearchComponent.class).inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding  = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        presenter.setView(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init(){

        ((SearchActivity) getActivity()).showBackIcon(true,binding.backIcon);
        binding.filterEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId,KeyEvent event)  {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || (event != null
                        && KeyEvent.KEYCODE_ENTER == event.getKeyCode()
                        && KeyEvent.ACTION_DOWN == event.getAction())) {
                    presenter.initCount();
                    return true;
                }
                return false;
            }
        });


        mAutoLoadRecyclerView = binding.includers.recyclerView;
        mSwipeRefreshLayout = binding.includers.swipeRefreshLayout;
        mAutoLoadRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mList = new ArrayList<>();
        mAdapter = new SoonMovieAdapter(mList);
        mAutoLoadRecyclerView.setAdapter(mAdapter);
        mAutoLoadRecyclerView.setOnPauseListenerParams(Glide.get(getActivity()), true, true);
        mLoadFinisCallBack = mAutoLoadRecyclerView;
        //自动加载更多
        mAutoLoadRecyclerView.setLoadMoreListener(new AutoLoadRecyclerView.onLoadMoreListener() {
            @Override
            public void loadMore() {
                presenter.loadMore();
            }
        });

        mAdapter.setMyItemClickListener(new RecyclerBaseAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                presenter.recyclerOnClick(position,mAdapter.getItemObject(position));
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.initCount();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
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
    public void displayLoadMore(List<SoonBean.SubjectsBean> list) {
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void displayRefresh(List<SoonBean.SubjectsBean> list) {
        mList.clear();
        mList.addAll(list);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void isLoad() {
        mLoadFinisCallBack.loadFinish(null);
    }

    @Override
    public String getQ() {
        return binding.filterEdit.getText().toString();
    }

    @Override
    public String getMovieTag() {
        return "";
    }
}
