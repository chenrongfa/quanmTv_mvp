package com.yichen.mmq.ui.attention.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseFragment;
import com.yichen.mmq.base.BasePresenter;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by crf on 2017/9/21.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class AttentionFragment extends BaseFragment {

	@Bind(R.id.iv_back)
	ImageView ivBack;
	@Bind(R.id.tv_title)
	TextView tvTitle;
	@Bind(R.id.iv_message)
	ImageView ivMessage;
	@Bind(R.id.el_recyler_live_list)
	EasyRecyclerView elRecylerLiveList;
	@Bind(R.id.ll_not_login)
	LinearLayout llNotLogin;

	@Override
	protected BasePresenter createPresenter() {
		return null;
	}

	@Override
	protected int provideContentViewId() {
		return R.layout.fragment_attention;
	}

	@Override
	public void initView(View rootView) {
		super.initView(rootView);
		tvTitle.setText("关心");
		ivBack.setBackgroundResource(R.drawable.ic_top_search);
		elRecylerLiveList.setLayoutManager(new LinearLayoutManager(getContext(),
				LinearLayoutManager.VERTICAL,false));

	}

	@OnClick({R.id.iv_back, R.id.tv_title, R.id.iv_message, R.id.ll_not_login})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.iv_back:
				break;
			case R.id.tv_title:
				break;
			case R.id.iv_message:
				break;
			case R.id.ll_not_login:
				break;
		}
	}
}
