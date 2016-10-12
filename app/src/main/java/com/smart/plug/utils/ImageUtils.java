package com.smart.plug.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * author: smart
 * time: 2016/8/15
 */
public class ImageUtils {

    /**
     * 加载图片方法
     * @param view
     * @param url
     */
    @BindingAdapter({"bind:imageUrl","bind:error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Glide.with(view.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(error)
                .into(view);

    }

}
