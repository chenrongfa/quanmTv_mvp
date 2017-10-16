package com.yichen.mmq.ui.index.presenter;

import com.yichen.mmq.App;
import com.yichen.mmq.base.BasePresenter;
import com.yichen.mmq.bean.LiveInfo1;
import com.yichen.mmq.bean.LiveListResult;
import com.yichen.mmq.dagger2.scope.FragmentScope;
import com.yichen.mmq.ui.index.view.ILivelistView;

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
@FragmentScope
public class LivelistPresenter extends BasePresenter<ILivelistView> {
	@Inject
	public LivelistPresenter(App app) {
		super(app);
	}

	public void getLiveListResult(String slug){
		getApp().getAppComponent().getApiService().getLiveListResultByCategories(slug)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.map(new Func1<LiveListResult, List<LiveInfo1>>() {
					@Override
					public List<LiveInfo1>
					call(LiveListResult liveListResult) {
						return liveListResult.getData();
					}
				})
				.subscribe(new Subscriber<List<LiveInfo1>>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onNext(List<LiveInfo1> info) {
							if (isViewAttached()){
								getView().onLiveList(info);
							}
					}
				});


	}
	public void getLiveListResult(){
		getApp().getAppComponent().getApiService().getLiveListResult()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.map(new Func1<LiveListResult, List<LiveInfo1>>() {
					@Override
					public List<LiveInfo1>
					call(LiveListResult liveListResult) {
						return liveListResult.getData();
					}
				})
				.subscribe(new Subscriber<List<LiveInfo1>>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onNext(List<LiveInfo1> info) {
							if (isViewAttached()){
								getView().onLiveList(info);
							}
					}
				});


	}

}
