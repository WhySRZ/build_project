package com.ys.jsst.pmis.buildclass.register;

import android.content.Context;
import android.content.Intent;
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

import com.ys.jsst.pmis.buildclass.R;
import com.ys.jsst.pmis.buildclass.ui.widegt.dialog.EnterpriseDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.yzl.wheelselector.singleselect.ItemConfirmListener;
import cn.yzl.wheelselector.singleselect.SingleSelector;

/**
 * 描述：申请企业管理员
 * 作者：shenrunzhou
 * 时间： 2017-06-30 15:04
 */
public class ApplyAdministorActivity extends AppCompatActivity{


    @Bind(R.id.apply_adm_toolbar)
    Toolbar   mToolbar;
    @Bind(R.id.tv_tool_bar_title)
    TextView  mToolBarTitle;
    @Bind(R.id.iv_tool_bar_left)
    ImageView mBack;
    @Bind(R.id.tv_right)
    TextView  mRight;
    @Bind(R.id.rl_type)
    RelativeLayout mType;
    @Bind(R.id.tv_company)
    TextView mCompanyType;
    String [] question = new String[3];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_administor);
        ButterKnife.bind(this);
        initData();
        initToolBar();

    }

    private void initData() {
        question[0] ="集团总公司";
        question[1] ="集团分公司";
        question[2] ="集团子公司";

        mRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();


            }
        });

        mType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐藏软件键盘
                InputMethodManager imm1 = (InputMethodManager) ApplyAdministorActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm1.hideSoftInputFromWindow(v.getWindowToken(), 0);//从控件所在的窗口中隐藏



                SingleSelector singleSelector = new SingleSelector(ApplyAdministorActivity.this
                        ,question , "企业类型", getWindow());

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

    private void showDialog() {


        EnterpriseDialog dialog = new EnterpriseDialog(ApplyAdministorActivity.this, true);
        dialog.show();

        dialog.setContentText(getString(R.string.to_register_company));

        dialog.setCancelText(getString(R.string.cancel))
              .setOnDefaultDialogListener(new EnterpriseDialog.OnDefaultDialogListener() {
                  @Override
                  public void onOk() {

                      Intent intent = new Intent(ApplyAdministorActivity.this, CompanyRegisterActivity.class);
                      startActivity(intent);
                      finish();
                  }

                  @Override
                  public void onCancel() {

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
            mToolBarTitle.setText("申请企业管理员");
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
