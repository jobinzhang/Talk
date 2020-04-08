package com.example.common.app;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract  class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindows();
        if (initArgs(getIntent().getExtras())) {
            setContentView(getContentLayoutId());
            initWidget();
            initData();
        } else {
            finish();
        }
    }

    protected abstract int getContentLayoutId();

    /**
     * 获取参数
     * @param bundle
     * @return
     */
    private boolean initArgs(Bundle bundle) {
        return true;
    }

    /**
     * 初始化界面
     */
    protected void initWidget() {
        ButterKnife.bind(this);
    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 初始化窗口
     */
    private void initWindows() {

    }

    @Override
    public boolean onSupportNavigateUp() {
        // 当点击导航返回时，结束当前activity
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        // 点击手机返回键时候
        super.onBackPressed();
        finish();
    }
}
