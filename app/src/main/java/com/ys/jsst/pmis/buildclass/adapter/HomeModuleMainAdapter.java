package com.ys.jsst.pmis.buildclass.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.ys.jsst.pmis.buildclass.R;
import com.ys.jsst.pmis.buildclass.ui.widegt.CustomGridView;
import com.ys.jsst.pmis.buildclass.ui.widegt.RippleView;


/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-4-5 16:53
 */
public class HomeModuleMainAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private HomeModuleMainAdapterListener listener;

    public HomeModuleMainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh = null;
        switch (viewType) {
            case 0:
                vh = new ViewHolder3(View.inflate(context, R.layout.homemodule_item_recycylebottom, null));
                break;
            case 1:
                vh = new ViewHolder2(View.inflate(context, R.layout.homemodule_item_recycyletop, null));
                break;
            case 2:
                /*TextView tv = new TextView(context);
                tv.setPadding(24, 28, 0, 28);
                tv.setTextSize(16);
                tv.setTextColor(Color.parseColor("#000000"));*/
                //tv.setBackgroundColor(Color.parseColor("#F4F3F8"));
                vh = new ViewHolder1(View.inflate(context,R.layout.homemodule_item_task,null));


                break;

        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case 0:
                View itemView = holder.itemView;

                if (itemView instanceof RippleView) {
                    ((RippleView) itemView).setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                        @Override
                        public void onComplete(RippleView rippleView) {
                            if (listener != null) {
                                listener.recycleViewOnclickListener(position - 2);
                            }
                        }
                    });
                } else {
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (listener != null) {
                                listener.recycleViewOnclickListener(position - 2);
                            }
                        }
                    });
                }

                break;
            case 1:
                CustomGridView gridView = ((ViewHolder2) holder).mIvHead;

                HomeModuleRcTopAdapter moduleRcTopAdapter = new HomeModuleRcTopAdapter(context);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,final int position, long id) {
                        if (view instanceof RippleView){
                            ((RippleView) view).setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                                @Override
                                public void onComplete(RippleView rippleView) {
                                    if (listener != null) {
                                        listener.gridViewOnClickListener(position);
                                    }
                                }
                            });
                        }

                    }
                });
                gridView.setAdapter(moduleRcTopAdapter);
                break;
            case 2:

               // ((ViewHolder1) holder).tv.setText("最新任务");
                break;
        }
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        private TextView tv;
        public ViewHolder1(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.task);
        }
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        private CustomGridView mIvHead;


        public ViewHolder2(final View itemView) {
            super(itemView);
            mIvHead = (CustomGridView) itemView.findViewById(R.id.gv_main_recycleviewtop);

        }
    }

    public static class ViewHolder3 extends RecyclerView.ViewHolder {


        public ViewHolder3(final View itemView) {
            super(itemView);

        }
    }

    /**
     * @param position
     * @return 1代表上面的8个按钮, 2代表最新任务, 0代表最新任务下面的条目
     */
    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return 1;
        } else if (position == 1) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * 点击事件借口
     */
    public interface HomeModuleMainAdapterListener {
        void gridViewOnClickListener(int position);

        void recycleViewOnclickListener(int position);
    }

    /**
     * 设置点击事件回调
     */
    public void setHomeModuleMainAdapterListener(HomeModuleMainAdapterListener listener) {
        this.listener = listener;
    }

}
