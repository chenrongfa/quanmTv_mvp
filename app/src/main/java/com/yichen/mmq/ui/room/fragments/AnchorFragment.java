package com.yichen.mmq.ui.room.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.yichen.mmq.Constants;
import com.yichen.mmq.R;
import com.yichen.mmq.base.SimpleFragment;
import com.yichen.mmq.bean.Room;
import com.yichen.mmq.ui.room.adapter.AnchorAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by crf on 2017/9/27.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class AnchorFragment extends SimpleFragment {
	@Bind(R.id.tl_anchor)
	TabLayout tlAnchor;
	@Bind(R.id.vp_anchor)
	ViewPager vpAnchor;
	private List<SimpleFragment> simpleFragments;
	private List<String> titles;
	private AnchorAdapter mAnchorAdapter;
	Room room;
	@Override
	protected int provideLayoutId() {
		return R.layout.fragment_anchor;
	}

	@Override
	protected void initView(View inflate) {
		super.initView(inflate);
		titles=new ArrayList<>();
		titles.add("聊天");
		titles.add("排行");
		titles.add("贵族");
		titles.add("主播");

		Bundle arguments = getArguments();
		simpleFragments=new ArrayList<>();
		simpleFragments.add(new ChatFragment());
		simpleFragments.add(new RankFragment());
		simpleFragments.add(new NobleFragment());
		simpleFragments.add(HostFragment.newInstance(arguments));
		room = (Room) arguments.getSerializable(Constants.ROOM_FRAGMENT);
		mAnchorAdapter=new AnchorAdapter(getChildFragmentManager(),
				titles,simpleFragments);
		vpAnchor.setAdapter(mAnchorAdapter);
		tlAnchor.setupWithViewPager(vpAnchor);
	}
}
