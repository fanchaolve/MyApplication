package com.example.administrator.myapplication.base;

/**
 * Created by Administrator on 2016/11/24.
 */

public abstract class BasePresenter <V,M>{

    public M mModel;

    public V mView;

    public void setVM(V v, M m) {
        this.mView=v;
        this.mModel=m;
        this.onAttached();
    }

    public abstract void onAttached();

    public void onDetached() {

    }

}
