package com.example.administrator.myapplication.weibo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.weibo.bean.SimpleText;
import com.example.administrator.myapplication.weibo.bean.WeiboContent;
import com.example.library.Item;

/**
 * Created by Administrator on 2016/11/24.
 */

public class SimpleTextViewProvider extends WeiboFrameProvider<SimpleText,SimpleTextViewProvider.ViewHolder> {


    @Override
    public ViewHolder onCreateContentViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view=inflater.inflate(R.layout.item_weibo_simple_text,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindContentViewHolder(@NonNull ViewHolder holder, @NonNull SimpleText content) {
        holder.simpleText.setText(content.text);
    }


    class ViewHolder extends ContentHolder{

        private TextView simpleText;


        public ViewHolder(View itemView) {
            super(itemView);
            simpleText = (TextView) itemView.findViewById(R.id.simple_text);

        }
    }
}
