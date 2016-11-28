package com.example.administrator.myapplication;

import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.base.BaseActivity;
import com.example.administrator.myapplication.bean.MessageDetail;
import com.example.administrator.myapplication.bean.Messagelist;

import de.greenrobot.event.EventBus;

public class Main2Activity extends BaseActivity {


    //////////////////////////////
    //.,sdfhjaisufhsaf
    //!!!!!!!!!!!!!!!!!!!!
//    @BindView(R.id.bt_send)
    Button bt_send;
    Button bt_send2;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void initView() {

        bt_send= (Button) findViewById(R.id.bt_send);
        bt_send2= (Button) findViewById(R.id.bt_send2);

        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageDetail("从Main2Activity发来的消息。。。。1"));
                EventBus.getDefault().post(new MessageDetail("从Main2Activity发来的消息。。。。2"));
                EventBus.getDefault().post(new MessageDetail("从Main2Activity发来的消息。。。。3"));
                EventBus.getDefault().post(new MessageDetail("从Main2Activity发来的消息。。。。4"));
            }
        });

        bt_send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EventBus.getDefault().post(new Messagelist("从Main2Activity发来的异步消息" ));
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                finish();
//                            }
//                        });

                    }
                }).start();
            }
        });
    }


}
