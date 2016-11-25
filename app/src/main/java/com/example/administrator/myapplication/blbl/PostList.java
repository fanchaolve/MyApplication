package com.example.administrator.myapplication.blbl;

import android.support.annotation.NonNull;

import com.example.library.Item;

import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public class PostList implements Item{

    final List<Post> posts;


    public PostList(@NonNull List<Post> posts) {this.posts = posts;}

}
