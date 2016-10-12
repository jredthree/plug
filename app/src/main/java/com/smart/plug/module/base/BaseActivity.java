package com.smart.plug.module.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.smart.plug.app.App;
import com.smart.plug.app.component.AppComponent;

/**
 * author: smart
 * time: 2016/7/25
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(getAppComponent());
    }

    /**
     * 监听返回键
     * @param isShow
     * @param back
     */
    protected void showBackIcon(boolean isShow, ImageView back){
        back.setVisibility(isShow ? View.VISIBLE : View.GONE);
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onFinish();
            }
        });
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

    protected abstract void setupComponent(AppComponent appComponent);

    protected AppComponent getAppComponent(){
        return (AppComponent) App.get(this).component();
    }

    /**
     * 返回键监听事件
     */
    protected abstract void onFinish();

    protected void addFragment(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment, tag);
        fragmentTransaction.commit();
    }

    public <T extends Fragment> T getFragment(String tag) {
        return (T) getFragmentManager().findFragmentByTag(tag);
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
