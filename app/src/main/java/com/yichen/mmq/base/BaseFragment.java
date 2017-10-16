package com.yichen.mmq.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yichen.mmq.App;
import com.yichen.mmq.dagger2.component.ActivityComponent;
import com.yichen.mmq.dagger2.component.DaggerFragmentComponent;
import com.yichen.mmq.dagger2.component.FragmentComponent;
import com.yichen.mmq.dagger2.module.FragmentModule;

import butterknife.ButterKnife;

public abstract class BaseFragment<V extends BaseView, T extends BasePresenter<V>>
		extends Fragment {

	protected T mPresenter;
	protected boolean isNeedInject=true;//默认开启

	public FragmentComponent getFragmentComponent() {
		return fragmentComponent;
	}

	public void setFragmentComponent(FragmentComponent fragmentComponent) {
		this.fragmentComponent = fragmentComponent;
	}

	protected FragmentComponent fragmentComponent;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		init();
		if (isNeedInject) {
			fragmentComponent = DaggerFragmentComponent.builder().activityComponent
					(getActivityCompoment()).fragmentModule(new FragmentModule(getApp())).build();
		}


		//判断是否使用MVP模式
		mPresenter = createPresenter();
		if (mPresenter != null) {
			mPresenter.attachView((V) this);//因为之后所有的子类都要实现对应的View接口
		}
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {
		//子类不再需要设置布局ID，也不再需要使用ButterKnife.bind()
		View rootView = inflater.inflate(provideContentViewId(), container, false);
		ButterKnife.bind(this, rootView);
		initView(rootView);
		return rootView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();
		initListener();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		ButterKnife.unbind(this);
		if (mPresenter != null) {
			mPresenter.detachView();
		}
	}

	public void init() {

	}

	public void initView(View rootView) {
	}

	public void initData() {

	}

	public App getApp() {
		return (App) getActivity().getApplication();
	}

	public ActivityComponent getActivityCompoment() {
		return ((BaseActivity) getActivity()).getBuild();
	}

	public void initListener() {

	}

	//用于创建Presenter和判断是否使用MVP模式(由子类实现)
	protected abstract T createPresenter();

	//得到当前界面的布局文件id(由子类实现)
	protected abstract int provideContentViewId();
}