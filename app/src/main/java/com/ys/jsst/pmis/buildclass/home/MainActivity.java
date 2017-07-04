package com.ys.jsst.pmis.buildclass.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.ys.jsst.pmis.buildclass.R;
import com.ys.jsst.pmis.buildclass.base.BaseActivity;
import com.ys.jsst.pmis.buildclass.base.BaseAttribute;
import com.ys.jsst.pmis.buildclass.databinding.ActivityMainBinding;
import com.ys.jsst.pmis.buildclass.fragment.ApplicationFragment;
import com.ys.jsst.pmis.buildclass.fragment.HomeFragment;
import com.ys.jsst.pmis.buildclass.fragment.MeFragment;
import com.ys.jsst.pmis.buildclass.fragment.MessageFragment;
import com.ys.jsst.pmis.buildclass.fragment.ProjectFragment;


/**
 * 描述：
 * 作者：shenrunzhou
 * 时间： 2017-07-01 09:42
 */
public class MainActivity extends BaseActivity<ActivityMainBinding> {
    public static final int HOMEFRAGMENT = 1;
    public static final int PROJECTFRAGMENT = 2;
    public static final int MESSAGEFRAGMENT = 3;
    public static final int APPLICATIONFRAGMENT = 4;
    public static final int MEFRAGMENT = 5;
    Fragment homeFragment;
    Fragment projectFragment;
    Fragment messageFragment;
    Fragment applicationFragment;
    Fragment meFragment;
    private FragmentTabHost mFragmentTabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();

    }


    @Override
    protected void onInitAttribute(BaseAttribute attribute) {
        attribute.mLayoutId = R.layout.activity_main;

    }

    private void initListener() {
        //        mViewBinding.rgMainRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        //            @Override
        //            public void onCheckedChanged(RadioGroup group, int checkedId) {
        //                showFragment(checkedId);
        //            }
        //        });

    }

    private void addtabView(String spec, int tabLayout, Class clazz) {
        View view = View.inflate(this, tabLayout, null);
        mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(spec).setIndicator(view), clazz, null);
    }

    private void initData() {
      /*  //        initFragment();
        //        addFragment();
        System.out.println("手机型号          " + Build.MODEL);
        //建立数据库
        LitePalDB litePalDB = new LitePalDB("main", 1);
        litePalDB.addClassName(MainBean.class.getName());
        //        litePalDB.setExternalStorage(true);
        LitePal.use(litePalDB);
        List<MainBean> albumList = DataSupport.findAll(MainBean.class);
        if (albumList == null || albumList.size() < 2) {
            MainBean bean = new MainBean();
            bean.setName("fffff");
            bean.setDuration(":;;;");
            bean.setLyric("aaa");
            bean.save();
        }
        LogUtil.d("MainActivity :" + new Gson().toJson(DataSupport.findAll(MainBean.class)));
        //        mViewBinding.rgMainRadio.check(mViewBinding.rgMainRadio.getChildAt(0).getId());
        //        showFragment(HOMEFRAGMENT);*/
    }

    private void initView() {
        mFragmentTabHost=  mViewBinding.mainTabHost;
        mFragmentTabHost.setup(this, getSupportFragmentManager(), R.id.content);
        //去掉分割线
        mFragmentTabHost.getTabWidget().setDividerDrawable(null);
        //
        addtabView("home", R.layout.fragment_tab_homepage, HomeFragment.class);
        //
        addtabView("project", R.layout.fragment_tab_project, ProjectFragment.class);

        addtabView("message", R.layout.fragment_tab_message, MessageFragment.class);
        addtabView("application", R.layout.fragment_tab_application, ApplicationFragment.class);
        addtabView("me", R.layout.fragment_tab_me, MeFragment.class);
    }


    /**
     * 初始化Fragment
     */
    private void initFragment() {
        //        homeFragment = (Fragment) ARouter.getInstance().build(RouterConstant.homeFragment).navigation();
        //        projectFragment = (Fragment) ARouter.getInstance().build(RouterConstant.projectFragment).navigation();
        //        messageFragment = (Fragment) ARouter.getInstance().build(RouterConstant.messageFragment).navigation();
        //        applicationFragment = (Fragment) ARouter.getInstance().build(RouterConstant.applicationFragment).navigation();
        //        meFragment = (Fragment) ARouter.getInstance().build(RouterConstant.meFragment).navigation();
        //
        homeFragment = new HomeFragment();
        projectFragment = new ProjectFragment();
        messageFragment = new MessageFragment();
        applicationFragment = new ApplicationFragment();
        meFragment = new MessageFragment();
    }


    /**
     * 添加fragment
     */
    private void addFragment() {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.add(R.id.content, homeFragment);
        transaction.add(R.id.content, projectFragment);

        transaction.add(R.id.content, messageFragment);
        transaction.add(R.id.content, applicationFragment);
        transaction.add(R.id.content, meFragment);
        transaction.commit();


    }

    /**
     * hide所有的fragment
     */
    private void hideFragment() {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.hide(homeFragment);
        transaction.hide(projectFragment);

        transaction.hide(messageFragment);
        transaction.hide(applicationFragment);
        transaction.hide(meFragment);
        transaction.commit();
    }


    /**
     * 显示Fragment
     *
     * @param tab 当前需要显示的位置
     */
    private void showFragment(int tab) {
        //        hideFragment();

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        switch (tab) {
            case HOMEFRAGMENT:

                transaction.show(homeFragment);
                break;

            case PROJECTFRAGMENT:
                transaction.show(projectFragment);
                break;
            case MESSAGEFRAGMENT:
                transaction.show(messageFragment);
                break;
            case APPLICATIONFRAGMENT:
                transaction.show(applicationFragment);
                break;

            case MEFRAGMENT:
                transaction.show(meFragment);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //双击退出应用程序
        System.exit(0);


    }
}