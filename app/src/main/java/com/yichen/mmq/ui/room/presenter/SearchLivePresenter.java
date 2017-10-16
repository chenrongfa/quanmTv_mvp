package com.yichen.mmq.ui.room.presenter;

import android.util.Log;

import com.yichen.mmq.App;
import com.yichen.mmq.base.BasePresenter;
import com.yichen.mmq.bean.SearchRequestBody;
import com.yichen.mmq.bean.SearchResult;
import com.yichen.mmq.dagger2.scope.FragmentScope;
import com.yichen.mmq.ui.room.view.ISearchView;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */
@FragmentScope
public class SearchLivePresenter extends BasePresenter<ISearchView> {
	@Inject
	public SearchLivePresenter(App app) {
		super(app);
	}

	public void getSearchResult(SearchRequestBody slug){
		getApp().getAppComponent().getApiService().search(slug)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<SearchResult>() {
					@Override
					public void onCompleted() {
						if (isViewAttached()){
							getView().oncompleted();

						}
					}
					@Override
					public void onError(Throwable e) {
						if (isViewAttached()){
							getView().onError(e);

						}
					}

					@Override
					public void onNext(SearchResult info) {
							if (isViewAttached()){
								getView().getSearchResult(info.getData());
								Log.e("tt", "onNext: "+info.toString());
							}
					}
				});


	}
	public void getSearchResult1(SearchRequestBody slug){
		getApp().getAppComponent().getApiService().search1(slug)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<ResponseBody>() {
					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onNext(ResponseBody responseBody) {
						try {
							Log.e("response", "onNext: "+responseBody.string());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});


	}
	public void getSearchMoreResult(SearchRequestBody slug){
		getApp().getAppComponent().getApiService().search(slug)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<SearchResult>() {
					@Override
					public void onCompleted() {
						if (isViewAttached()){
							getView().oncompleted();

						}
					}
					@Override
					public void onError(Throwable e) {
						if (isViewAttached()){
							getView().onError(e);

						}
					}

					@Override
					public void onNext(SearchResult info) {
							if (isViewAttached()){
								getView().getSearchMoreResult(info.getData().getItems());
								Log.e("tt", "onNext: "+info.toString());
							}
					}
				});


	}


}
