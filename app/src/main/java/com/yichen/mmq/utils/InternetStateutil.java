package com.yichen.mmq.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.yichen.mmq.base.BaseApp;

/**
 * 网络状态处理 待完善
 * <p>
 * Created by chenrongfa on 2017/3/6
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class InternetStateutil {

	private static InternetStateutil internetStateutil = new InternetStateutil();
	public final int NO_INTERNET = 0;
	public final int MOBILE_INTERNET = 1;
	public final int WIFI_INTERNET = 2;
	public final int CONNECTING = 3;
	public final int DISCONNECTING = 4;
	private InternetStateutil() {
	}

	public static InternetStateutil getInternetStateutil() {
		return internetStateutil;
	}

	/**
	 *  是否已经连接
	 * @return
	 */
	public boolean isConnected() {
		ConnectivityManager connectivityManager = (ConnectivityManager) BaseApp.getContext().getSystemService
				(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		if(activeNetworkInfo!=null){
			return activeNetworkInfo.isConnected();
		}
		return false;
	}

	/**
	 *  是否有效
	 * @return
	 */
	public boolean isAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) BaseApp.getContext().getSystemService
				(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		if(activeNetworkInfo!=null){
			return activeNetworkInfo.isAvailable();
		}
		return false;
	}

	/**
	 *  连接状态
	 * @return
	 */
	public int getInternetstate() {
		ConnectivityManager connectivityManager = (ConnectivityManager) BaseApp.getContext().getSystemService
				(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();


		if (activeNetworkInfo != null) {

			NetworkInfo.State state = activeNetworkInfo.getState();
			if (state == NetworkInfo.State.CONNECTED) {
				if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
					return WIFI_INTERNET;
				} else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
					return MOBILE_INTERNET;
				}

			} else if (NetworkInfo.State.CONNECTING == activeNetworkInfo.getState()) {

				return CONNECTING;
			} else if (NetworkInfo.State.DISCONNECTED == activeNetworkInfo.getState()) {

				return NO_INTERNET;
			} else if (NetworkInfo.State.DISCONNECTING == activeNetworkInfo.getState()) {

				return DISCONNECTING;
			} else
				return NO_INTERNET;


		}
		return NO_INTERNET;


	}

}