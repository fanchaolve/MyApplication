package com.example.administrator.myapplication;

import android.app.Application;

/**
 * Created by Administrator on 2016/11/23.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        MultiTypeInstaller.start();
    }
}
