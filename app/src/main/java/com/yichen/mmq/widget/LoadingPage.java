package com.yichen.mmq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.yichen.mmq.R;
import com.yichen.mmq.utils.UIUtils;


public abstract class LoadingPage extends FrameLayout {

	//1.定义4种不同的显示状态
	private static final int STATE_LOADING = 1;
	private static final int STATE_ERROR = 2;
	private static final int STATE_EMPTY = 3;
	private static final int STATE_SUCCESS = 4;

	public int getState_current() {
		return state_current;
	}

	public void setState_current(int state_current) {
		this.state_current = state_current;
	}

	private int state_current = STATE_LOADING;//默认情况下，当前状态为正在加载

	//2.提供4种不同的界面
	private View view_loading;
	private View view_error;
	private View view_empty;
	private View view_success;
	private LayoutParams params;

	private Context mContext;

	public LoadingPage(Context context) {
		this(context, null);
	}

	public LoadingPage(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		this.mContext = context;

		init();
	}

	//初始化方法
	private void init() {
		//实例化view
		//1.提供布局显示的参数
		params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
				.LayoutParams.MATCH_PARENT);
		if (view_loading == null) {
			//2.加载布局
			view_loading = UIUtils.getView(R.layout.page_loading);
			//3.添加到当前的frameLayout中
			addView(view_loading, params);
		}

		if (view_empty == null) {
			//2.加载布局
			view_empty = UIUtils.getView(R.layout.page_empty);
			//3.添加到当前的frameLayout中
			addView(view_empty, params);
		}

		if (view_error == null) {
			//2.加载布局
			view_error = UIUtils.getView(R.layout.page_error);
			//3.添加到当前的frameLayout中
			addView(view_error, params);
		}

		showSafePage();
	}

	//保证如下的操作在主线程中执行的：更新界面
	private void showSafePage() {
		UIUtils.postTaskSafely(new Runnable() {

			@Override
			public void run() {
				//保证run()中的操作在主线程中执行
				showPage();
			}
		});
	}

	/**
	 *  刷新视图
	 */
	private void showPage() {
		//根据当前state_current的值，决定显示哪个view
		view_loading.setVisibility(state_current == STATE_LOADING ? View.VISIBLE : View
                .INVISIBLE);
		view_error.setVisibility(state_current == STATE_ERROR ? View.VISIBLE : View
                .INVISIBLE);
		view_empty.setVisibility(state_current == STATE_EMPTY ? View.VISIBLE : View
                .INVISIBLE);
		if (view_success != null)
			view_success.setVisibility(state_current == STATE_SUCCESS ? View.VISIBLE :
                    View.INVISIBLE);
		if (view_success == null) {

//            view_success = UIUtils.getView(layoutId());//加载布局使用的是Application
			view_success = View.inflate(mContext, layoutId(), null);//加载布局使用的是activity
			addView(view_success, params);
		}


	}

	public abstract int layoutId();




	public void show() {

		//根据修改以后的state_current，更新视图的显示。
		showSafePage();

	}


}
