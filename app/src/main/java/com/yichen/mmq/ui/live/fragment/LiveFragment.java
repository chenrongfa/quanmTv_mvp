package com.yichen.mmq.ui.live.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.yichen.mmq.Constants;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseFragment;
import com.yichen.mmq.bean.LiveInfo1;
import com.yichen.mmq.ui.activities.PlShowingActivity;
import com.yichen.mmq.ui.activities.PlVideoViewActivity;
import com.yichen.mmq.ui.index.presenter.LivelistPresenter;
import com.yichen.mmq.ui.index.view.ILivelistView;
import com.yichen.mmq.ui.live.adapter.LiveListHolder;
import com.yichen.mmq.ui.live.adapter.LivelistAdater;
import com.yichen.mmq.utils.UIUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by crf on 2017/9/21.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class LiveFragment extends BaseFragment<ILivelistView,LivelistPresenter> implements ILivelistView,LiveListHolder.OnClickPhotoListener {

	@Bind(R.id.iv_back)
	ImageView ivBack;
	@Bind(R.id.tv_title)
	TextView tvTitle;
	@Bind(R.id.iv_message)
	ImageView ivMessage;
	@Bind(R.id.el_recyler_live_list)
	EasyRecyclerView elRecylerLiveList;
	LivelistAdater mLivelistAdater;
	private List<LiveInfo1>  mLiveInfo=new LinkedList<>();
	@Override
	protected LivelistPresenter createPresenter() {
		return new LivelistPresenter(getApp());
	}

	@Override
	public void initListener() {
		super.initListener();
		elRecylerLiveList.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				elRecylerLiveList.showProgress();
				mPresenter.getLiveListResult();
			}
		});
	}

	@Override
	protected int provideContentViewId() {
		return R.layout.fragment_live;
	}

	@Override
	public void initView(View rootView) {
		super.initView(rootView);
		tvTitle.setText("直播");
		ivBack.setBackgroundResource(R.drawable.ic_top_search);
		mLivelistAdater=new LivelistAdater(getContext());
		mLivelistAdater.setOnClickPhotoListener(this);
		SpaceDecoration spaceDecoration=new SpaceDecoration(UIUtils.dip2Px(6));
		elRecylerLiveList.addItemDecoration(spaceDecoration);
		elRecylerLiveList.setAdapter(mLivelistAdater);
		elRecylerLiveList.setLayoutManager(new GridLayoutManager(getContext(),2));
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
	public void initData() {
		super.initData();
		elRecylerLiveList.showProgress();
		mPresenter.getLiveListResult();
	}

	@OnClick({R.id.iv_back, R.id.iv_message})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.iv_back:
				break;
			case R.id.iv_message:
				break;
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
		elRecylerLiveList.setRefreshing(false);
	}

	@Override
	public void onError(Throwable e) {

	}

	@Override
	public void onLiveList(List<LiveInfo1> data) {
		mLivelistAdater.clear();
		mLivelistAdater.addAll(data);
		if (mLivelistAdater.getItemCount()>0){
			mLivelistAdater.notifyDataSetChanged();
		}else{
			elRecylerLiveList.showError();
		}

	}
}
