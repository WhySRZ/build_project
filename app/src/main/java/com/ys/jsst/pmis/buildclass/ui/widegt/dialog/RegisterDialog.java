package com.ys.jsst.pmis.buildclass.ui.widegt.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ys.jsst.pmis.buildclass.R;


public class RegisterDialog
        extends Dialog
        implements View.OnClickListener{

    private TextView                tvContent;
    private TextView                btnOk;
    private OnRegisterDialogListener onDefaultDialogListener;
    LinearLayout mLyResume;
    LinearLayout mLyAdmin;

    public interface OnRegisterDialogListener{
        void onOk();
        void onResume();
        void onAdmin();
    }

    public RegisterDialog setOnRegisterDialogListener(OnRegisterDialogListener onDefaultDialogListener){
        this.onDefaultDialogListener = onDefaultDialogListener;
        return this;
    }

    public RegisterDialog(Context context){
        super(context, R.style.CustomDialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    public RegisterDialog(Context context, boolean isOutCancel){
        super(context, R.style.CustomDialog);
        setCancelable(isOutCancel);
        setCanceledOnTouchOutside(isOutCancel);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_register);
        initView();
    }

    private void initView() {
        tvContent = (TextView) findViewById(R.id.tv_content);
        btnOk = (TextView) findViewById(R.id.confirm_button);
        mLyResume = (LinearLayout) findViewById(R.id.register_resume);
        mLyAdmin = (LinearLayout) findViewById(R.id.register_admin);
       // btnCancel = (TextView) findViewById(R.id.cancel_button);

        btnOk.setOnClickListener(this);
        mLyResume.setOnClickListener(this);
        mLyAdmin.setOnClickListener(this);
       // btnCancel.setOnClickListener(this);

    }

    public RegisterDialog setContentText(String content){
        if (tvContent != null && content != null) {
            tvContent.setText(content);
        }
        return this;
    }

    /**
     * 显示Dialog
     * @return
     */
    public RegisterDialog showdialog(){
        this.show();
        return this;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.confirm_button:
                if(onDefaultDialogListener != null){
                    onDefaultDialogListener.onOk();
                }
                dismiss();
                break;
            case R.id.register_resume:
                if (onDefaultDialogListener !=null){
                    onDefaultDialogListener.onResume();
                }
                dismiss();
                break;
            case R.id.register_admin:
                if (onDefaultDialogListener != null){
                    onDefaultDialogListener.onAdmin();
                }
                dismiss();
                break;
        }
    }
}

