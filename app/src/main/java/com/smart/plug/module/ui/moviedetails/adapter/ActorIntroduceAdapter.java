package com.smart.plug.module.ui.moviedetails.adapter;

import com.red.databindingadapterhelp.BR;
import com.red.databindingadapterhelp.adapter.RecyclerBaseAdapter;
import com.red.databindingadapterhelp.adapter.RecyclerViewHolder;
import com.smart.plug.R;
import com.smart.plug.domain.entity.MovieBean;

import java.util.List;

/**
 * author: smart
 * time: 2016/10/12
 */

public class ActorIntroduceAdapter extends RecyclerBaseAdapter<MovieBean.CastsBean> {

    public ActorIntroduceAdapter(List<MovieBean.CastsBean> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.actor_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.actor;
    }

    @Override
    public int getItemTypePosition(int position) {
        return 0;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, MovieBean.CastsBean item) {

    }

    @Override
    public int getStartMode() {
        return 0;
    }
}
