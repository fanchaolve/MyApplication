package com.example.administrator.myapplication.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.base.utils.AppManager;
import com.example.administrator.myapplication.base.utils.InstanceUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/11/24.
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {


    public  String TAG=BaseActivity.class.getSimpleName();

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
        AppManager.getInstance().addActivity(this);
        this.setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mContext = this;
        mPresenter = InstanceUtil.getInstance(this, 0);
        this.initView();
        if (this instanceof BaseView)
            mPresenter.setVM(this, InstanceUtil.getInstance(this, 1));


    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDetached();
        if (unbinder != null)
            unbinder.unbind();
        AppManager.getInstance().finishActivity();

    }

    /**
     * @param goActivity 跳转的页面
     * @param aBundle    带参数
     */
    public void showActivity(Class<? extends Activity> goActivity, Bundle aBundle) {
        //跳转页面
        Intent intent = new Intent();
        intent.setClassName(this, goActivity.getName());

        if (null != aBundle) {
            intent.putExtras(aBundle);
        }
        startActivity(intent);
    }

    /**
     * @param goActivity  跳转的页面
     * @param aBundle     带参数
     * @param requestCode
     */
    public void showActivityForResult(Class<? extends Activity> goActivity, Bundle aBundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClassName(this, goActivity.getName());
        if (null != aBundle) {
            intent.putExtras(aBundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 提示信息
     *
     * @param aFormatMsg
     * @param aMsgArgs
     */
    public void showTip(String aFormatMsg, Object... aMsgArgs) {
        String outString = String.format(aFormatMsg, aMsgArgs);
        int duration = (outString.length() > 10) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;
        Toast.makeText(mContext, outString, duration).show();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //// TODO: 2016/11/25  填写 你需要在底栈的页面
            return (AppManager.getInstance().processBackKey(MainActivity.class) ?
                    true : super.onKeyDown(keyCode, event));

        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
