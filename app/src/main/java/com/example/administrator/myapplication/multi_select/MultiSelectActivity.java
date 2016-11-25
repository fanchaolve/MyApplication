package com.example.administrator.myapplication.multi_select;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.myapplication.Category;
import com.example.administrator.myapplication.MenuBaseActivity;
import com.example.administrator.myapplication.R;
import com.example.library.Items;
import com.example.library.MultiTypeAdapter;

import java.util.TreeSet;



/**
 * Created by Administrator on 2016/11/23.
 */

public class MultiSelectActivity extends MenuBaseActivity {

    private final static int SPAN_COUNT = 5;

    Items items = new Items();

    MultiTypeAdapter adapter;

    private TreeSet<Integer> selectedSet;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_select);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, SPAN_COUNT);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (items.get(position) instanceof Category) ? SPAN_COUNT : 1;

            }
        });

        loadData();

        recyclerView.setLayoutManager(gridLayoutManager);
        adapter=new MultiTypeAdapter(items);
        adapter.applyGlobalMultiTypePool();
        selectedSet = new TreeSet<>();
        adapter.register(Square.class,new SquareViewProvider(selectedSet));
        recyclerView.setAdapter(adapter);



    }

    private void loadData() {
        Category spacialCategory = new Category("特别篇");
        items.add(spacialCategory);
        for (int i = 0; i < 7; i++) {
            items.add(new Square(i + 1));
        }
        Category currentCategory = new Category("本篇");
        items.add(currentCategory);
        for (int i = 0; i < 1000; i++) {
            items.add(new Square(i + 1));
        }
    }
}
