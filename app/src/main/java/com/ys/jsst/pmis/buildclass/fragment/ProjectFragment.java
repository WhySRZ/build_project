package com.ys.jsst.pmis.buildclass.fragment;

import android.support.v4.app.Fragment;
import android.widget.RadioGroup;

import com.ys.jsst.pmis.buildclass.R;
import com.ys.jsst.pmis.buildclass.adapter.LazyCustomFragmentPageAdapter;
import com.ys.jsst.pmis.buildclass.base.BaseAttribute;
import com.ys.jsst.pmis.buildclass.base.BaseFragment;
import com.ys.jsst.pmis.buildclass.databinding.FragmentProjectBinding;

import java.util.ArrayList;
import java.util.List;

public class ProjectFragment
        extends BaseFragment<FragmentProjectBinding>
{


    private List<Fragment> fs = new ArrayList<>();
    @Override
    public void initView() {
        fs.add(new HomeFragment());
        fs.add(new MeFragment());
        mViewBinding.vpSynthesizeProject.setAdapter(new LazyCustomFragmentPageAdapter(getFragmentManager(), fs));
    }

    @Override
    public void initFragment(BaseAttribute attribute) {
        attribute.mLayoutId = R.layout.fragment_project;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        mViewBinding.rgProject.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_personal_project://个人项目
                        break;
                    case R.id.rb_company_project://企业项目
                        break;
                }
            }
        });
    }
}
