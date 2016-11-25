package com.example.administrator.myapplication.weibo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.myapplication.MenuBaseActivity;
import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.weibo.bean.SimpleImage;
import com.example.administrator.myapplication.weibo.bean.SimpleText;
import com.example.administrator.myapplication.weibo.bean.User;
import com.example.administrator.myapplication.weibo.bean.Weibo;
import com.example.library.Items;


/**
 * Created by Administrator on 2016/11/23.
 */

public class WeiboActivity extends MenuBaseActivity {


    private Items items;
    private WeiboAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        items=new Items();
        adapter = new WeiboAdapter(items);
        adapter.register(SimpleText.class,new SimpleTextViewProvider());
        adapter.register(SimpleImage.class,new SimpleImageViewProvider());

        User user = new User("drakeet", R.mipmap.avatar);
//        SimpleText simpleText = new SimpleText("A simple text Weibo: Hello World.");
//        SimpleImage simpleImage = new SimpleImage(R.drawable.img_10);

        SimpleText simpleText=new SimpleText("A simple text Weibo: Hello World.");
        SimpleImage simpleImage=new SimpleImage(R.drawable.img_10);
        for (int i = 0; i < 20; i++) {
            items.add(new Weibo(user, simpleText));
            items.add(new Weibo(user, simpleImage));
        }
        recyclerView.setAdapter(adapter);

    }
}
