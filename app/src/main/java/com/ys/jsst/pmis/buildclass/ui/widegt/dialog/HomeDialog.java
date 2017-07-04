package com.ys.jsst.pmis.buildclass.ui.widegt.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.ys.jsst.pmis.buildclass.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * description:	菜单对话框
 * User: shaobing
 * Date: 2016/6/27
 * Time: 18:09
 */
public class HomeDialog
        extends Dialog
{


    @Bind(R.id.tv_chapter)
    TextView tvChapter;
    @Bind(R.id.tv_new_project)
    TextView tvTime;
    private Context mContext;

    private OnMenuClickListener mOnMenuClickListener;

    public HomeDialog(Context mContext, OnMenuClickListener mOnMenuClickListener) {
        super(mContext, R.style.CustomDialog);
        // TODO Auto-generated constructor stub
        this.mContext = mContext;
        this.mOnMenuClickListener = mOnMenuClickListener;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_home);
        ButterKnife.bind(this);
        /**************************************************************************************/
        this.setCanceledOnTouchOutside(true);// 设置点击屏幕Dialog不消失 true消失  false不消失
        this.setCancelable(true);             //点击返回按钮不能够取消
        Window                     dialogWindow = this.getWindow();
        WindowManager.LayoutParams lp           = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setAttributes(lp);
        dialogWindow.setGravity(Gravity.TOP | Gravity.RIGHT);
        setOwnerActivity((Activity) mContext);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        enterAnima();
    }

    private void initData() {

    }

    private void initEvent() {
    }

    public void hide() {
        this.dismiss();
    }

    private void enterAnima() {

    }

    @OnClick({R.id.tv_chapter, R.id.tv_new_project})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_chapter:
                if(mOnMenuClickListener!=null){
                    mOnMenuClickListener.onMenuClick(0);
                }
                this.dismiss();
                break;
            case R.id.tv_new_project:
                if(mOnMenuClickListener!=null){
                    mOnMenuClickListener.onMenuClick(1);
                }
                this.dismiss();
                break;
        }
    }

    public interface OnMenuClickListener {
        void onMenuClick(int menu);
    }
}