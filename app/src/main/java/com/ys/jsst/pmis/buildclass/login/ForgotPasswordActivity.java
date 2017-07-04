package com.ys.jsst.pmis.buildclass.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;
import com.ys.jsst.pmis.buildclass.R;
import com.ys.jsst.pmis.buildclass.ui.widegt.dialog.DefaultDialog;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：
 * 作者：shenrunzhou
 * 时间： 2017-06-25 18:05
 */
public class ForgotPasswordActivity extends AppCompatActivity {

    @Bind(R.id.forgot_toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tv_tool_bar_title)
    TextView mToolBarTitle;
    @Bind(R.id.iv_tool_bar_left)
    ImageView mBack;
    @Bind(R.id.tv_next)
    TextView mNext;
    @Bind(R.id.lv_layout)
    LinearLayout mLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        StatusBarCompat.setStatusBarColor(this, 0xFF00A5FE, true);
        ButterKnife.bind(this);
        initData();
        initToolBar();


    }

    private void initData() {
        //下一步
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this,RemakePasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //手机丢失/停用
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DefaultDialog dialog = new DefaultDialog(ForgotPasswordActivity.this, true);
                dialog.show();

                dialog.setContentText(getString(R.string.to_find_password));

                dialog.setCancelText(getString(R.string.cancel))
                      .setOnDefaultDialogListener(new DefaultDialog.OnDefaultDialogListener() {
                          @Override
                          public void onOk() {

                              Intent intent = new Intent(ForgotPasswordActivity.this,PasswordProtectActivity.class);
                              startActivity(intent);
                              finish();
                          }

                          @Override
                          public void onCancel() {

                          }
                      });


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
            mToolBarTitle.setText(R.string.forget_password);



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
