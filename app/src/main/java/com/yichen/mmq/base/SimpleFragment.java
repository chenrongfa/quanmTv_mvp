package com.yichen.mmq.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by crf on 2017/9/27.
 * company:逸辰
 * qq:952786280
 * feature: 简单的fragment
 */

public abstract class SimpleFragment extends Fragment {
	private boolean isAddParent;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViwBefore();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {

		View inflate = inflater.inflate(provideLayoutId(), isAddParent ? container :
				null);
		ButterKnife.bind(this, inflate);
		initView(inflate);
		initListener();
		return inflate;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		bindData();
	}
//绑定数据
	protected void bindData() {
	}

	//初始化监听
	protected void initListener() {
	}

	//在加载布局之前
	protected void initViwBefore() {
	}

	;

	//在加载布局之后
	protected void initView(View inflate) {

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		ButterKnife.unbind(this);
	}

	protected abstract int provideLayoutId();
}
