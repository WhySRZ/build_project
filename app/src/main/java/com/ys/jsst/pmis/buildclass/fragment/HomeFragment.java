package com.ys.jsst.pmis.buildclass.fragment;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.jaeger.library.StatusBarUtil;
import com.ys.jsst.pmis.buildclass.R;
import com.ys.jsst.pmis.buildclass.adapter.HomeModuleMainAdapter;
import com.ys.jsst.pmis.buildclass.base.BaseAttribute;
import com.ys.jsst.pmis.buildclass.base.BaseFragment;
import com.ys.jsst.pmis.buildclass.databinding.HomemoduleActivityMainBinding;
import com.ys.jsst.pmis.buildclass.ui.widegt.dialog.HomeDialog;
import com.ys.jsst.pmis.buildclass.utils.RecyclerViewDivider;
import com.ys.jsst.pmis.buildclass.utils.ToastUtil;

public class HomeFragment
        extends BaseFragment<HomemoduleActivityMainBinding>
        implements HomeModuleMainAdapter.HomeModuleMainAdapterListener, View.OnClickListener {
   // private String mSkinPkgPath = Environment.getExternalStorageDirectory() + File.separator + "red.skin";
    RecyclerView          mHomemoduleHomeRecycle;
    HomeModuleMainAdapter mAdapter;
    private GridView mMainRecycleviewtop;
    private ImageView mHead;
    private ImageView scan;
   // private TwinklingRefreshLayout mRefreshLayout;


    @Override
    public void initFragment(BaseAttribute attribute) {
        attribute.mLayoutId = R.layout.homemodule_activity_main;
        // StatusBarUtil.setTranslucent(this,255);

    }


   /* @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // 只需要调用这一句，第一个参数是当前Acitivity/Fragment，回调方法写在当前Activity/Framgent。
        AndPermission.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    // 成功回调的方法，用注解即可，里面的数字是请求时的requestCode。
    @PermissionYes(100)
    private void getLocationYes(List<String> grantedPermissions) {
        // TODO 申请权限成功。
    }

    // 失败回调的方法，用注解即可，里面的数字是请求时的requestCode。
    @PermissionNo(100)
    private void getLocationNo(List<String> deniedPermissions) {
        // 用户否勾选了不再提示并且拒绝了权限，那么提示用户到设置中授权。
        if (AndPermission.hasAlwaysDeniedPermission(this, deniedPermissions)) {
            // 第一种：用默认的提示语。
            AndPermission.defaultSettingDialog(this, 100).show();
        }
    }*/


    /**
     * Rationale支持，这里自定义对话框。
     */
   /* private RationaleListener rationaleListener = new RationaleListener() {
        @Override
        public void showRequestPermissionRationale(int requestCode,final Rationale rationale) {
            AlertDialog.build(getContext())
                       .setTitle("友好提醒")
                       .setMessage("您已拒绝过定位权限，没有定位权限无法为您推荐附近妹子，请把定位权限赐给我吧！")
                       .setPositiveButton("好，给你", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            rationale.resume();
                        }
                    })
                       .setNegativeButton("我拒绝", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            rationale.cancel();
                        }
                    }).show();
        }


    };*/
    @Override
    public void initData() {
       /* AndPermission.with(this)
                .requestCode(100)
                .permission(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_SMS
                        ,Manifest.permission.CAMERA)
                // rationale作用是：用户拒绝一次权限，再次申请时先征求用户同意，再打开授权对话框，避免用户勾选不再提示。
                .rationale(rationaleListener)
                .send();*/


    }

    @Override
    public void initEvent() {
        mAdapter.setHomeModuleMainAdapterListener(this);
        mViewBinding.homemoduleHomeHead.setOnClickListener(this);
        mViewBinding.homemoduleHomeScan.setOnClickListener(this);
       /* mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.finishRefreshing();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.finishLoadmore();
                    }
                }, 5000);
            }
        });*/

        //设置状态栏为透明颜色
        StatusBarUtil.setTranslucentForImageView(getActivity(), 0,mHomemoduleHomeRecycle);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initView() {
/*
        mRefreshLayout =  mViewBinding.refreshLayout;
        mRefreshLayout.setHeaderView(new mainhead(getContext()));
        mRefreshLayout.setHeaderHeight(100);*/

        mHomemoduleHomeRecycle = mViewBinding.homemoduleHomeRecycle;
        mHomemoduleHomeRecycle.addItemDecoration(new RecyclerViewDivider(getContext(), LinearLayoutManager.HORIZONTAL));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mHomemoduleHomeRecycle.setLayoutManager(layoutManager);

        mAdapter = new HomeModuleMainAdapter(getContext());
        mHomemoduleHomeRecycle.setAdapter(mAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void gridViewOnClickListener(int position) {
        ToastUtil.showLongToast(getContext(), "gridview   " + position);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void recycleViewOnclickListener(int position) {
        ToastUtil.showLongToast(getContext(), "recycle   " + position);
       /* if (position == 0) {

            SkinManager.getInstance().changeSkin(
                    mSkinPkgPath,
                    "com.ys.jsst.pmis.skin.red",
                    new ISkinChangingCallback() {
                        @Override
                        public void onStart() {
                        }

                        @Override
                        public void onError(Exception e) {
                            ToastUtil.showLongToast(getContext(), "换肤失败");

                        }

                        @Override
                        public void onComplete() {
                            ToastUtil.showLongToast(getContext(), "换肤成功");
                        }
                    });
        }else if (position ==1){
            SkinManager.getInstance().removeAnySkin();
        }*/
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.homemodule_home_head) {

            //ToastUtil.showLongToast(getContext(), "头像");

        } else if (i == R.id.homemodule_home_scan) {
                        /*Intent intent = new Intent();
                        intent.setClassName(getContext(), "com.ys.jsst.pmis.scanmodule.CaptureActivity");
                        startActivity(intent);*/
//            ARouter.getInstance().build(RouterConstant.scanActivity).navigation();

            HomeDialog dialog = new HomeDialog(getActivity(), new HomeDialog.OnMenuClickListener() {
                @Override
                public void onMenuClick(int menu) {

                }
            });
            dialog.show();
        }
    }

}
