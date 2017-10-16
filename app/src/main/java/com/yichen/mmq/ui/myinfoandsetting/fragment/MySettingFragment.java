package com.yichen.mmq.ui.myinfoandsetting.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseFragment;
import com.yichen.mmq.base.BasePresenter;
import com.yichen.mmq.utils.Translucent;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by crf on 2017/9/21.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class MySettingFragment extends BaseFragment {

	@Bind(R.id.iv_me_edit)
	ImageView ivMeEdit;
	@Bind(R.id.iv_me_message)
	ImageView ivMeMessage;
	@Bind(R.id.iv_me_avatar)
	ImageView ivMeAvatar;
	@Bind(R.id.tv_attention_num)
	TextView tvAttentionNum;
	@Bind(R.id.tv_attention)
	TextView tvAttention;
	@Bind(R.id.tv_fan_num)
	TextView tvFanNum;
	@Bind(R.id.tv_fan)
	TextView tvFan;
	@Bind(R.id.tv_gold_num)
	TextView tvGoldNum;
	@Bind(R.id.tv_greed_beam_num)
	TextView tvGreedBeamNum;
	@Bind(R.id.tv_star_light)
	TextView tvStarLight;
	@Bind(R.id.tv_width_draw)
	TextView tvWidthDraw;
	@Bind(R.id.tv_noble)
	TextView tvNoble;
	@Bind(R.id.tv_contribution)
	TextView tvContribution;
	@Bind(R.id.tv_level)
	TextView tvLevel;
	@Bind(R.id.tv_fan_gold)
	TextView tvFanGold;
	@Bind(R.id.tv_task_center)
	TextView tvTaskCenter;
	@Bind(R.id.tv_shop)
	TextView tvShop;
	@Bind(R.id.tv_guessing_coin_shop)
	TextView tvGuessingCoinShop;
	@Bind(R.id.tv_free_liuliang)
	TextView tvFreeLiuliang;
	@Bind(R.id.tv_game)
	TextView tvGame;
	@Bind(R.id.tv_setting)
	TextView tvSetting;
	@Bind(R.id.srl_me_refresh)
	SwipeRefreshLayout srlMeRefresh;

	@Override
	protected BasePresenter createPresenter() {
		return null;
	}

	@Override
	public void init() {
		super.init();
		Translucent.setStatusColor(getActivity(),getResources().getColor(R.color.light_red),10);
	}

	@Override
	protected int provideContentViewId() {
		return R.layout.fragment_mysetting;
	}

	@Override
	public void initView(View rootView) {
		super.initView(rootView);
		Log.e("tt", "initView: srlMeRefresh"+srlMeRefresh.toString() );


	}
 private Handler handler=new Handler(){
	 @Override
	 public void handleMessage(Message msg) {
		 super.handleMessage(msg);
		 srlMeRefresh.setRefreshing(false);
	 }
 };


	@Override
	public void initData() {
		super.initData();

	}

	@Override
	public void initListener() {
		super.initListener();
		srlMeRefresh.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				handler.sendEmptyMessageDelayed(10,1000);
			}
		});
	}

	@OnClick({R.id.iv_me_edit, R.id.iv_me_message, R.id.iv_me_avatar, R.id.tv_attention,
			R.id.tv_fan, R.id.tv_gold_num, R.id.tv_greed_beam_num, R.id.tv_star_light, R
			.id.tv_width_draw, R.id.tv_noble, R.id.tv_contribution, R.id.tv_level, R.id
			.tv_fan_gold, R.id.tv_task_center, R.id.tv_shop, R.id.tv_guessing_coin_shop,
			R.id.tv_free_liuliang, R.id.tv_game, R.id.tv_setting, R.id.srl_me_refresh})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.iv_me_edit:
				break;
			case R.id.iv_me_message:
				break;
			case R.id.iv_me_avatar:
				break;
			case R.id.tv_attention:
				break;
			case R.id.tv_fan:
				break;
			case R.id.tv_gold_num:
				break;
			case R.id.tv_greed_beam_num:
				break;
			case R.id.tv_star_light:
				break;
			case R.id.tv_width_draw:
				break;
			case R.id.tv_noble:
				break;
			case R.id.tv_contribution:
				break;
			case R.id.tv_level:
				break;
			case R.id.tv_fan_gold:
				break;
			case R.id.tv_task_center:
				break;
			case R.id.tv_shop:
				break;
			case R.id.tv_guessing_coin_shop:
				break;
			case R.id.tv_free_liuliang:
				break;
			case R.id.tv_game:
				break;
			case R.id.tv_setting:
				break;
			case R.id.srl_me_refresh:
				break;
		}
	}


}
