package com.yichen.mmq.ui.room.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.yichen.mmq.Constants;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseFragment;
import com.yichen.mmq.base.SimpleFragment;
import com.yichen.mmq.bean.SearchRequestBody;
import com.yichen.mmq.ui.room.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by crf on 2017/9/28.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class SearchFragment extends SimpleFragment {
	@Bind(R.id.tl_search)
	TabLayout tlSearch;
	@Bind(R.id.vp_search)
	ViewPager vpSearch;
	private List<String> titles;
	private List<BaseFragment> baseFragments;
	private SearchRequestBody searchRequestBody;
	private SearchAdapter mSearchAdapter;

	public static SearchFragment newInstance(SearchRequestBody searchRequestBody){
		SearchFragment searchFragment=new SearchFragment();
		Bundle args=new Bundle();
		args.putSerializable(Constants.SEARCH_FRAGMENT,searchRequestBody);
		searchFragment.setArguments(args);
		return searchFragment;
	}
	@Override
	protected int provideLayoutId() {
		return R.layout.fragment_search;
	}

	@Override
	protected void initView(View inflate) {
		super.initView(inflate);
		titles=new ArrayList<>();
		titles.add("综合");
		titles.add("主播");
		titles.add("直播");
		searchRequestBody= (SearchRequestBody) getArguments().getSerializable(Constants.SEARCH_FRAGMENT);
		if (searchRequestBody!=null){
			Log.e("search", "initView: "+searchRequestBody);
			baseFragments=new ArrayList<>();
			baseFragments.add(ComplexFragment.newInstance(searchRequestBody));
			baseFragments.add(SearchHostFragment.newInstance(searchRequestBody));
			baseFragments.add(SearchLiveFragment.newInstance(searchRequestBody));
			mSearchAdapter=new SearchAdapter(getChildFragmentManager(),
					titles,baseFragments);
			vpSearch.setAdapter(mSearchAdapter);
			tlSearch.setupWithViewPager(vpSearch);
			vpSearch.setCurrentItem(titles.size()-1);

		}
	}
}
