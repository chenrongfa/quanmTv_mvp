package com.yichen.mmq.ui.index.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.yichen.mmq.Constants;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseFragment;
import com.yichen.mmq.bean.LiveInfo1;
import com.yichen.mmq.ui.activities.PlShowingActivity;
import com.yichen.mmq.ui.activities.PlVideoViewActivity;
import com.yichen.mmq.ui.index.adapter.LiveListHolder;
import com.yichen.mmq.ui.index.adapter.LivelistAdater;
import com.yichen.mmq.ui.index.presenter.LivelistPresenter;
import com.yichen.mmq.ui.index.view.ILivelistView;
import com.yichen.mmq.utils.UIUtils;

import java.util.List;

/**
 * Created by crf on 2017/9/21.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class LiveListFragment extends BaseFragment<ILivelistView,LivelistPresenter> implements ILivelistView
,LiveListHolder.OnClickPhotoListener {
	@Override
	protected LivelistPresenter createPresenter() {
		fragmentComponent.inject(this);
		return fragmentComponent.getLivelistPresenter();
	}
	private EasyRecyclerView el_recyler_live_list;
	private LivelistAdater mLivelistAdater;
	@Override
	public void initView(View rootView) {
		super.initView(rootView);
		el_recyler_live_list= (EasyRecyclerView) rootView.findViewById(R.id.el_recyler_live_list);
		mLivelistAdater=new LivelistAdater(getContext());
		mLivelistAdater.setOnClickPhotoListener(this);
		SpaceDecoration spaceDecoration=new SpaceDecoration(UIUtils.dip2Px(10));
		el_recyler_live_list.addItemDecoration(spaceDecoration);
		el_recyler_live_list.setAdapter(mLivelistAdater);
		el_recyler_live_list.setLayoutManager(new GridLayoutManager(getContext(),2));

	}

	@Override
	public void initListener() {
		super.initListener();
		el_recyler_live_list.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				mPresenter.getLiveListResult(slug);
			}
		});
	}
	//点击直播图片进入房间
	@Override
	public void clickPhotoListener(int uid,boolean isShow) {
		Log.e("crf", "clickPhotoListener: " +uid );
		Intent intent=null;
		if (!isShow){
			UIUtils.showToast("ss"+isShow);
			intent=new Intent(getActivity(), PlVideoViewActivity.class);}
		else{
			intent=new Intent(getActivity(), PlShowingActivity.class);
			UIUtils.showToast("ss"+isShow);
		}
		intent.putExtra(Constants.KEY_UID,uid);
		startActivity(intent);

	}
	@Override
	protected int provideContentViewId() {
		return R.layout.fragment_livelist;
	}
	private String slug;
	public static LiveListFragment newInstance(String slug){
		LiveListFragment mLiveListFragment=new LiveListFragment();
		Bundle args=new Bundle();
		args.putString(Constants.KEY_SLUG,slug);
		mLiveListFragment.setArguments(args);
		return mLiveListFragment;
	}

	@Override
	public void initData() {
		super.initData();
		slug=getArguments().getString(Constants.KEY_SLUG);
		if (slug!=null){
		el_recyler_live_list.showProgress();
		mPresenter.getLiveListResult(slug);
		}else{
			el_recyler_live_list.showError();
		}
	}

	@Override
	public void showProgress() {

	}

	@Override
	public void hideProgress() {

	}

	@Override
	public void oncompleted() {
		el_recyler_live_list.setRefreshing(false);
	}

	@Override
	public void onError(Throwable e) {
		el_recyler_live_list.showError();
	}

	@Override
	public void onLiveList(List<LiveInfo1> data) {
		mLivelistAdater.clear();
		mLivelistAdater.addAll(data);
		if (mLivelistAdater.getItemCount()==0){
			el_recyler_live_list.showEmpty();

		}else{
			mLivelistAdater.notifyDataSetChanged();
		}

	}
}
