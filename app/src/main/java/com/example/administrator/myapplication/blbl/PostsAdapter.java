package com.example.administrator.myapplication.blbl;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {


    private List<Post> posts;

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostsAdapter.ViewHolder holder, int position) {
        Post post= posts.get(position);
        holder.cover.setImageResource(post.coverResId);
        holder.title.setText(post.title);
    }

    @Override
    public int getItemCount() {
        return posts != null ? posts.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        ImageView cover;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.cover);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
