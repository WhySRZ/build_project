package com.ys.jsst.pmis.buildclass.register;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ys.jsst.pmis.buildclass.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.yzl.wheelselector.singleselect.ItemConfirmListener;
import cn.yzl.wheelselector.singleselect.SingleSelector;

/**
 * 描述：申请企业注册
 * 作者：shenrunzhou
 * 时间： 2017-06-30 16:07
 */
public class CompanyRegisterActivity extends AppCompatActivity {


    @Bind(R.id.apply_adm_toolbar)
    Toolbar        mToolbar;
    @Bind(R.id.tv_tool_bar_title)
    TextView       mToolBarTitle;
    @Bind(R.id.iv_tool_bar_left)
    ImageView      mBack;
    @Bind(R.id.tv_right)
    TextView       mRight;
    @Bind(R.id.rl_type)
    RelativeLayout mType;
    @Bind(R.id.tv_company)
    TextView mCompanyType;
    String [] question = new String[3];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_register);
        ButterKnife.bind(this);
        initToolbar();
        initData();
    }

    private void initData() {

        question[0] ="集团总公司";
        question[1] ="集团分公司";
        question[2] ="集团子公司";

        mRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CompanyRegisterActivity.this,"提交成功",Toast.LENGTH_SHORT).show();
            }
        });


        mType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐藏软件键盘
                InputMethodManager imm1 = (InputMethodManager) CompanyRegisterActivity.this.getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm1.hideSoftInputFromWindow(v.getWindowToken(), 0);//从控件所在的窗口中隐藏



                SingleSelector singleSelector = new SingleSelector(CompanyRegisterActivity.this
                        , question , "企业类型", getWindow());

                singleSelector.getTitleV().setBackgroundColor(getResources().getColor(R.color.app_white));
                singleSelector.getCancelBut().setVisibility(View.GONE);
                singleSelector.getConfirmBut().setText("完成");
                singleSelector.setConfirmListener(new ItemConfirmListener() {
                    @Override
                    public void confirm(int position, String text) {
                        //Toast.makeText(PasswordProtectActivity.this, position + ":::" + text, Toast.LENGTH_SHORT).show();
                        mCompanyType.setText(text);
                    }
                });
                singleSelector.show(Gravity.BOTTOM);
            }
        });

    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            mBack.setVisibility(View.GONE);
            mToolbar.setNavigationIcon(R.mipmap.ic_back);
            mToolBarTitle.setText("申请企业注册");
            mRight.setText("提交");
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
