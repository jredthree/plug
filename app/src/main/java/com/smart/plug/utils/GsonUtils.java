package com.smart.plug.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * author: smart
 * time: 2016/5/30
 */
public class GsonUtils {

    private static Gson mGson = new GsonBuilder()
            .create();

    /**
     * 生产jsonString
     * */
    public static String toJson(Object object) {
        return mGson.toJson(object);
    }


    /**
     *
     * jsonString 转 任意类型
     * */
    public  static  <T> T fromJson(String jsonString, Class<T> clazz) {
        return  mGson.fromJson(jsonString,clazz);
    }

}
