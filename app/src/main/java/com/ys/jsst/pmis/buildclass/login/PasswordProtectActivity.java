package com.ys.jsst.pmis.buildclass.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.githang.statusbar.StatusBarCompat;
import com.ys.jsst.pmis.buildclass.R;
import com.ys.jsst.pmis.buildclass.ui.widegt.ClearEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.yzl.wheelselector.singleselect.ItemConfirmListener;
import cn.yzl.wheelselector.singleselect.SingleSelector;

/**
 * 描述：密保问题
 * 作者：shenrunzhou
 * 时间： 2017-06-27 14:09
 */
public class PasswordProtectActivity extends AppCompatActivity
        implements View.OnClickListener
{

    //toolbar
    @Bind(R.id.protect_toolbar)
    Toolbar   mToolbar;
    @Bind(R.id.tv_tool_bar_title)
    TextView  mToolBarTitle;
    @Bind(R.id.iv_tool_bar_left)
    ImageView mBack;

    @Bind(R.id.ly_one)
    LinearLayout mLyOne;
    @Bind(R.id.ly_two)
    LinearLayout mLyTwo;
    @Bind(R.id.ly_three)
    LinearLayout mLyThree;

    @Bind(R.id.tv_question_one)
    TextView mQusetionOne;
    @Bind(R.id.tv_question_two)
    TextView mQusetionTwo;
    @Bind(R.id.tv_question_three)
    TextView mQusetionThree;

    @Bind(R.id.cet_one)
    ClearEditText mEtOne;
    @Bind(R.id.cet_two)
    ClearEditText mEtTwo;
    @Bind(R.id.cet_three)
    ClearEditText mEtThree;

    @Bind(R.id.tv_protect_confirm)
    TextView mProtect;
    String [] question = new String[6];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protect_password);
        //设置标题栏颜色
        StatusBarCompat.setStatusBarColor(this, 0xFF00A5FE, true);
        ButterKnife.bind(this);
        initData();
        initToolBar();

    }

    private void initData() {
        question[0] = "你最喜欢的动物是什么?";
        question[1] = "你母亲的生日是?";
        question[2] = "你父亲的生日是?";
        question[3] = "你小学班主任的名字是?";
        question[4] = "你的出生地址是?";
        question[5] = "你最喜欢的人是谁?";


        mLyOne.setOnClickListener(this);
        mLyTwo.setOnClickListener(this);
        mLyThree.setOnClickListener(this);
        mProtect.setOnClickListener(this);

        //toChooseQuestion();

    }

    private void toChooseQuestion(String title, final TextView tv) {
        SingleSelector singleSelector = new SingleSelector(PasswordProtectActivity.this
            , question, title, getWindow());
        singleSelector.getTitleV().setBackgroundColor(getResources().getColor(R.color.app_white));
        singleSelector.getCancelBut().setVisibility(View.GONE);
        singleSelector.getConfirmBut().setText("完成");
        singleSelector.setConfirmListener(new ItemConfirmListener() {
            @Override
            public void confirm(int position, String text) {
                //Toast.makeText(PasswordProtectActivity.this, position + ":::" + text, Toast.LENGTH_SHORT).show();
                tv.setText(text);
            }
        });
        singleSelector.show(Gravity.BOTTOM);
    }


    private void initToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            mBack.setVisibility(View.GONE);
            mToolbar.setNavigationIcon(R.mipmap.ic_back);
            mToolBarTitle.setText(R.string.protect_password);
            
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ly_one:
                toChooseQuestion("问题一",mQusetionOne);
                 break;
            case R.id.ly_two:
                toChooseQuestion("问题二",mQusetionTwo);
                break;
            case R.id.ly_three:
                toChooseQuestion("问题三",mQusetionThree);
                break;
            case R.id.tv_protect_confirm:
                Toast.makeText(PasswordProtectActivity.this, "验证成功", Toast.LENGTH_SHORT)
                     .show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(PasswordProtectActivity.this,RemakePasswordActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);
            break;

        }
    }
}
