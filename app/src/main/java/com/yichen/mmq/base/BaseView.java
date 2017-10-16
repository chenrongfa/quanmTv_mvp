package com.yichen.mmq.base;

/**
 * Created by crf on 2017/9/20.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public interface BaseView {
	void showProgress();
	void hideProgress();
	void oncompleted();
	void onError(Throwable e);
}
