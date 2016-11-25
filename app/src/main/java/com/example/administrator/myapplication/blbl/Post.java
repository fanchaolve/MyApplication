package com.example.administrator.myapplication.blbl;

import android.support.annotation.NonNull;

import com.example.library.Item;

/**
 * Created by Administrator on 2016/11/23.
 */

public class Post implements Item{

    public int coverResId;
    public String title;


    public Post(int coverResId, @NonNull final String title) {
        this.coverResId = coverResId;
        this.title = title;
    }
}
