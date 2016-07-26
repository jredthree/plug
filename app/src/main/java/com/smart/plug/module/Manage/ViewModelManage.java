package com.smart.plug.module.Manage;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;


/**
 * author: smart
 * time: 2016/7/25
 */
public abstract class ViewModelManage<VM extends ViewModel, B extends ViewDataBinding> {

    private VM viewModel;
    private B binding;

    public VM getViewModel() {
        if (viewModel == null) {
            throw new NullPointerException("You should setViewModel first!");
        }
        return viewModel;
    }

    public void setViewModel(@NonNull VM viewModel) {
        this.viewModel = viewModel;
    }

    public B getBinding() {
        if (binding == null) {
            throw new NullPointerException("You should setBinding first!");
        }
        return binding;
    }

    public void setBinding(@NonNull B binding) {
        this.binding = binding;
    }
}
