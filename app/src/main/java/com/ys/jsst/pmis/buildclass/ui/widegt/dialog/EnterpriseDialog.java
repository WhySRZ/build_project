package com.ys.jsst.pmis.buildclass.ui.widegt.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ys.jsst.pmis.buildclass.R;


public class EnterpriseDialog
        extends Dialog
        implements View.OnClickListener{

    private TextView                tvContent;
    private TextView                btnCancel;
    private TextView                btnOk;
    private OnDefaultDialogListener onDefaultDialogListener;

    public interface OnDefaultDialogListener{
        void onOk();
        void onCancel();
    }

    public EnterpriseDialog setOnDefaultDialogListener(OnDefaultDialogListener onDefaultDialogListener){
        this.onDefaultDialogListener = onDefaultDialogListener;
        return this;
    }

    public EnterpriseDialog(Context context){
        super(context, R.style.CustomDialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    public EnterpriseDialog(Context context, boolean isOutCancel){
        super(context, R.style.CustomDialog);
        setCancelable(isOutCancel);
        setCanceledOnTouchOutside(isOutCancel);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_enterprise);
        initView();
    }

    private void initView() {
        tvContent = (TextView) findViewById(R.id.tv_content);
        btnOk = (TextView) findViewById(R.id.confirm_button);
        btnCancel = (TextView) findViewById(R.id.cancel_button);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    public EnterpriseDialog setContentText(String content){
        if (tvContent != null && content != null) {
            tvContent.setText(content);
        }
        return this;
    }

    /**
     * 显示Dialog
     * @return
     */
    public EnterpriseDialog showdialog(){
        this.show();
        return this;
    }
    /**
     * 设置取消按钮
     * @param content 设置取消内容
     * @return
     */
    public EnterpriseDialog setCancelText(String content){
        if (btnCancel != null && content != null) {
            btnCancel.setText(content);
        }
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel_button:
                if(onDefaultDialogListener != null){
                    onDefaultDialogListener.onCancel();
                }
                dismiss();
                break;
            case R.id.confirm_button:
                if(onDefaultDialogListener != null){
                    onDefaultDialogListener.onOk();
                }
                dismiss();
                break;
        }
    }
}

