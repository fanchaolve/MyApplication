package com.example.administrator.myapplication;

import android.support.annotation.NonNull;

import com.example.library.Item;

/**
 * Created by Administrator on 2016/11/23.
 */

public class Category implements Item{

    public String title;


    public Category(@NonNull final String title) {
        this.title = title;
    }

}
