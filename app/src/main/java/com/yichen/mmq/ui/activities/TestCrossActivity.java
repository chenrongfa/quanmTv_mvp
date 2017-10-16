package com.yichen.mmq.ui.activities;

import android.util.Log;

import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseActivity;
import com.yichen.mmq.bean.AppStart;
import com.yichen.mmq.bean.Recommend;
import com.yichen.mmq.ui.index.presenter.RecommentPresenter;
import com.yichen.mmq.ui.index.view.IRecommentView;

import java.util.List;

import javax.inject.Inject;

public class TestCrossActivity extends BaseActivity<IRecommentView,RecommentPresenter> implements IRecommentView {


	@Override
	public void initData() {
		super.initData();
		mPresenter.getRecommendBanner();
	}

	@Override
	public void showProgress() {

	}

	@Override
	public void hideProgress() {

	}

	@Override
	public void oncompleted() {

	}

	@Override
	public void onError(Throwable e) {

	}

	@Override
	public void onRecommendBanner(List<AppStart.AppfocusBean> appfocusBeen) {
		Log.e("tt", "onRecommendBanner: appfocusBeen");
	}

	@Override
	public void onRecommendLiveList(Recommend recommends) {

	}
	@Inject
	RecommentPresenter recommentPresenter;
	@Override
	protected RecommentPresenter createPresenter() {
		build.inject(this);
		return recommentPresenter;
	}

	@Override
	protected int provideContentViewId() {
		return R.layout.activity_test_cross;
	}
}
