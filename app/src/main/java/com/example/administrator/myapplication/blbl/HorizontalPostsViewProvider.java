package com.example.administrator.myapplication.blbl;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;
import com.example.library.ItemViewProvider;

import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public class HorizontalPostsViewProvider extends ItemViewProvider<PostList,HorizontalPostsViewProvider.ViewHolder>{


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view=inflater.inflate(R.layout.item_horizontal_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PostList postList) {
        holder.setPosts(postList.posts);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private RecyclerView recyclerView;
        private PostsAdapter adapter;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.post_list);

            LinearLayoutManager layoutManager=new LinearLayoutManager(itemView.getContext());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(layoutManager);
            adapter=new PostsAdapter();
           recyclerView.setAdapter(adapter);

        }

        private void setPosts(List<Post> posts) {
            adapter.setPosts(posts);
            adapter.notifyDataSetChanged();
        }
    }
}
