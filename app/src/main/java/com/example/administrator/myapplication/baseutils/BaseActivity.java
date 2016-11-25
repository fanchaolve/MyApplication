package com.example.administrator.myapplication.baseutils;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.baseutils.utils.InstanceUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/11/24.
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {


    public P mPresenter;
    public Context mContext;
    private Unbinder unbinder;

    public abstract int getLayoutId();


    public abstract void initView();


    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(getLayoutId());
        unbinder=ButterKnife.bind(this);
        mContext=this;
        mPresenter = InstanceUtil.getInstance(this, 0);
        this.initView();
        if(this instanceof BaseView)
        mPresenter.setVM(this, InstanceUtil.getInstance(this,1));


    }

    @Override
    protected void onResume() {
        super.onResume();
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null)
            mPresenter.onDetached();
        if(unbinder!=null)
            unbinder.unbind();

    }
}
