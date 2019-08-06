package com.example.meetthebabyapp.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;


/**
 * =============================================================================
 * Copyright (c) 2018 Administrator All rights reserved.
 * Packname com.dace.textreader.util
 * Created by Administrator.
 * Created time 2018/12/18 0018 下午 2:58.
 * Version   1.0;
 * Describe :  Glide图片加载工具类
 * History:
 * ==============================================================================
 */
public class GlideUtils {

    /**
     * 加载矩形图片
     *
     * @param context   上下文对象
     * @param imageUrl  图片链接
     * @param imageView 图片容器
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void loadImage(Context context, String imageUrl, ImageView imageView) {
        if (!isValidContextForGlide(context)) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .transform(new RoundedCorners(DensityUtil.dip2px(context, 3)));
//        if (!Patterns.WEB_URL.matcher(imageUrl).matches() && !URLUtil.isValidUrl(imageUrl)) {
//            imageUrl = HttpUtil.IMAGE_PRE + imageUrl;
//        }
        Glide.with(context)
                .load(imageUrl)
                .apply(options)
                .into(imageView);
    }

    /**
     * 加载圆形图片
     *
     * @param context   上下文对象
     * @param imageUrl  图片链接
     * @param imageView 图片容器
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void loadCircleImage(Context context, String imageUrl, ImageView imageView) {
        if (!isValidContextForGlide(context)) {
            return;
        }
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .transform(new CircleCrop());
//        if (!Patterns.WEB_URL.matcher(imageUrl).matches() && !URLUtil.isValidUrl(imageUrl)) {
//            imageUrl = HttpUtil.IMAGE_PRE + imageUrl;
//        }
        Glide.with(context)
                .load(imageUrl)
                .apply(options)
                .into(imageView);
    }

    /**
     * 通过context加载drawable中的图片
     *
     * @param context   上下文对象
     * @param resId     图片ID
     * @param imageView 图片容器
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void loadImageWithNoOptions(Context context, @DrawableRes int resId,
                                              ImageView imageView) {
        if (isValidContextForGlide(context)) {
            return;
        }
        Glide.with(context).asBitmap().load(resId).into(imageView);
    }

    /**
     * 通过context加载drawable中的GIF图片
     *
     * @param context   上下文对象
     * @param resId     图片ID
     * @param imageView 图片容器
     */
    public static void loadGIFImageWithNoOptions(Context context, @DrawableRes int resId,
                                                 ImageView imageView) {
        if (!isValidContextForGlide(context)) {
            return;
        }

        Glide.with(context).asGif().load(resId).into(imageView);
    }

    /**
     * 加载矩形图片
     *
     * @param context   上下文对象
     * @param imageUrl  图片链接
     * @param imageView 图片容器
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void loadImageWithNoRadius(Context context, String imageUrl, ImageView imageView) {
        if (!isValidContextForGlide(context)) {
            return;
        }

        DrawableCrossFadeFactory drawableCrossFadeFactory =
                new DrawableCrossFadeFactory.Builder(500)
                        .setCrossFadeEnabled(true).build();
        RequestOptions options = new RequestOptions()
                .centerCrop();
        Glide.with(context)
                .load(imageUrl)
                .apply(options)
                .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                .into(imageView);
    }

    /**
     * context是否有效
     *
     * @param context
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private static boolean isValidContextForGlide(final Context context) {
        if (context == null) {
            return false;
        }
        if (context instanceof Activity) {
            final Activity activity = (Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取图片链接
     *
     * @param imageUrl
     * @return
     */
    public static String getImageUrl(String imageUrl) {
//        if (!Patterns.WEB_URL.matcher(imageUrl).matches() && !URLUtil.isValidUrl(imageUrl)) {
//            imageUrl = HttpUtil.IMAGE_PRE + imageUrl;
//        }
        return imageUrl;
    }

}
