package com.example.administrator.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.base.BaseActivity;
import com.example.administrator.myapplication.base.BaseView;
import com.example.administrator.myapplication.bean.MessageDetail;
import com.example.administrator.myapplication.bean.MessageEvent;
import com.example.administrator.myapplication.bean.Messagelist;

import butterknife.BindView;
import butterknife.BindViews;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

    //....................1111111
public class MainActivity extends BaseActivity {



    @BindView(R.id.tv_message)
    TextView tv_message;

    @BindView(R.id.bt_startact)
    Button bt_startact;


    private StringBuilder  str_Mess=new StringBuilder();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        bt_startact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.super.showActivity(Main2Activity.class,null);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        super.onCreate(savedInstanceState);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onShowMainThreadEvent(MessageEvent showMessageEvent) {
        Log.i(TAG,"onShowMainThreadEvent");
        if(showMessageEvent instanceof MessageDetail){
            str_Mess.append(((MessageDetail)showMessageEvent).getMessage()+"\n");
            tv_message.setText(str_Mess.toString());
        }else {
            showTip("类型转换不对1。。。。");
        }
    }

    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onShowPostThreadEvent(MessageEvent showMessageEvent) {
        Log.i(TAG,"onShowBackgroundThreadThreadEvent");
        if(showMessageEvent instanceof Messagelist){

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //EventBus.getDefault().post(new MessageDetail(showMessageEvent.getMessage()));
        }else {
            //showTip("类型转换不对2。。。。");
        }
    }


}
