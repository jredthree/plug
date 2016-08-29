package com.smart.plug.module.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.smart.plug.R;
import com.smart.plug.app.component.AppComponent;
import com.smart.plug.app.component.DaggerMainComponent;
import com.smart.plug.app.component.HasComponent;
import com.smart.plug.app.component.MainComponent;
import com.smart.plug.app.module.MainModule;
import com.smart.plug.databinding.ActivityMainBinding;
import com.smart.plug.module.base.BaseActivity;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent>{

    ActivityMainBinding binding;

    private MainComponent mainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initializeActivity(savedInstanceState);
        initView();
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        mainComponent =  DaggerMainComponent.builder()
                .appComponent(getAppComponent())
                .mainModule(new MainModule(this))
                .build();

    }

    private void initView(){
        binding.toolbar.setTitle(getString(R.string.main_title));
    }


    @Override
    protected void onFinish() {
       this.finish();
    }


    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fl_fragment, MainFragment.newInstance(), MainFragment.class.getSimpleName());
        } else {

        }
    }

    @Override
    public MainComponent getComponent() {
        return mainComponent;
    }
}
