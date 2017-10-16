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

public class ComplexFragment extends BaseFragment {

	private SearchRequestBody searchRequestBody;

	public static ComplexFragment newInstance(SearchRequestBody searchRequestBody){
		ComplexFragment complexFragment=new ComplexFragment();
		Bundle args=new Bundle();
		args.putSerializable(Constants.SEARCH_FRAGMENT,searchRequestBody);
		complexFragment.setArguments(args);
		return complexFragment;
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
