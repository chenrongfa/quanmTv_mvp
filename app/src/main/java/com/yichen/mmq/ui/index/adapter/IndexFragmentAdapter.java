package com.yichen.mmq.ui.index.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yichen.mmq.base.BaseFragment;

import java.util.List;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class IndexFragmentAdapter extends FragmentPagerAdapter {
	private List<BaseFragment> mBaseFragments;
	private List<String> mTitle;
	public IndexFragmentAdapter(FragmentManager fm, List<BaseFragment> baseFragments,List<String> title) {
		super(fm);
		mBaseFragments=baseFragments;
		mTitle=title;
	}

	@Override
	public Fragment getItem(int position) {
		return mBaseFragments.get(position);
	}

	@Override
	public int getCount() {
		return mBaseFragments.size();
	}

	/*@Override
	public CharSequence getPageTitle(int position) {
		return mTitle.get(position);
	}*/
}
