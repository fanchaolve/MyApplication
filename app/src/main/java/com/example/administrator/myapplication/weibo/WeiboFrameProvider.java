package com.example.administrator.myapplication.weibo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.weibo.bean.Weibo;
import com.example.administrator.myapplication.weibo.bean.WeiboContent;
import com.example.library.ItemViewProvider;

/**
 * Created by Administrator on 2016/11/23.
 */

public abstract class WeiboFrameProvider<Content1 extends WeiboContent, Content2 extends ContentHolder> extends ItemViewProvider<Weibo, WeiboFrameProvider.FrameHolder> {


    public abstract ContentHolder onCreateContentViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent);


    public abstract void onBindContentViewHolder(@NonNull Content2 holder, @NonNull Content1 content);


    @NonNull
    @Override
    protected FrameHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_weibo_frame, parent, false);
        return new FrameHolder(view, onCreateContentViewHolder(inflater, parent));
    }


    @Override
    protected void onBindViewHolder(@NonNull FrameHolder holder, @NonNull Weibo weibo) {
        holder.avatar.setImageResource(weibo.user.avatar);
        holder.username.setText(weibo.user.name);
        holder.createTime.setText(weibo.createTime);
        final WeiboContent content = weibo.content;
        onBindContentViewHolder((Content2) holder.subViewHolder, (Content1) content);
    }

    static class FrameHolder extends RecyclerView.ViewHolder {

        private ImageView avatar;
        private TextView username;
        private FrameLayout container;
        private TextView createTime;
        private ContentHolder subViewHolder;

        public FrameHolder(View itemView, ContentHolder holder) {
            super(itemView);

            avatar = (ImageView) itemView.findViewById(R.id.avatar);
            username = (TextView) itemView.findViewById(R.id.username);
            container = (FrameLayout) itemView.findViewById(R.id.container);
            createTime = (TextView) itemView.findViewById(R.id.create_time);
            container.addView(holder.itemView);
            subViewHolder = holder;

        }
    }
}
