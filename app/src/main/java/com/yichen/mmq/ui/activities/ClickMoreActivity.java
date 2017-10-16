package com.yichen.mmq.ui.activities;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.yichen.mmq.Constants;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseActivity;
import com.yichen.mmq.base.BasePresenter;
import com.yichen.mmq.ui.index.fragment.LiveListFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by crf on 2017/9/25.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class ClickMoreActivity extends BaseActivity {
	@Bind(R.id.iv_back)
	ImageView ivBack;
	@Bind(R.id.tv_title)
	TextView tvTitle;
	@Bind(R.id.iv_message)
	ImageView ivMessage;
	@Bind(R.id.fl_click_more)
	FrameLayout flClickMore;
	private LiveListFragment liveFragment;
	@Override
	protected BasePresenter createPresenter() {
		return null;
	}

	@Override
	protected int provideContentViewId() {
		return R.layout.activity_click_more;
	}


	@Override
	public void initView() {
		super.initView();
		String  slug = getIntent().getExtras().getString(Constants.KEY_SLUG);
		String  title = getIntent().getExtras().getString(Constants.KEY_TITLE);
		tvTitle.setText(title+"");
		ivBack.setBackgroundResource(R.drawable.ic_back_dark);
		if (slug!=null){
			Log.e("tt", "initView: +slug"+slug);
		liveFragment=LiveListFragment.newInstance(slug);
		getSupportFragmentManager().beginTransaction().add(R.id.fl_click_more,liveFragment)
		.commit();

		}

	}

	@OnClick({R.id.iv_back, R.id.tv_title, R.id.iv_message})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.iv_back:
				finish();
				break;
			case R.id.tv_title:
				break;
			case R.id.iv_message:
				break;
		}
	}
}
