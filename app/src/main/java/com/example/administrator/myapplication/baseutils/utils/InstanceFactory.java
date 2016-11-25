package com.example.administrator.myapplication.baseutils.utils;

/**
 * Created by Administrator on 2016/11/24.
 */

public class InstanceFactory {
    public static Object create(Class mClass) throws IllegalAccessException, InstantiationException {
        switch (mClass.getSimpleName()){
            case "1":
                return new Object();
            case "2":
                return new Object();
            default: return mClass.newInstance();

        }
    }
}
