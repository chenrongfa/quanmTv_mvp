package com.yichen.mmq.base;

import com.yichen.mmq.App;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class BasePresenter<V extends BaseView> {

    /*================== 以下是网络请求接口 ==================*/

    private App app;

    public BasePresenter(App app) {
        this.app=app;

    }

    protected Reference<V> mViewRef;

    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public V getView() {
        return mViewRef != null ? mViewRef.get() : null;
    }

    public App getApp() {
        return app;
    }
}
