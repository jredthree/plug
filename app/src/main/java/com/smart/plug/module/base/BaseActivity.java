package com.smart.plug.module.base;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.smart.plug.app.App;
import com.smart.plug.app.component.AppComponent;
import com.smart.plug.app.module.ActivityModule;

/**
 * author: smart
 * time: 2016/7/25
 */
public abstract class BaseActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setupComponent((AppComponent) App.get(this).component());
        getAppComponent().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

   /* protected void setupComponent(AppComponent appComponent){
        appComponent.inject(this);
    }*/

    protected AppComponent getAppComponent(){
        return (AppComponent) App.get(this).component();
    }

    protected abstract void onFinish();

    protected void addFragment(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment, tag);
        fragmentTransaction.commit();
    }

    public <T extends Fragment> T getFragment(String tag) {
        return (T) getFragmentManager().findFragmentByTag(tag);
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
    /**
     * 监听Back键按下事件
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            onFinish();
            return true;
        }else {
            return super.onKeyDown(keyCode, event);
        }

    }
}
