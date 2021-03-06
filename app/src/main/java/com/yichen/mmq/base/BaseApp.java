package com.yichen.mmq.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.multidex.MultiDexApplication;
import com.yichen.mmq.utils.LogUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenrongfa on 2017/8/31.
 * QQ:952786280
 * email:18720979339@163.com
 * company:逸臣有限公司
 * function:
 */

	public class BaseApp extends MultiDexApplication {

	public static List<Activity> activities = new LinkedList<>();

	//以下属性应用于整个应用程序，合理利用资源，减少资源浪费
	private static Context mContext;//上下文
	private static Thread mMainThread;//主线程
	private static long mMainThreadId;//主线程id
	private static Looper mMainLooper;//循环队列
	private static Handler mHandler;//主线程Handler

	@Override
	public void onCreate() {
		super.onCreate();

		//对全局属性赋值
		mContext = getApplicationContext();
		mMainThread = Thread.currentThread();
		mMainThreadId = android.os.Process.myTid();
		mHandler = new Handler();
		//是否开启打印日志
		LogUtil.init(true);


	}

	/**
	 * 完全退出
	 * 一般用于“退出程序”功能
	 */
	public static void exit() {
		for (Activity activity : activities) {
			activity.finish();
		}
	}

	/**
	 * 重启当前应用
	 */
	public static void restart() {
		Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		mContext.startActivity(intent);
	}

	public static Context getContext() {
		return mContext;
	}

	public static void setContext(Context mContext) {
		BaseApp.mContext = mContext;
	}

	public static Thread getMainThread() {
		return mMainThread;
	}

	public static void setMainThread(Thread mMainThread) {
		BaseApp.mMainThread = mMainThread;
	}

	public static long getMainThreadId() {
		return mMainThreadId;
	}

	public static void setMainThreadId(long mMainThreadId) {
		BaseApp.mMainThreadId = mMainThreadId;
	}

	public static Looper getMainThreadLooper() {
		return mMainLooper;
	}

	public static void setMainThreadLooper(Looper mMainLooper) {
		BaseApp.mMainLooper = mMainLooper;
	}

	public static Handler getMainHandler() {
		return mHandler;
	}

	public static void setMainHandler(Handler mHandler) {
		BaseApp.mHandler = mHandler;
	}
}
