package com.example.administrator.myapplication.weibo;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.weibo.bean.SimpleImage;

/**
 * Created by Administrator on 2016/11/24.
 */

public class SimpleImageViewProvider extends WeiboFrameProvider<SimpleImage,SimpleImageViewProvider.ViewHolder> {




    @Override
    public ContentHolder onCreateContentViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {

        View view=inflater.inflate(R.layout.item_weibo_simple_image,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindContentViewHolder(@NonNull ViewHolder holder, @NonNull SimpleImage content) {
        holder.simpleImage.setImageResource(content.resId);

    }

    class ViewHolder extends ContentHolder{

        private ImageView simpleImage;


        public ViewHolder(View itemView) {
            super(itemView);
            simpleImage = (ImageView) itemView.findViewById(R.id.simple_image);

        }
    }
}
