package com.ys.jsst.pmis.buildclass.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;
import com.ys.jsst.pmis.buildclass.R;
import com.ys.jsst.pmis.buildclass.ui.widegt.dialog.RegisterDialog;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：注册首页
 * 作者：shenrunzhou
 * 时间： 2017-06-27 18:01
 */
public class RegisterActivity extends AppCompatActivity{
    @Bind(R.id.register_toolbar)
    Toolbar   mToolbar;
    @Bind(R.id.tv_tool_bar_title)
    TextView  mToolBarTitle;
    @Bind(R.id.iv_tool_bar_left)
    ImageView mBack;
    @Bind(R.id.tv_to_register)
    TextView mRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        StatusBarCompat.setStatusBarColor(this, 0xFF00A5FE, true);
        ButterKnife.bind(this);
        initData();
        initToolBar();
    }

    private void initData() {
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RegisterDialog dialog = new RegisterDialog(RegisterActivity.this, true);
                dialog.show();

                dialog.setOnRegisterDialogListener(new RegisterDialog.OnRegisterDialogListener() {
                    @Override
                    public void onOk() {
                        //跳到主页了
                    }

                    @Override
                    public void onResume() {
                    //跳到个人简历页面
                        Intent intent = new Intent(RegisterActivity.this, ResumeActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAdmin() {
                        //跳到申请企业管理员界面
                        Intent company = new Intent(RegisterActivity.this,ApplyAdministorActivity.class);
                        startActivity(company);
                    }
                });
                //finish();
            }
        });
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            mBack.setVisibility(View.GONE);
            mToolbar.setNavigationIcon(R.mipmap.ic_back);
            mToolBarTitle.setText(R.string.register);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {//返回键
            onBackPressed();




        }
        return super.onContextItemSelected(item);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
