package com.smart.plug.module.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.smart.plug.R;
import com.smart.plug.app.component.AppComponent;
import com.smart.plug.app.component.DaggerMainComponent;
import com.smart.plug.app.module.MainModule;
import com.smart.plug.databinding.ActivityMainBinding;
import com.smart.plug.module.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainInterface.View{

    @Inject
    MainInterface.Presenter presenter;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupComponent();
        binding.test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.freshenData();
            }
        });

    }

    private void setupComponent() {
        DaggerMainComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onFinish() {
        presenter.destory();
    }

    @Override
    public void navigateToLogin() {

    }


}
