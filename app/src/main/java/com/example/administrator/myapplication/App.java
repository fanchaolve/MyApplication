package com.example.administrator.myapplication;

import android.app.Application;

import com.example.administrator.myapplication.base.utils.AppManager;

/**
 * Created by Administrator on 2016/11/23.
 */

public class App extends Application{


    private static App INSTANCE=null;



    //-------

    public static App getInstance() {
        return INSTANCE;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        AppManager.getInstance();
        MultiTypeInstaller.start();
    }
}
