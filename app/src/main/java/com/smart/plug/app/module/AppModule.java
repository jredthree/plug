package com.smart.plug.app.module;

import android.content.Context;

import com.smart.plug.app.App;
import com.smart.plug.app.Constant.Constant;
import com.smart.plug.domain.api.ApiInterface;
import com.smart.plug.domain.http.ApiService;
import com.smart.plug.domain.http.HttpMethods;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: smart
 * time: 2016/7/25
 * action:提供全局Appliation对象
 */
@Module
public class AppModule {

    private App app;

    @Inject
    public AppModule(App app){
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideApplication(){
        return this.app;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient.Builder builder){

        return  new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient.Builder provideBuilder(){
        return new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS);
    }

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    public ApiInterface provideHttpMethods(ApiService apiService){

        return new HttpMethods(apiService);
    }



}
