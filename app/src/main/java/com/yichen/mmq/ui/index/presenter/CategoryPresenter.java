package com.yichen.mmq.ui.index.presenter;

import android.util.Log;

import com.yichen.mmq.App;
import com.yichen.mmq.base.BasePresenter;
import com.yichen.mmq.bean.LiveCategory;
import com.yichen.mmq.dagger2.scope.FragmentScope;
import com.yichen.mmq.ui.index.view.ICategoryView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by crf on 2017/9/21.
 * company:逸辰
 * qq:952786280
 * feature:
 */
@FragmentScope
public class CategoryPresenter extends BasePresenter<ICategoryView> {
   @Inject
	public CategoryPresenter(App app) {
		super(app);
	}

	public void getAllCategories(){
			getApp().getAppComponent().getApiService().getAllCategories().observeOn
					(AndroidSchedulers.mainThread())
					.subscribeOn(Schedulers.io())
					.subscribe(new Subscriber<List<LiveCategory>>() {
						@Override
						public void onCompleted() {
							if (isViewAttached())
								getView().oncompleted();
						}
						@Override
						public void onError(Throwable e) {
							if (isViewAttached())
								getView().onError(e);

							Log.e("tt", "onError: "+e.getMessage());
						}
						@Override
						public void onNext(List<LiveCategory> liveCategories) {
							if (isViewAttached()){
								Collections.sort(liveCategories, new Comparator<LiveCategory>() {
									@Override
									public int compare(LiveCategory o1, LiveCategory o2) {

										return o1.getId()-o2.getId();
									}
								});
								getView().onSuccess(liveCategories);

							}
						}
					});

	}
}
