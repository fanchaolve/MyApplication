package com.example.administrator.myapplication.weibo.bean;

import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2016/11/24.
 */

public class SimpleText extends WeiboContent {

    public static final String TYPE = "simple_text";
    public String text;

    public SimpleText(@NonNull String text) {
        super(TYPE);
        this.text=text;

    }
}
