package com.example.administrator.myapplication.weibo.bean;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2016/11/24.
 */

public class SimpleImage extends WeiboContent {

    public static final String TYPE = "simple_image";
    @DrawableRes
    public int resId;

    public SimpleImage(@DrawableRes int resId) {
        super(TYPE);
        this.resId=resId;
    }
}
