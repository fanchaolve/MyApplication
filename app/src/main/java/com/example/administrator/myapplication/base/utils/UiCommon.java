package com.example.administrator.myapplication.base.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public enum  UiCommon {
    INSTANCE;

    public static final int ACTIVITY_IDX_ROOT = 0; // 初始化页面
    public static final int ACTIVITY_IDX_HOME = 1; // 首页
    public static final int ACTIVITY_IDX_LOGIN = 2; // 登录



    private List<String> iActiNameList = new ArrayList<String>(); // Activity名称集合
    public List<Activity> iAllActi; // Activity集合
    private int iCurrActiIdx; // 当前Activity Index


    private UiCommon() {
//        iActiNameList.add(ACTIVITY_IDX_ROOT, RootActivity.class.getName());
//        iActiNameList.add(ACTIVITY_IDX_HOME, HomeActivity.class.getName());
//        iActiNameList.add(ACTIVITY_IDX_LOGIN, LoginActivity.class.getName());

        // 初始化整个Activity队列
        iAllActi = new ArrayList<Activity>(iActiNameList.size());
        for (int i = 0, len = iActiNameList.size(); i < len; i++) {
            iAllActi.add(i, null);
        }

    }




}
