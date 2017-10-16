package com.yichen.mmq.ui.room.fragments;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yichen.mmq.Constants;
import com.yichen.mmq.R;
import com.yichen.mmq.base.SimpleFragment;
import com.yichen.mmq.bean.Room;
import com.yichen.mmq.utils.DecimalUtil;

import butterknife.Bind;

/**
 * Created by crf on 2017/9/27.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class HostFragment extends SimpleFragment {
	@Bind(R.id.iv_avatar)
	ImageView ivAvatar;
	@Bind(R.id.tv_host_nick)
	TextView tvHostNick;
	@Bind(R.id.tv_host_uid)
	TextView tvHostUid;
	@Bind(R.id.tv_fan_num)
	TextView tvFanNum;
	@Bind(R.id.tv_fight_value)
	TextView tvFightValue;
	@Bind(R.id.iv_follow)
	ImageView ivFollow;
	@Bind(R.id.tv_age)
	TextView tvAge;
	@Bind(R.id.tv_affective_State)
	TextView tvAffectiveState;
	@Bind(R.id.tv_location)
	TextView tvLocation;
	@Bind(R.id.tv_occupation)
	TextView tvOccupation;
	@Bind(R.id.tv_ad)
	TextView tvAd;
	Room room;

	@Override
	protected int provideLayoutId() {
		return R.layout.fragment_host;
	}

	public static HostFragment newInstance(Bundle args){
		HostFragment hostFragment=new HostFragment();
		hostFragment.setArguments(args);
		return hostFragment;

	}

	@Override
	protected void bindData() {
		super.bindData();
		room= (Room) getArguments().getSerializable(Constants.ROOM_FRAGMENT);
		if (room!=null){
		Glide.with(this).load(room.getAvatar()).diskCacheStrategy(DiskCacheStrategy.ALL)
				.centerCrop()
				.into(ivAvatar);
			tvHostNick.setText(room.getNick());
			tvHostUid.setText(room.getUid()+"");
			tvFanNum.setText(room.getFollow()+"");
			tvFightValue.setText(DecimalUtil.getInstance().formatNumber(room.getWeight()/100+""));

			String announcement = room.getAnnouncement();
			if (announcement !=null){
				tvAd.setText(announcement);
			}
		}
	}
}
