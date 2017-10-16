package com.yichen.mmq.ui.activities;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseActivity;
import com.yichen.mmq.base.BasePresenter;

import butterknife.Bind;

/**
 * Created by crf on 2017/9/21.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class SplashActivity extends BaseActivity {

	@Bind(R.id.rl_splash)
	RelativeLayout rlSplash;

	@Override
	protected BasePresenter createPresenter() {
		return null;
	}

	@Override
	protected int provideContentViewId() {
		return R.layout.activiti_splash;
	}

	@Override
	public void initListener() {
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_splash);
		animation.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
					jumpToActivity(MainActivity.class,true);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
		rlSplash.startAnimation(animation);
	}
}
