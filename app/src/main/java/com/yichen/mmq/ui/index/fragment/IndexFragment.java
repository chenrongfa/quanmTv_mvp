package com.yichen.mmq.ui.index.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseFragment;
import com.yichen.mmq.bean.LiveCategory;
import com.yichen.mmq.ui.activities.SearchActivity;
import com.yichen.mmq.ui.activities.TestCrossActivity;
import com.yichen.mmq.ui.index.adapter.IndexFragmentAdapter;
import com.yichen.mmq.ui.index.presenter.CategoryPresenter;
import com.yichen.mmq.ui.index.view.ICategoryView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by crf on 2017/9/21.
 * company:逸辰
 * qq:952786280
 * feaure: 首页
 */

public class IndexFragment extends BaseFragment<ICategoryView,CategoryPresenter> implements ICategoryView {

	@Bind(R.id.iv_search)
	ImageView ivSearch;
	@Bind(R.id.iv_logo)
	ImageView ivLogo;
	@Bind(R.id.iv_email)
	ImageView ivEmail;
	@Bind(R.id.rl_toolbar)
	RelativeLayout rlToolbar;
	@Bind(R.id.tl_index)
	TabLayout tlIndex;
	@Bind(R.id.vp_index)
	ViewPager vpIndex;
	private List<BaseFragment> baseFragments;
	private List<String> titles;
	private List<LiveCategory> liveCategoryList;
	private IndexFragmentAdapter mIndexFragmentAdapter;
 /*   @Inject
	CategoryPresenter mCategoryPresenter;*/
	@Override
	protected CategoryPresenter createPresenter() {
		fragmentComponent.inject(this);
		return fragmentComponent.getCateGoryPresenter();
	}

	@Override
	protected int provideContentViewId() {

		return R.layout.fragment_index;
	}

	@Override
	public void init() {
		super.init();
		isNeedInject=true;
	}

	@Override
	public void initView(View rootView) {
		super.initView(rootView);


	}

	@Override
	public void initListener() {
		super.initListener();
		tlIndex.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				View customView = tab.getCustomView();
				if (liveCategoryList.size()>=tab.getPosition()&&customView!=null) {
					ImageView imageView = (ImageView)customView.findViewById(R.id.icon);

					Glide.with(getContext()).load(liveCategoryList.get(tab.getPosition()).getIcon_red())
							.diskCacheStrategy(DiskCacheStrategy.ALL)
							.centerCrop()
							.placeholder(R.drawable.btn_gift)
							.into(imageView);
				}
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
				View customView = tab.getCustomView();
				if (liveCategoryList.size()>=tab.getPosition()&&customView!=null) {
					ImageView imageView = (ImageView)customView.findViewById(R.id.icon);

					Glide.with(getContext()).load(liveCategoryList.get(tab.getPosition()).getIcon_gray())
							.diskCacheStrategy(DiskCacheStrategy.ALL)
							.placeholder(R.drawable.btn_gift)
							.centerCrop()
							.into(imageView);
				}
			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}
		});
	}

	@Override
	public void initData() {
		super.initData();
		mPresenter.getAllCategories();
	}

	@OnClick({R.id.iv_search, R.id.iv_logo, R.id.iv_email})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.iv_search:
				Intent intent=new Intent(getActivity(), SearchActivity.class);
				startActivity(intent);
				break;
			case R.id.iv_logo:
				break;
			case R.id.iv_email:
				Intent intent1=new Intent(getActivity(), TestCrossActivity.class);
				startActivity(intent1);
				break;
		}
	}

	@Override
	public void showProgress() {

	}

	@Override
	public void hideProgress() {

	}

	@Override
	public void oncompleted() {

	}

	@Override
	public void onError(Throwable e) {
		Log.e("tt", "onError:111111 " );
	}

	@Override
	public void onSuccess(List<LiveCategory> categoryList) {
		liveCategoryList=categoryList;
		if(baseFragments==null){
			baseFragments=new ArrayList<>();

		}if(titles==null){
			titles=new ArrayList<>();

		}if(titles==null){
			liveCategoryList=new ArrayList<>();
		}
		int i=0;
		for(LiveCategory category:categoryList){

			titles.add(category.getName());
			if (i==0){

				baseFragments.add(new RecommendFragment());
			 }else{
			 	baseFragments.add(LiveListFragment.newInstance(category.getSlug()));
			}
			i++;
		}

		if (mIndexFragmentAdapter==null){
			mIndexFragmentAdapter=new IndexFragmentAdapter(getChildFragmentManager(),baseFragments,
					titles);
			vpIndex.setAdapter(mIndexFragmentAdapter);
			tlIndex.setupWithViewPager(vpIndex);

		}else{
			mIndexFragmentAdapter.notifyDataSetChanged();
		}
		for(int i1=0;i1<tlIndex.getTabCount();i1++){
		Log.e("tt", "onSuccess: "+ categoryList.toString());

			View inflate = LayoutInflater.from(getContext()).inflate(R.layout
					.tab_withicon, null);
			ImageView image= (ImageView) inflate.findViewById(R.id.icon);
			TextView textView= (TextView) inflate.findViewById(R.id.text1);
			textView.setText(liveCategoryList.get(i1).getName());
			tlIndex.getTabAt(i1).setCustomView(inflate);
			Glide.with(getActivity()).load(liveCategoryList.get(i1).getIcon_gray()).centerCrop().placeholder(R.drawable.btn_gift).into(image);
		}

	}

}
