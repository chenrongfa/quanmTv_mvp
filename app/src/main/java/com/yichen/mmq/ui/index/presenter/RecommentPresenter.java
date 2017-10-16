package com.yichen.mmq.ui.index.presenter;

import com.yichen.mmq.App;
import com.yichen.mmq.base.BasePresenter;
import com.yichen.mmq.bean.AppStart;
import com.yichen.mmq.bean.Recommend;
import com.yichen.mmq.ui.index.view.IRecommentView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class RecommentPresenter extends BasePresenter<IRecommentView> {
	@Inject
	public RecommentPresenter(App app) {
		super(app);
	}

	public void getRecommendBanner(){
		getApp().getAppComponent().getApiService().getAppStartInfo()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.map(new Func1<AppStart, List<AppStart.AppfocusBean>>() {
					@Override
					public List<AppStart.AppfocusBean> call(AppStart appstart) {
						return appstart.getAppfocus();
					}
				}).subscribe(new Subscriber<List<AppStart.AppfocusBean>>() {
			@Override
			public void onCompleted() {
				if (isViewAttached())
					getView().oncompleted();
			}
			@Override
			public void onError(Throwable e) {
				if (isViewAttached())
					getView().onError(e);
			}

			@Override
			public void onNext(List<AppStart.AppfocusBean> appfocusBeen) {
				if (isViewAttached())
					getView().onRecommendBanner(appfocusBeen);
			}
		});
	}
	public void getRecommendLivelist(){
		getApp().getAppComponent().getApiService().getRecommend()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<Recommend>() {
					@Override
					public void onCompleted() {
						if (isViewAttached())
							getView().oncompleted();
					}
					@Override
					public void onError(Throwable e) {
						if (isViewAttached())
							getView().onError(e);
					}

					@Override
					public void onNext(Recommend appfocusBeen) {
						if (isViewAttached())
							getView().onRecommendLiveList(appfocusBeen);
					}
				});
	}
}
