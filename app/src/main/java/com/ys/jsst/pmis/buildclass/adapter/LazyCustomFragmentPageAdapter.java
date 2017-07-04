package com.ys.jsst.pmis.buildclass.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import com.ys.jsst.pmis.buildclass.lazyfragment.LazyFragmentPagerAdapter;
import java.util.List;

/**
 * 综合排行榜底部ViewPage适配器
 * Created by xiaobin on 2017/6/12.
 */

public class LazyCustomFragmentPageAdapter
        extends LazyFragmentPagerAdapter
{

    private List<Fragment> fs ;

    public LazyCustomFragmentPageAdapter(FragmentManager fm , List<Fragment> fs){
        super(fm);
        this.fs = fs;
    }


    @Override
    protected Fragment getItem(ViewGroup container, int position) {
        return fs.get(position);
    }

    @Override
    public int getCount() {
        return fs.size();
    }
}
