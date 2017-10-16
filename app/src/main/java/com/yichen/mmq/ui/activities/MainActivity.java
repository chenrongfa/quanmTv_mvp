package com.yichen.mmq.ui.activities;


import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseActivity;
import com.yichen.mmq.base.BaseFragment;
import com.yichen.mmq.base.BasePresenter;
import com.yichen.mmq.http.api.APIService;
import com.yichen.mmq.ui.attention.fragment.AttentionFragment;
import com.yichen.mmq.ui.index.fragment.IndexFragment;
import com.yichen.mmq.ui.live.fragment.LiveFragment;
import com.yichen.mmq.ui.myinfoandsetting.fragment.MySettingFragment;
import com.yichen.mmq.utils.Translucent;
import com.yichen.mmq.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class MainActivity extends BaseActivity {


	@Bind(R.id.fl_container)
	FrameLayout flContainer;
	@Bind(R.id.rb_index)
	AppCompatRadioButton rbIndex;
	@Bind(R.id.rb_live)
	AppCompatRadioButton rgLive;
	@Bind(R.id.rb_attention)
	AppCompatRadioButton rgAttention;
	@Bind(R.id.rb_mysetting)
	AppCompatRadioButton rgMysetting;
	@Bind(R.id.rg_index)
	RadioGroup rgIndex;
	private List<BaseFragment> baseFragments;
	private BaseFragment currentFragment;
	private FragmentManager fragmentManager;

	@Inject
	APIService appservice;
	@Override
	protected BasePresenter createPresenter() {
		//在使用前先要调用这个注入 放这里非常适合 可以注入bean 也可以注入 presenter
		if (isNeedInject && build != null) {
			build.inject(this);
		}
		Log.e("tt", "createPresenter: "+appservice.toString() );
		return null;
	}


	@Override
	public void initData() {
		fragmentManager = getSupportFragmentManager();
		if (baseFragments == null) {
			baseFragments = new ArrayList<>();

		}
		baseFragments.add(new IndexFragment());
		baseFragments.add(new LiveFragment());
		baseFragments.add(new AttentionFragment());
		baseFragments.add(new MySettingFragment());


	}

	private BaseFragment getFragmentByPosition(int postion) {
		if (postion >= 0 && baseFragments.size() > postion) {
			return baseFragments.get(postion);
		}
		return null;
	}

	private int position = 0;

	@Override
	public void initListener() {
		rgIndex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
				switch (checkedId) {

					case R.id.rb_index:
						position = 0;
						break;
					case R.id.rb_live:
						position = 1;
						break;
					case R.id.rb_attention:
						position = 2;
						break;
					case R.id.rb_mysetting:
						position = 3;
						break;
					default:
						position = 0;
						break;


				}
				//切换 fragment
				swictFragment(currentFragment, getFragmentByPosition(position));
			}
		});
		rbIndex.setChecked(true);
	}

	private void swictFragment(BaseFragment currentFragment, BaseFragment
			nextFragment) {
		if (nextFragment instanceof MySettingFragment){
			Translucent.setStatusColor(this,getResources().getColor(R.color.light_red),10);
		}else{
			Translucent.setStatusColor(this,getResources().getColor(R.color.colorPrimary),0);

		}
		if (nextFragment == null)
			return;
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if (currentFragment != nextFragment) {
			if (nextFragment.isAdded() && nextFragment.isHidden()) {
				transaction.show(nextFragment);
			} else {
				transaction.add(R.id.fl_container, nextFragment);
			}
			if (currentFragment != null) {
				if (currentFragment.isAdded()) {
					transaction.hide(currentFragment);
				}

			}
			transaction.commit();

		}
		this.currentFragment = nextFragment;
	}

	@Override
	protected int provideContentViewId() {
		return R.layout.activity_main;
	}


	public void show(View v) {
		showWaitingDialog("正在加载");
	}

	@Override
	public void onCancel() {
		Log.e("tt", "onCancel: 111");
	}

	@Override
	public void initBeforeContentView() {
		isNeedInject = true;
	}


	private long lastTime;
	private boolean doubleClick;

	@Override
	public void onBackPressed() {

		//两秒内退出
		if (doubleClickEixst())
			return;
		super.onBackPressed();
	}

	private boolean doubleClickEixst() {
		if (!doubleClick) {
			doubleClick = true;
			System.currentTimeMillis();
			lastTime = System.currentTimeMillis();
			Log.e("tt", "onBackPressed: lastTime" + lastTime);
			UIUtils.showToast("两秒内按两次退出");
			return true;
		} else {
			Log.e("tt", "onBackPressed: System.currentTimeMillis();" + System
					.currentTimeMillis());
			if (System.currentTimeMillis() - lastTime > 2000) {
				doubleClick = false;
				lastTime = System.currentTimeMillis();
				return true;
			}
		}
		return false;
	}
}
