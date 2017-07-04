package com.ys.jsst.pmis.buildclass.base;

import android.graphics.drawable.Drawable;

/**
 * description:activity fragment 基本属性
 * Date: 2016/6/15
 * Time: 16:17
 */
public class BaseAttribute {
    //布局LayoutId
    public int mLayoutId;
    public boolean mSetContentView = true;
    public boolean mHasTitle = true;
    public boolean mHasTheme = false;
    public boolean mHasHomeButton = true;
    public boolean canChangeBg = false;
    public int mThemeId;
    public int mTitleLayoutId;
    public int mTitleBackgroundColorId = 0;

    public boolean mAddTitleText = true;
    public int mTitleTextLayoutId;
    public int mTitleTextStringId;
    public int mTitleLeftViewId;
    public int mTitleRightViewId;
    public String mTitleText;
    public Drawable rightLogo;
    public Drawable leftLogo;
    public String leftText;
    public String rightText;

    public boolean mAddBackButton = false;
    public boolean mAddRightButton = false;

}