package com.smart.plug.utils;

import android.util.Log;

import com.smart.plug.domain.entity.SoonBean;

import java.util.List;

/**
 * author: smart
 * time: 2016/10/9
 */

public class StringUtils {
    public static String movieNameTitle(List<SoonBean.SubjectsBean.CastsBean> casts) {
        StringBuilder s = new StringBuilder();
        for(SoonBean.SubjectsBean.CastsBean castsBean : casts){
            s.append(castsBean.getName());
            s.append("  ");
        }
        return "主演：" + s.toString();
    }

    public static String movieTimeTitle(final String time) {

        return "上映时间：" + time.toString();
    }

    public static String movieAverage(final double average) {
        Log.i("TAG",average+"-----");

        return "豆瓣评分：" + String.valueOf(average);
    }
}
