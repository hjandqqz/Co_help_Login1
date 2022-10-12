package com.example.co_help_login.activity.user;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.co_help_login.R;
import com.example.co_help_login.biz.UserBiz;
import com.example.co_help_login.listener.ClickListener;

//基本活动
public class BaseActivity extends AppCompatActivity {
    private ProgressDialog eLoadingDialog;
    private Toolbar toolbar;
    private UserBiz userBiz;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //判断系统版本
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(0xff000000);
        }
        //创建加载框
        eLoadingDialog = new ProgressDialog(this);
        eLoadingDialog.setMessage("加载中...");
    }
    protected void stopLoadingProgress() {
        if(eLoadingDialog != null && eLoadingDialog.isShowing()) eLoadingDialog.dismiss();
    }

    protected void startLoadingProgress() {
        eLoadingDialog.show();
    }
    //设置返回按键
    protected void setUpToolBar() {
        toolbar = findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBackPressed();
                    }
                }
        );
    }
    //创建设置按键
    protected void setToolbar(int drawable, ClickListener clickListener){
        this.toolbar = findViewById(R.id.id_sa_toobar);
        setSupportActionBar(toolbar);
        this.toolbar.setNavigationIcon(drawable);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.click();
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopLoadingProgress();
        eLoadingDialog = null;
    }
    protected void toManagerUserCenterActivity() {
        Intent intent = new Intent(this, ManagerUserCenterActivity.class);
        startActivity(intent);
        finish();
    }

    protected void toManagerQuestionCenterActivity() {
        Intent intent = new Intent(this, ManagerQuestionCenterActivity.class);
        startActivity(intent);
        finish();
    }

    protected void toManagerTaskCenterActivity() {
        Intent intent = new Intent(this, ManagerTaskCenterActivity.class);
        startActivity(intent);
        finish();
    }

    protected void toManagerCreateNewUserActivity() {
        Intent intent = new Intent(this, ManagerCreateNewUserActivity.class);
        startActivityForResult(intent,1001);
    }

}
