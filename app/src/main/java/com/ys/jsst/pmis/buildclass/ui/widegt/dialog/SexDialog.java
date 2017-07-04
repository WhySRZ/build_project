package com.ys.jsst.pmis.buildclass.ui.widegt.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ys.jsst.pmis.buildclass.R;


/**
 * description:	选择性别弹出对话框
 * User: 赵家豪
 * Date: 2017/2/9
 * Time: 18:09
 */
public class SexDialog
		extends Dialog
{
	private Context          mContext;
	private OnDialogListener mListener;
	private LinearLayout     rlytDialog;
	private TextView         btMen;
	private TextView         btWomen;
	private TextView         btCancel;
	private String           mContentText;
	public SexDialog(Context mContext, String title, OnDialogListener mListener)
	{
		super(mContext, R.style.CustomDialog);
		// TODO Auto-generated constructor stub
		this.mContext= mContext;
		this.mListener =mListener;
		mContentText = title;
	}

	public SexDialog(Context context, OnDialogListener listener){
		super(context ,R.style.CustomDialog);
		this.mContext = context;
		this.mListener = listener;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_sex);
		/**************************************************************************************/
		this.setCanceledOnTouchOutside(true);// 设置点击屏幕Dialog不消失 true消失  false不消失
		Window                     dialogWindow = this.getWindow();
		WindowManager.LayoutParams lp           = dialogWindow.getAttributes();
		lp.width = WindowManager.LayoutParams.MATCH_PARENT;
		lp.height= WindowManager.LayoutParams.WRAP_CONTENT;
		dialogWindow.setAttributes(lp);
		dialogWindow.setGravity(Gravity.BOTTOM);
		setOwnerActivity((Activity)mContext);
		initView();
		initData();
		initEvent();
	}

	private void initView()
	{
		btMen= (TextView) findViewById(R.id.bt_men);
		btWomen= (TextView) findViewById(R.id.bt_women);
		btCancel = (TextView) findViewById(R.id.bt_cancel);
		rlytDialog = (LinearLayout)findViewById(R.id.lly_sex);
		enterAnima();
	}

	private void initData()
	{
	}

	private void initEvent()
	{
		btMen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				exitAnima();
				if(mListener!= null) {
					mListener.onDialogMessage(0);
				}
			}
		});
		btWomen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				exitAnima();
				if(mListener!= null) {
					mListener.onDialogMessage(1);
				}
			}
		});
		btCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				exitAnima();
				if(mListener!= null) {
					mListener.onDialogMessage(2);
				}
			}
		});
	}

	public void hide()
	{
		this.dismiss();
	}

	private void enterAnima()
	{
		rlytDialog.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.dialog_down_in));
	}
	private void exitAnima()
	{
		Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.dialog_down_out);
		rlytDialog.startAnimation(animation);
		animation.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				SexDialog.this.dismiss();
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
	}

	public interface OnDialogListener
	{
		void onDialogMessage(int flag);
	}
}