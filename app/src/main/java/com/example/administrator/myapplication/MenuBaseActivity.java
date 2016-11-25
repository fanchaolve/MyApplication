package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.myapplication.multi_select.MultiSelectActivity;
import com.example.administrator.myapplication.weibo.WeiboActivity;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MenuBaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent();
        switch (item.getItemId()){
            case R.id.NormalActivity:
                break;
            case R.id.MultiSelectActivity:
                intent.setClass(this, MultiSelectActivity.class);
                break;
            case R.id.WeiboActivity:
                intent.setClass(this, WeiboActivity.class);
                break;
            default:
                return false;

        }
        startActivity(intent);
        this.finish();
        return true;
    }
}
