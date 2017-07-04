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

import com.ys.jsst.pmis.buildclass.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：
 * 作者：shenrunzhou
 * 时间： 2017-06-30 09:18
 */
public class AddResumeActivity extends AppCompatActivity {

    @Bind(R.id.add_resume_toolbar)
    Toolbar   mToolbar;
    @Bind(R.id.tv_tool_bar_title)
    TextView  mToolBarTitle;
    @Bind(R.id.iv_tool_bar_left)
    ImageView mBack;
    @Bind(R.id.tv_right)
    TextView mRight;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resume);
        ButterKnife.bind(this);
        initData();
        initToolBar();
    }

    private void initData() {
        mRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到个人履历
                Intent intent = new Intent(AddResumeActivity.this,ResumeActivity.class);
                startActivity(intent);
                finish();
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
            mToolBarTitle.setText("添加履历");
            mRight.setText("保存");
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
