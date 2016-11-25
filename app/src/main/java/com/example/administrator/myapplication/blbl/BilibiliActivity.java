package com.example.administrator.myapplication.blbl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.myapplication.Category;
import com.example.administrator.myapplication.MenuBaseActivity;
import com.example.administrator.myapplication.PostItemDecoration;
import com.example.administrator.myapplication.R;
import com.example.library.Item;
import com.example.library.MultiTypeAdapter;
import com.example.library.MultiTypePool;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Administrator on 2016/11/23.
 */

public class BilibiliActivity extends MenuBaseActivity {

    private static final int SPAN_COUNT = 2;


    private List<Item> items;

    private MultiTypeAdapter adapter;

    private static class JsonData {
        private final String PREFIX = "这是一条长长的达到两行的标题文字";

        private Post post00 = new Post(R.drawable.img_00, PREFIX + "post00");
        private Post post01 = new Post(R.drawable.img_01, PREFIX + "post01");
        private Post post10 = new Post(R.drawable.img_10, PREFIX + "post10");
        private Post post11 = new Post(R.drawable.img_11, PREFIX + "post11");
        private Post post12 = new Post(R.drawable.img_11, PREFIX + "post12");

        Category category0 = new Category("title0");
        Post[] postArray = {post00, post01, post10, post11};

        List<Post> postList = new ArrayList<>();


        {
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        JsonData data = new JsonData();
        items = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            items.add(data.category0);
            items.add(data.postArray[0]);
            items.add(data.postArray[1]);
            items.add(data.postArray[2]);
            items.add(data.postArray[3]);
            items.add(new PostList(data.postList));
        }

        adapter = new MultiTypeAdapter(items);
        adapter.applyGlobalMultiTypePool();

        adapter.register(Post.class, new PostViewProvider());
        adapter.register(PostList.class, new HorizontalPostsViewProvider());


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Item item = items.get(position);
                return (item instanceof Category || item instanceof PostList) ? SPAN_COUNT : 1;
            }
        };
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(layoutManager);
        int space = getResources().getDimensionPixelSize(R.dimen.normal_space);
        recyclerView.addItemDecoration(new PostItemDecoration(space,spanSizeLookup));
        recyclerView.setAdapter(adapter);



    }
}
