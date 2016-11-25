package com.example.administrator.myapplication;

import com.example.library.GlobalMultiTypePool;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MultiTypeInstaller {

    static void  start(){
        GlobalMultiTypePool.register(Category.class,new CategoryItemViewProvider());
    }
}
