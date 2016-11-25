package com.example.administrator.myapplication.weibo;

import android.support.annotation.NonNull;

import com.example.administrator.myapplication.weibo.bean.Weibo;
import com.example.library.Item;
import com.example.library.MultiTypeAdapter;
import com.example.library.TypePool;

import java.util.List;


/**
 * Created by Administrator on 2016/11/24.
 */

public class WeiboAdapter extends MultiTypeAdapter {

    public WeiboAdapter(@NonNull List<? extends Item> items) {
        super(items);
    }

    public WeiboAdapter(@NonNull List<? extends Item> items, TypePool pool) {
        super(items, pool);
    }

    @NonNull
    @Override
    public Class onFlattenClass(@NonNull Item item) {
        return ((Weibo)item).content.getClass();
    }
}
