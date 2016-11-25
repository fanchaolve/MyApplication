package com.example.administrator.myapplication;


import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2016/11/23.
 */

public class PostItemDecoration extends RecyclerView.ItemDecoration {


    private int space;
    private GridLayoutManager.SpanSizeLookup spanSizeLookup;


    public PostItemDecoration(int space, @NonNull GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.space=space;
        this.spanSizeLookup=spanSizeLookup;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int positon=parent.getChildAdapterPosition(view);
        if(spanSizeLookup.getSpanSize(positon)==1){
            outRect.left=space;
            if(positon %2==0){
                outRect.right=space;
            }
        }
    }
}
