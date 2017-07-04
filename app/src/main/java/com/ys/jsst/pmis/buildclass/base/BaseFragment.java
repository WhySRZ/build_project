package com.ys.jsst.pmis.buildclass.base;

import android.annotation.TargetApi;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * description:fragment基类
 * Date: 2016/6/15
 * Time: 16:17
 */
public abstract class BaseFragment<B extends ViewDataBinding> extends Fragment {

    public B mViewBinding;
    private BaseAttribute attribute =new BaseAttribute();

    /*
     * 返回一个需要展示的View
     */
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initFragment(attribute);
        View view = View.inflate(getContext(),attribute.mLayoutId,null);
        mViewBinding = DataBindingUtil.bind(view);

        return mViewBinding.getRoot();
    }
    /*
     * 当Activity初始化之后可以在这里进行一些数据的初始化操作
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        initEvent();
    }
    /**
     * 子类实现此抽象方法初始化View
     */
    public abstract void initView();

    /**
     * 子类实现此抽象方法初始化布局
     */
    public abstract void initFragment(BaseAttribute attribute);

    /**
     * 子类在此方法中实现数据的初始化
     */
    public  abstract void initData() ;

    /**
     * 子类可以复写此方法初始化事件
     */
    public abstract void initEvent();

}