package com.smart.plug.module.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart.plug.R;
import com.smart.plug.app.component.MainComponent;
import com.smart.plug.databinding.FragmentMainBinding;
import com.smart.plug.module.base.BaseFragment;

import javax.inject.Inject;

/**
 * author: smart
 * time: 2016/8/9
 */
public class MainFragment extends BaseFragment implements MainInterface.View  {

    @Inject
    MainInterface.Presenter presenter;

    FragmentMainBinding binding ;

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
        binding.text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.freshenData();
            }
        });
    }

    @Override
    public void navigateToLogin() {
        Log.d("TAG","dddaaaa");
    }
}
