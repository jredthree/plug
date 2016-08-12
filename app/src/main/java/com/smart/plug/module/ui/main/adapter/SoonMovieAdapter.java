package com.smart.plug.module.ui.main.adapter;

import com.red.databindingadapterhelp.adapter.RecyclerBaseAdapter;
import com.red.databindingadapterhelp.adapter.RecyclerViewHolder;
import com.smart.plug.BR;
import com.smart.plug.R;
import com.smart.plug.domain.entity.SoonBean;

import java.util.List;

/**
 * author: smart
 * time: 2016/8/12
 */
public class SoonMovieAdapter extends RecyclerBaseAdapter<SoonBean.SubjectsBean> {

    public SoonMovieAdapter(List<SoonBean.SubjectsBean> mData) {
        super(mData);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.soonmovie_item;
    }

    @Override
    public int getVariableId() {
        return BR.soon;
    }

    @Override
    public void bindCustomData(RecyclerViewHolder holder, int position, SoonBean.SubjectsBean item) {

    }

    @Override
    public int getStartMode() {
        return 0;
    }
}
