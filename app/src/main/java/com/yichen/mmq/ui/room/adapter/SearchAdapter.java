package com.yichen.mmq.ui.room.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yichen.mmq.base.BaseFragment;

import java.util.List;

/**
 * Created by crf on 2017/9/27.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class SearchAdapter extends FragmentPagerAdapter {
	List<String> titles;
	List<BaseFragment> simpleFragments;

	public SearchAdapter(FragmentManager fm, List<String> titles, List<BaseFragment> simpleFragments) {
		super(fm);
		this.titles=titles;
		this.simpleFragments=simpleFragments;
	}

	@Override
	public Fragment getItem(int position) {
		return simpleFragments.get(position);
	}

	@Override
	public int getCount() {
		return simpleFragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titles.get(position);
	}
}
