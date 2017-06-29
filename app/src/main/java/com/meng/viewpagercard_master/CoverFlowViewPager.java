package com.meng.viewpagercard_master;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class CoverFlowViewPager extends RelativeLayout implements OnPageSelectListener {

    /**
     * 适配器
     */
    private CoverFlowAdapter mAdapter;

    /**
     * 用于左右滚动
     */
    private ViewPager mViewPager;

    /**
     * 需要显示的视图集合
     */
    private List<View> mViewList = new ArrayList<>();

    private OnPageSelectListener listener;

    public CoverFlowViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_cover_flow, this);
        mViewPager = (ViewPager) findViewById(R.id.vp_conver_flow);
//        365dp 380
        int marginWidth = DensityUtils.dip2px(getContext(), 120);
        int displayWidth = DensityUtils.getDisplayWidth(getContext());
        int height = DensityUtils.dip2px(getContext(), 280);
        LayoutParams layoutParams = new LayoutParams(displayWidth - marginWidth, height);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        mViewPager.setLayoutParams(layoutParams);
        init();
    }

    /**
     * 初始化方法
     */
    private void init() {
        // 构造适配器，传入数据源
        mAdapter = new CoverFlowAdapter(mViewList, getContext());
        // 设置选中的回调
        mAdapter.setOnPageSelectListener(this);
        // 设置适配器
        mViewPager.setAdapter(mAdapter);
        // 设置滑动的监听，因为adpter实现了滑动回调的接口，所以这里直接设置adpter
        mViewPager.addOnPageChangeListener(mAdapter);
        // 预加载个数
        mViewPager.setOffscreenPageLimit(5);

        // 设置触摸事件的分发
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 传递给ViewPager 进行滑动处理
                return mViewPager.dispatchTouchEvent(event);
            }
        });

    }

    /**
     * 设置显示的数据，进行一层封装
     *
     * @param lists
     */
    public void setViewList(List<View> lists) {
        if (lists == null) {
            return;
        }
        mViewList.clear();
        for (View view : lists) {

            FrameLayout layout = new FrameLayout(getContext());
            // 设置padding 值，默认缩小
            layout.setPadding(CoverFlowAdapter.sWidthPadding, CoverFlowAdapter.sHeightPadding, CoverFlowAdapter.sWidthPadding, CoverFlowAdapter.sHeightPadding);
            layout.addView(view);
            mViewList.add(layout);
        }
        // 刷新数据
        mAdapter.notifyDataSetChanged();
    }


    /**
     * 当将某一个作为最中央时的回调
     *
     * @param listener
     */
    public void setOnPageSelectListener(OnPageSelectListener listener) {
        this.listener = listener;
    }


    // 显示的回调
    @Override
    public void select(int position) {
        if (listener != null) {
            listener.select(position);
        }
    }


}
