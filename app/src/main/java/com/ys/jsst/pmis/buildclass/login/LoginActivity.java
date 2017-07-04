package com.ys.jsst.pmis.buildclass.login;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;
import com.ys.jsst.pmis.buildclass.R;
import com.ys.jsst.pmis.buildclass.home.MainActivity;
import com.ys.jsst.pmis.buildclass.register.RegisterActivity;
import com.ys.jsst.pmis.buildclass.ui.widegt.ClearEditText;
import com.ys.jsst.pmis.buildclass.utils.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity
        extends AppCompatActivity
{
    private boolean isFirst = true;
    @Bind(R.id.login_main)
    LinearLayout loginMain;
    @Bind(R.id.tv_login)
    TextView     mLogin;
    @Bind(R.id.cet_user_id)
    ClearEditText mUser;
    @Bind(R.id.cet_password)
    ClearEditText mPassword;
    @Bind(R.id.tv_forgot)
    TextView     mForgot;

    @Bind(R.id.tv_register)
    TextView mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StatusBarCompat.setStatusBarColor(this, 0xffffffff, true);
        ButterKnife.bind(this);
        addLayoutListenner(loginMain, mLogin);
        initData();


    }

    private void initData() {
        mUser.getText();
        mForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);

            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUser.getText().length() == 0 || mPassword.getText().length() == 0){
                    ToastUtil.showShortToast(LoginActivity.this,"请输入账号或密码");
                }else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
        /**
         * 让登陆按钮不被输入键盘挡住
         */

    private void addLayoutListenner(final View main, final View scroll) {

        main.getViewTreeObserver()
            .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    //1.获取窗口可视区域
                    main.getWindowVisibleDisplayFrame(rect);
                    //在键盘没弹起来时,获取main窗体的不可视区域的高度
                    int mainInvisableHeight = main.getRootView()
                                                  .getHeight() - rect.bottom;
                    //窗体的高度
                    int screenHeight = main.getRootView()
                                           .getHeight();
                    //3.不可见区域大于屏幕1/4,说明键盘弹起
                    if (mainInvisableHeight > screenHeight / 4) {
                        if (isFirst) {
                            int[] location = new int[2];

                            scroll.getLocationInWindow(location);
                            //4.获取scroll窗体的坐标,算出main需要滚动的高度
                            int scrollHeight = (location[1] + scroll.getHeight() - rect.bottom);
                            //5.让界面整体上移键盘的高度
                            main.scrollTo(0, scrollHeight);
                            isFirst = false;
                        }
                    } else {
                        //不可见区域小于屏幕1/4说明键盘隐藏,将界面移回原来的高度
                        main.scrollTo(0, 0);
                        isFirst = true;
                    }
                }
            });
    }
}