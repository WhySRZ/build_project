package com.ys.jsst.pmis.buildclass.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ys.jsst.pmis.buildclass.R;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-4-5 17:44
 */
public class HomeModuleRcTopAdapter
        extends BaseAdapter {
    private Context context;
    String[] str;
    int[] i = {R.drawable.homemodule_jskt, R.drawable.homemodule_qzgl, R.drawable.homemodule_zjtd, R.drawable.homemodule_xzgl
            , R.drawable.homemodule_wzgl, R.drawable.homemodule_zzjg, R.drawable.homemodule_pfgz, R.drawable.homemodule_all};

    public HomeModuleRcTopAdapter(Context context) {
        this.context = context;
        if (context != null) {
            str = context.getResources().getStringArray(R.array.main_gv);
        }
    }

    @Override
    public int getCount() {
        return 8;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.homemodule_item_gv_rctop, null);
//            holder = new ViewHolder(convertView);
//            convertView.setTag(convertView);
        } else {
//            holder = (ViewHolder) convertView.getTag();
        }
        ((TextView) convertView.findViewById(R.id.item_tv_gv_rctop)).setText(str[position]);
        ((ImageView) convertView.findViewById(R.id.item_iv_gv_rctop)).setImageResource(i[position]);
//        holder.tv.setText(str[position]);
//        holder.iv.setImageResource(i[position]);
        return convertView;
    }

    static class ViewHolder {
        TextView tv;
        ImageView iv;

        public ViewHolder(View view) {
            tv = (TextView) view.findViewById(R.id.item_tv_gv_rctop);
            iv = (ImageView) view.findViewById(R.id.item_iv_gv_rctop);
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
