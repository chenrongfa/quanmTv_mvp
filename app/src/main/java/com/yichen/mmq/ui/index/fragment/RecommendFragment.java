package com.yichen.mmq.ui.index.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.yichen.mmq.Constants;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseFragment;
import com.yichen.mmq.bean.AppStart;
import com.yichen.mmq.bean.Recommend;
import com.yichen.mmq.ui.activities.ClickMoreActivity;
import com.yichen.mmq.ui.activities.PlShowingActivity;
import com.yichen.mmq.ui.activities.PlVideoViewActivity;
import com.yichen.mmq.ui.index.adapter.RecommentAdater;
import com.yichen.mmq.ui.index.adapter.RecommentChildHolder;
import com.yichen.mmq.ui.index.adapter.RecommentHolder;
import com.yichen.mmq.ui.index.presenter.RecommentPresenter;
import com.yichen.mmq.ui.index.view.IRecommentView;
import com.yichen.mmq.utils.InternetStateutil;
import com.yichen.mmq.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by crf on 2017/9/21.
 * company:逸辰
 * qq:952786280
 * feature: 推荐
 */

public class RecommendFragment extends BaseFragment<IRecommentView,RecommentPresenter> implements IRecommentView ,RecommentHolder.OnClickMoreListener
,RecommentChildHolder.OnClickPhotoListener{
	@Bind(R.id.el_recyler)
	EasyRecyclerView elRecyler;
	private TextView tv_error;
	private TextView tv_empty;
	private ConvenientBanner<AppStart.AppfocusBean> banner;
	private RecommentAdater mRecommentAdater;
	private List<Recommend.RoomBean> mRecommendDatas = new ArrayList<>();
	private List<AppStart.AppfocusBean> bannerData=new ArrayList<>();
	@Override
	protected RecommentPresenter createPresenter() {
		fragmentComponent.inject(this);
		return fragmentComponent.getRecommendpresenter();
	}

	@Override
	protected int provideContentViewId() {
		return R.layout.fragment_recomment;
	}

	@Override
	public void initView(View rootView) {
		super.initView(rootView);

		mRecommentAdater = new RecommentAdater(getContext(), mRecommendDatas,this);
		mRecommentAdater.setOnPhotoClickListener(this);
		mRecommentAdater.addHeader(new HeaderView(bannerData));
		elRecyler.setAdapter(mRecommentAdater);
		elRecyler.setLayoutManager(new LinearLayoutManager(getContext(),
				LinearLayoutManager.VERTICAL,false));

		tv_error = (TextView) elRecyler.getErrorView().findViewById(R.id.tv_error);
		tv_empty = (TextView) elRecyler.getErrorView().findViewById(R.id.tv_error);
	}

	@Override
	public void initListener() {
		super.initListener();
		elRecyler.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				mPresenter.getRecommendLivelist();
			}
		});
	}

	@Override
	public void initData() {
		super.initData();
		elRecyler.showProgress();
		mPresenter.getRecommendLivelist();
		mPresenter.getRecommendBanner();
	}

	@Override
	public void showProgress() {

	}

	@Override
	public void hideProgress() {

	}

	@Override
	public void oncompleted() {

		elRecyler.setRefreshing(false);
	}

	@Override
	public void onError(Throwable e) {

		Log.e("tt", "onError: "+e.getMessage() );
	//	if ()
		if (InternetStateutil.getInternetStateutil().isAvailable()){
			tv_error.setText("无有效网络");
			elRecyler.showError();
		}else if(InternetStateutil.getInternetStateutil().NO_INTERNET==InternetStateutil.getInternetStateutil().NO_INTERNET){
			tv_error.setText("没有网络");
			elRecyler.showError();
		}

	}

	@Override
	public void onRecommendBanner(List<AppStart.AppfocusBean> appfocusBeen) {
		bannerData.clear();
		bannerData.addAll(appfocusBeen);

		if (banner!=null){
			Log.e("tt", "onRecommendBanner: "+bannerData.toString());
		    banner.notifyDataSetChanged();
			mRecommentAdater.notifyDataSetChanged();
		}
	}

	@Override
	public void onRecommendLiveList(Recommend recommends) {
		/* mRecommendDatas.clear();
		 mRecommendDatas.addAll(recommends.getRoom());*/
		mRecommentAdater.clear();
		mRecommentAdater.addAll(recommends.getRoom());
		Log.e("tt", "onRecommendBanner: "+recommends.toString());
		mRecommentAdater.notifyDataSetChanged();
		if (banner!=null){
			Log.e("tt", "onRecommendBanner: ");
			banner.notifyDataSetChanged();
		}
		if (mRecommentAdater.getCount()==0){
			elRecyler.showEmpty();
		}
	}
	//点击更多回调
	@Override
	public void clickMoreListener(Recommend.RoomBean data) {
		Intent intent=new Intent(getActivity(), ClickMoreActivity.class
		);
		Bundle bundle=new Bundle();
		bundle.putString(Constants.KEY_TITLE,data.getName());
		bundle.putString(Constants.KEY_SLUG,data.getSlug());
		intent.putExtras(bundle);
		startActivity(intent);

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

	class HeaderView implements RecyclerArrayAdapter.ItemView{
		private List<AppStart.AppfocusBean> data;
		public HeaderView(List<AppStart.AppfocusBean> data){
			this.data=data;
		}
		@Override
		public View onCreateView(ViewGroup parent) {
			View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout
					.recommend_banner,parent,false

			);
			banner = (ConvenientBanner) inflate.findViewById(R.id
					.cb_banner);
			banner.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(int position) {
					clickBannerItem(position);
				}
			});
			return inflate;
		}

		@Override
		public void onBindView(final View headerView) {
			Log.e("crf", "onBindView: " );
			banner.setPages(new CBViewHolderCreator() {
				@Override
				public Holder<AppStart.AppfocusBean> createHolder() {
					return new ImageHolder(headerView.getContext());
				}
			},data).setPageIndicator(new int[]{R.drawable.ic_dot_normal,R.drawable.ic_dot_pressed})
					.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);

			if(!banner.isTurning()){
				banner.startTurning(4000);
			}

		}
	}
	//点击banner item 事件
	private void clickBannerItem(int position) {
		if(bannerData!=null&&bannerData.size()>=position){
			AppStart.AppfocusBean appfocusBean = bannerData.get(position);
			String type =appfocusBean.getExt().getType();
			if ("play".equals(type)){
				startRoom();
			}else{

				startWeb(appfocusBean.getLink());
			}


		}

	}
//进入网页引擎
	private void startWeb(String url) {
		UIUtils.showToast("web"+url);
	}

	//进入房间
	private void startRoom() {
		UIUtils.showToast("room");

	}

	@Override
	public void onResume() {
		super.onResume();
		if (banner!=null&&!banner.isTurning()){
			Log.e("tt", "onResume:banner ");
			banner.startTurning(4000);
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		if (banner!=null&&banner.isTurning()){
			Log.e("tt", "onPause:banner ");
			banner.stopTurning();
		}
	}

	public class ImageHolder implements  Holder<AppStart.AppfocusBean>{

		ImageView imageView;
		View inflate;
	public 	ImageHolder(Context context){

		inflate = LayoutInflater.from(context).inflate(R.layout.banner, banner,false);
		imageView= (ImageView) inflate.findViewById(R.id.iv_banner);
	}
		@Override
		public View createView(Context context) {
			/*imageView=new ImageView(context);
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);*/

			Log.e("crf", "createView: "+imageView );
			return inflate;
		}
		@Override
		public void UpdateUI(Context context, int position, AppStart.AppfocusBean data) {
			Log.e("tt", "UpdateUI: "+data.getThumb() );
			Glide.with(context).load(data.getThumb()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.ic_mine_push_start).centerCrop().into(imageView);
		}
	}
}
