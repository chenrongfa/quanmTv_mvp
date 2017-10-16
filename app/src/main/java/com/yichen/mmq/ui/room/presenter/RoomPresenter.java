package com.yichen.mmq.ui.room.presenter;

import com.yichen.mmq.App;
import com.yichen.mmq.base.BasePresenter;
import com.yichen.mmq.bean.Room;
import com.yichen.mmq.dagger2.scope.ActivityScope;
import com.yichen.mmq.ui.room.view.IRoomView;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by crf on 2017/9/26.
 * company:逸辰
 * qq:952786280
 * feature:
 */
@ActivityScope
public class RoomPresenter  extends BasePresenter<IRoomView>{
	@Inject
	public RoomPresenter(App app) {
		super(app);
	}

	public void getRoom(int uid){
		getApp().getAppComponent().getApiService()
				.enterRoom(uid+"")
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<Room>() {
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
					public void onNext(Room room) {
						if (isViewAttached())
							getView().OnRoomListener(room);
					}
				});

	}
}
