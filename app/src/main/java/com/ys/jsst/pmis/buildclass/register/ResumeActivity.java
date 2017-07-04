package com.ys.jsst.pmis.buildclass.register;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.ys.jsst.pmis.buildclass.R;
import com.ys.jsst.pmis.buildclass.ui.widegt.dialog.CameraDialog;
import com.ys.jsst.pmis.buildclass.ui.widegt.dialog.SexDialog;
import com.ys.jsst.pmis.buildclass.utils.AddressPickTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import cn.qqtheme.framework.picker.DatePicker;

/**
 * 描述：个人简历
 * 作者：shenrunzhou
 * 时间： 2017-06-28 11:06
 */
public class ResumeActivity extends AppCompatActivity
        implements View.OnClickListener
{

    private View     mViewNeedOffset;
    CameraDialog cameraDialog;
    SexDialog sexDialog;

    @Bind(R.id.forgot_toolbar)
    Toolbar   mToolbar;
    @Bind(R.id.tv_right)
    TextView  mToolBarTitle;
    @Bind(R.id.iv_tool_bar_left)
    ImageView mBack;
    //头像
    @Bind(R.id.iv_head)
    ImageView mHead;
    //性别
    @Bind(R.id.rl_sex)
    RelativeLayout mRlsex;
    @Bind(R.id.tv_sex)
    TextView mSex;
    //出生年月
    @Bind(R.id.rl_bir)
    RelativeLayout mRlBir;
    @Bind(R.id.tv_birthday)
    TextView mBirthday;
    //籍贯rl_origin
    @Bind(R.id.rl_origin)
    RelativeLayout mRlOrigin;
    @Bind(R.id.tv_origin)
    TextView mOrigin;
    //常驻地址
    @Bind(R.id.rl_resident_address)
    RelativeLayout mResident;
    @Bind(R.id.tv_resident_address)
    TextView mResidentAddress;
    //希望工作地
    @Bind(R.id.rl_exp_work_place)
    RelativeLayout mExp;
    @Bind(R.id.tv_exp_work_place)
    TextView mWorkPlace;
    //添加履历
    @Bind(R.id.ly_add_work_exp)
    LinearLayout mAddWork;
    //简历编辑1
    @Bind(R.id.editor1)
    TextView mEditor1;
    //简历编辑
    @Bind(R.id.editor)
    TextView mEditor;
    //保存简历
    @Bind(R.id.tv_to_save_resume)
    TextView mSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        ButterKnife.bind(this);
             mViewNeedOffset = findViewById(R.id.view_need_offset);
               // StatusBarUtil.setTranslucent(this,255);

        StatusBarUtil.setTranslucentForImageView(ResumeActivity.this, 0, mViewNeedOffset);
        initData();
        initListener();
        initToolBar();

    }

    private void initListener() {

        mBack.setOnClickListener(this);
        mHead.setOnClickListener(this);
        mSex.setOnClickListener(this);
        mBirthday.setOnClickListener(this);
        mOrigin.setOnClickListener(this);
        mResidentAddress.setOnClickListener(this);
        mWorkPlace.setOnClickListener(this);
        mAddWork.setOnClickListener(this);
        mEditor1.setOnClickListener(this);
        mEditor.setOnClickListener(this);
        mSave.setOnClickListener(this);
        mToolBarTitle.setOnClickListener(this);
        mRlsex.setOnClickListener(this);
        mRlBir.setOnClickListener(this);
        mResident.setOnClickListener(this);
        mExp.setOnClickListener(this);
        mRlOrigin.setOnClickListener(this);
    }

    private void initData() {

    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            //mBack.setVisibility(View.GONE);
            //mToolbar.setNavigationIcon(R.mipmap.ic_back);
            mToolbar.setBackgroundColor(Color.TRANSPARENT);
            mToolBarTitle.setText(R.string.register_save);



        }
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返后键
            case R.id.iv_tool_bar_left:
                onBackPressed();
                 break;
            //头像
            case R.id.iv_head:
                showCameraDialog();
                break;
            //性别
            case R.id.rl_sex:
                showSexDialog();
                break;
            //生日
            case R.id.rl_bir:
                DatePicker picker = new DatePicker(this, DatePicker.YEAR_MONTH);
                picker.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
                picker.setWidth((int) (picker.getScreenWidthPixels() * 1.0));
                picker.setRangeStart(1960, 10, 14);
                picker.setRangeEnd(2025, 11, 11);
                picker.setSelectedItem(2017, 6);
                picker.setOnDatePickListener(new DatePicker.OnYearMonthPickListener() {
                    @Override
                    public void onDatePicked(String year, String month) {
                        mBirthday.setText(year + "年" + month + "月");
                    }
                });
                picker.show();
                break;
            //籍贯
            case R.id.rl_origin:
                addressSelect();
                break;
            //常驻地址
            case R.id.rl_resident_address:

                addressSelect();
                break;
            //希望工作地
            case R.id.rl_exp_work_place:
                addressSelect();
                break;
            //简历编辑1
            case R.id.editor1:
                Intent intent1 = new Intent(ResumeActivity.this,AddResumeActivity.class);
                startActivity(intent1);
                break;
            //简历编辑
            case R.id.editor:
                Intent intent = new Intent(ResumeActivity.this,AddResumeActivity.class);
                startActivity(intent);
                break;
            //保存简历
            case R.id.tv_to_save_resume:

                break;
            //保存
            case R.id.tv_right:

                break;
            case R.id.ly_add_work_exp:
                Intent intent2 = new Intent(ResumeActivity.this,AddResumeActivity.class);
                startActivity(intent2);
                break;


        }
    }

    private void addressSelect() {

        /*ist<Map<String, Object>> data;
        String s = "[{\"province_id\":\"79\",\"province_name\":\"北京\",\"city\":[{\"city_id\":\"31\",\"city_name\":\"东城\"},{\"city_id\":\"32\",\"city_name\":\"西城\"},{\"city_id\":\"35\",\"city_name\":\"朝阳\"},{\"city_id\":\"36\",\"city_name\":\"丰台\"},{\"city_id\":\"37\",\"city_name\":\"石景山\"},{\"city_id\":\"38\",\"city_name\":\"海淀\"},{\"city_id\":\"39\",\"city_name\":\"门头沟\"},{\"city_id\":\"40\",\"city_name\":\"房山\"},{\"city_id\":\"41\",\"city_name\":\"通州\"},{\"city_id\":\"42\",\"city_name\":\"顺义\"},{\"city_id\":\"43\",\"city_name\":\"昌平\"},{\"city_id\":\"44\",\"city_name\":\"大兴\"},{\"city_id\":\"45\",\"city_name\":\"怀柔\"},{\"city_id\":\"46\",\"city_name\":\"平谷\"},{\"city_id\":\"47\",\"city_name\":\"密云\"},{\"city_id\":\"48\",\"city_name\":\"延庆\"}]},{\"province_id\":\"90\",\"province_name\":\"上海\",\"city\":[{\"city_id\":\"49\",\"city_name\":\"黄浦\"},{\"city_id\":\"51\",\"city_name\":\"徐汇\"},{\"city_id\":\"52\",\"city_name\":\"长宁\"},{\"city_id\":\"53\",\"city_name\":\"静安\"},{\"city_id\":\"54\",\"city_name\":\"普陀\"},{\"city_id\":\"55\",\"city_name\":\"闸北\"},{\"city_id\":\"56\",\"city_name\":\"虹口\"},{\"city_id\":\"57\",\"city_name\":\"杨浦\"},{\"city_id\":\"58\",\"city_name\":\"闵行\"},{\"city_id\":\"59\",\"city_name\":\"宝山\"},{\"city_id\":\"60\",\"city_name\":\"嘉定\"},{\"city_id\":\"61\",\"city_name\":\"浦东\"},{\"city_id\":\"62\",\"city_name\":\"金山\"},{\"city_id\":\"63\",\"city_name\":\"松江\"},{\"city_id\":\"64\",\"city_name\":\"青浦\"},{\"city_id\":\"66\",\"city_name\":\"奉贤\"}]}]";
        data = new Gson().fromJson(s, new TypeToken<List<Map<String, Object>>>() {
        }.getType());
        MulSelector mulSelector = new MulSelector(ResumeActivity.this, data, getWindow(),true);
            mulSelector.getTitleV();
        mulSelector.getTitleV().setBackgroundColor(getResources().getColor(R.color.app_white));

        mulSelector.getTitle_tv().setText("所在地区");



        mulSelector.setConfirmListener(new AddressConfirmListener() {
            @Override
            public void confirm(Map<String, Object> proviceData, Map<String, Object> cityData, Map<String, Object> disData) {

            }
        });

        mulSelector.show(Gravity.BOTTOM);


*/

        AddressPickTask task = new AddressPickTask(this);
        task.setHideCounty(true);
        task.setCallback(new AddressPickTask.Callback() {
            @Override
            public void onAddressInitFailed() {
                Toast.makeText(ResumeActivity.this,"数据初始化失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAddressPicked(Province province, City city, County county) {

            }
        });
        task.execute("广东", "深圳");
    }

    private void showSexDialog() {
        sexDialog = new SexDialog(ResumeActivity.this, " ", new SexDialog.OnDialogListener() {
            @Override
            public void onDialogMessage(int flag) {
            }
        });
        sexDialog.show();
    }

    private void showCameraDialog() {
        cameraDialog = new CameraDialog(ResumeActivity.this, " ", new CameraDialog.OnDialogListener(){

            @Override
            public void onDialogMessage(int flag) {

            }
        });
        cameraDialog.show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
