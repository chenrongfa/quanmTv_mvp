package com.yichen.mmq.ui.room.fragments;

import android.os.Bundle;

import com.yichen.mmq.Constants;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseFragment;
import com.yichen.mmq.base.BasePresenter;
import com.yichen.mmq.bean.SearchRequestBody;

/**
 * Created by crf on 2017/9/28.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class SearchHostFragment extends BaseFragment {

	private SearchRequestBody searchRequestBody;

	public static SearchHostFragment newInstance(SearchRequestBody searchRequestBody){
		SearchHostFragment searchFragment=new SearchHostFragment();
		Bundle args=new Bundle();
		args.putSerializable(Constants.SEARCH_FRAGMENT,searchRequestBody);
		searchFragment.setArguments(args);
		return searchFragment;
	}

	@Override
	protected BasePresenter createPresenter() {
		return null;
	}

	@Override
	protected int provideContentViewId() {
		return R.layout.fragment_search;
	}
}
