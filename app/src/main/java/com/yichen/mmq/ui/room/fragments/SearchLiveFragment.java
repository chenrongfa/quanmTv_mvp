package com.yichen.mmq.ui.room.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.yichen.mmq.Constants;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseFragment;
import com.yichen.mmq.bean.LiveInfo1;
import com.yichen.mmq.bean.SearchRequestBody;
import com.yichen.mmq.bean.SearchResult;
import com.yichen.mmq.ui.activities.PlShowingActivity;
import com.yichen.mmq.ui.activities.PlVideoViewActivity;
import com.yichen.mmq.ui.live.adapter.LiveListHolder;
import com.yichen.mmq.ui.live.adapter.LivelistAdater;
import com.yichen.mmq.ui.room.presenter.SearchLivePresenter;
import com.yichen.mmq.ui.room.view.ISearchView;
import com.yichen.mmq.utils.UIUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by crf on 2017/9/28.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class SearchLiveFragment extends BaseFragment<ISearchView,SearchLivePresenter> implements ISearchView,LiveListHolder.OnClickPhotoListener {
	private SearchRequestBody searchRequestBody;
	public static SearchLiveFragment newInstance(SearchRequestBody searchRequestBody){
		SearchLiveFragment searchFragment=new SearchLiveFragment();
		Bundle args=new Bundle();
		args.putSerializable(Constants.SEARCH_FRAGMENT,searchRequestBody);
		searchFragment.setArguments(args);
		return searchFragment;
	}
	@Override
	protected SearchLivePresenter createPresenter() {
		fragmentComponent.inject(this);
		return  fragmentComponent.getSearchLivePresenter();
	}

	@Bind(R.id.el_recyler_live_list)
	EasyRecyclerView elRecylerLiveList;
	LivelistAdater mLivelistAdater;
	private List<LiveInfo1> mLiveInfo=new LinkedList<>();

	@Override
	public void initListener() {
		super.initListener();
		elRecylerLiveList.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				elRecylerLiveList.showProgress();
				//mPresenter.getLiveListResult();
			}
		});
	}
	private View moreView;
	@Override
	protected int provideContentViewId() {
		return R.layout.fragment_searchlive;
	}

	@Override
	public void initView(View rootView) {
		super.initView(rootView);

		mLivelistAdater=new LivelistAdater(getContext());
		mLivelistAdater.setOnClickPhotoListener(this);
		SpaceDecoration spaceDecoration=new SpaceDecoration(UIUtils.dip2Px(6));
		elRecylerLiveList.addItemDecoration(spaceDecoration);
		elRecylerLiveList.setAdapter(mLivelistAdater);
		elRecylerLiveList.setLayoutManager(new GridLayoutManager(getContext(),2));
		moreView= LayoutInflater.from(getContext()).inflate(R.layout.load_more,null);
		mLivelistAdater.setMore(moreView, new RecyclerArrayAdapter.OnLoadMoreListener() {
			@Override
			public void onLoadMore() {
				if (currentPage>totlePage){
					TextView textView= (TextView) moreView.findViewById(R.id.tv_more);
					textView.setText("已经没有数据了");
				}else {
					searchRequestBody.setPage(currentPage);
					mPresenter.getSearchMoreResult(searchRequestBody);
				}
			}
		});

	}
	//点击直播图片进入房间
	@Override
	public void clickPhotoListener(int uid,boolean isShow) {
		Log.e("crf", "clickPhotoListener: " +uid );
		Intent intent=null;
		if (!isShow){
			UIUtils.showToast("ss"+isShow);
			intent=new Intent(getActivity(), PlVideoViewActivity.class);}
		else{
			intent=new Intent(getActivity(), PlShowingActivity.class);
			UIUtils.showToast("ss"+isShow);
		}
		intent.putExtra(Constants.KEY_UID,uid);
		startActivity(intent);

	}
	@Override
	public void initData() {
		super.initData();
		elRecylerLiveList.showProgress();
		searchRequestBody= (SearchRequestBody) getArguments().get(Constants.SEARCH_FRAGMENT);
		if (searchRequestBody!=null){
			Log.e("tt", "initData: " );
		mPresenter.getSearchResult(searchRequestBody);
			mPresenter.getSearchResult1(searchRequestBody);

		}
	}


	private int currentPage;
	private int totlePage;
//第一次加载;
	@Override
	public void getSearchResult(SearchResult.DataBean string) {
		Log.e("search", "getSearchResult: "+string.toString());
		totlePage = string.getPageNb();
		currentPage++;
		mLivelistAdater.clear();
		mLivelistAdater.addAll(string.getItems());
		if (mLivelistAdater.getItemCount()>0){
			mLivelistAdater.notifyDataSetChanged();
		}else{
			elRecylerLiveList.showError();
		}
	}
//加载更多
	@Override
	public void getSearchMoreResult(List<LiveInfo1> string) {
		currentPage++;
		mLivelistAdater.addAll(string);
		if (mLivelistAdater.getItemCount()>0){
			mLivelistAdater.notifyDataSetChanged();
		}else{
			elRecylerLiveList.showError();
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
		elRecylerLiveList.setRefreshing(false);
	}

	@Override
	public void onError(Throwable e) {
		Log.e("search", "onError: "+e.getMessage() );
	}


}
