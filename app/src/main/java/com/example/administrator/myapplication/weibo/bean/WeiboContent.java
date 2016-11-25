package com.example.administrator.myapplication.weibo.bean;

import android.support.annotation.NonNull;

import com.example.library.Item;

/**
 * Created by Administrator on 2016/11/23.
 */

public class WeiboContent implements Item {


    @NonNull
    public final String contentType;

    protected WeiboContent(@NonNull String contentType) {
        this.contentType = contentType;
    }
}
