package com.ys.jsst.pmis.buildclass.login;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.githang.statusbar.StatusBarCompat;
import com.ys.jsst.pmis.buildclass.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：
 * 作者：shenrunzhou
 * 时间： 2017-06-25 18:05
 */
public class RemakePasswordActivity
        extends AppCompatActivity {

    @Bind(R.id.forgot_toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tv_tool_bar_title)
    TextView mToolBarTitle;
    @Bind(R.id.iv_tool_bar_left)
    ImageView mBack;
    @Bind(R.id.tv_confirm)
    TextView mConfirm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remake_password);
        StatusBarCompat.setStatusBarColor(this, 0xFF00A5FE, true);
        ButterKnife.bind(this);
        initData();
        initToolBar();

    }

    private void initData() {

        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RemakePasswordActivity.this, "密码重置成功", Toast.LENGTH_SHORT)
                     .show();
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       finish();
                   }
               },2000);
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
            mToolBarTitle.setText(R.string.remake_password);



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
