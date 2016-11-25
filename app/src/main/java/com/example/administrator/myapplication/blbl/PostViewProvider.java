package com.example.administrator.myapplication.blbl;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;
import com.example.library.ItemViewProvider;

/**
 * Created by Administrator on 2016/11/23.
 */

public class PostViewProvider  extends ItemViewProvider<Post,PostViewProvider.ViewHolder>{


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view=inflater.inflate(R.layout.item_post,parent,false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Post post) {
        holder.setData(post);
    }

    static class  ViewHolder extends RecyclerView.ViewHolder{

        private ImageView cover;
        private TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.cover);
            title = (TextView) itemView.findViewById(R.id.title);
        }

        void setData(final Post post){
            cover.setImageResource(post.coverResId);
            title.setText(post.title);
        }
    }
}
