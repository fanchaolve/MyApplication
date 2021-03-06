package com.example.administrator.myapplication.base.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;

import com.example.administrator.myapplication.App;

import java.util.Stack;

/**
 * Created by Administrator on 2016/11/25.
 */

public class AppManager {

    private static Stack<Activity> activityStack;

    private static AppManager instance;

    private AppManager() {
    }

    /**
     * 单一实例
     */

    public static AppManager getInstance(){
        if(instance==null){
            instance=new AppManager();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);

    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity(){
        Activity activity=activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity=currentActivity();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if(activity!=null){
            //activity.finish();
            activityStack.remove(activity);
            activity=null;
        }
    }


    /**
     * 结束指定类名的Activity
     */

    public void finishActivity(Class<?>tClass){

        for(Activity activity : activityStack){
            if(activity.getClass().equals(tClass)){
                finishActivity(activity);
            }
        }

    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }


    public boolean processBackKey(Class<? extends Activity> ... classes) {
        for(Class<? extends Activity> clazz : classes) {
            if (currentActivity().getClass().getSimpleName().equals(clazz.getSimpleName())){
                //进入最底层的页面 需要做具体操作来结束app页面，入弹出dialog
                // TODO: 2016/11/25
                return true;
            }
        }
        return false;
    }


    public void AppExit(Context context) {
        finishAllActivity();
//        ActivityManager activityManager=context.getSystemService(Context.ACTIVITY_SERVICE);
//        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }


}
