package com.ys.jsst.pmis.buildclass.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.ys.jsst.pmis.buildclass.utils.LogUtil;
import com.zhy.changeskin.base.BaseSkinActivity;


/**
 * description:Activity基类
 * Date: 2016/6/15
 * Time: 16:17
 */
public abstract class BaseActivity<B extends ViewDataBinding> extends BaseSkinActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    public B mViewBinding;
    private BaseAttribute attribute = new BaseAttribute();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置每个Activity为竖屏模式
//        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //初始化绑定
        onInitAttribute(attribute);
        if(attribute.mLayoutId>0){
            mViewBinding = DataBindingUtil.setContentView(this, attribute.mLayoutId);
        }
        LogUtil.d("BaseActivity DataBindingUtil " +attribute.mLayoutId);
        RunningActivityManager.getInstance().addActivity(this);
    }

    protected abstract void onInitAttribute(BaseAttribute attribute);



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //避免activity里面添加fragment时，在待机过程中出现异常
//        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        RunningActivityManager.getInstance().removeActivity(this);
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
