package com.example.administrator.myapplication.weibo.bean;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2016/11/23.
 */

public class User {

    @NonNull
    public String name;
    @DrawableRes
    public int avatar;


    public User(@NonNull String name, int avatar) {
        this.name = name;
        this.avatar = avatar;
    }

}
