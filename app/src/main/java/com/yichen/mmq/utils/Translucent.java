package com.yichen.mmq.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.yichen.mmq.R;

/**
 * Created by chenrongfa on 2017/9/1.
 * QQ:952786280
 * email:18720979339@163.com
 * company:逸臣有限公司
 * function: 沉浸式
 */
public class Translucent {
	public static final int FAKE_STATUS_BAR_VIEW_ID = R.id.statusbarutil_fake_status_bar_view;
	public static final int FAKE_NAVIAGATE_BAR_VIEW_ID = R.id.navigate_view_id;

	/**
	 *  适合 coordinatorLayout和appBarLayout组合
	 * @param activity
	 * @param toolbar
	 * @param coordinatorLayout
	 * @param appBarLayout
	 */
	public static void statusBarCoverWithImage(AppCompatActivity activity, Toolbar toolbar,
	                                           CoordinatorLayout coordinatorLayout,AppBarLayout
			                                           appBarLayout){
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
			activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			coordinatorLayout.setFitsSystemWindows(false);
			coordinatorLayout.setClipToPadding(false);
			appBarLayout.setFitsSystemWindows(false);
			ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
			int statusBarHeight = getStatusBarHeight(activity);
			//并未完全塌陷进去
			params.topMargin += statusBarHeight/2;
			toolbar.setLayoutParams(params);
			/*toolbar.setPadding(
					toolbar.getPaddingLeft(),
					toolbar.getPaddingTop()+getStatusBarHeight1(getActivity()),
					toolbar.getPaddingRight(),
					toolbar.getPaddingBottom());*/
		}
	}

	/**
	 *  判断是否有 底部虚拟导航
	 * @param wm
	 * @return
	 */
	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
	private static boolean hasNavigationBarShow(WindowManager wm){
		Display display = wm.getDefaultDisplay();
		DisplayMetrics outMetrics = new DisplayMetrics();
		//获取整个屏幕的高度
		display.getRealMetrics(outMetrics);
		int heightPixels = outMetrics.heightPixels;
		int widthPixels = outMetrics.widthPixels;
		//获取内容展示部分的高度
		outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);
		int heightPixels2 = outMetrics.heightPixels;
		int widthPixels2 = outMetrics.widthPixels;
		int w = widthPixels-widthPixels2;
		int h = heightPixels-heightPixels2;
		System.out.println("~~~~~~~~~~~~~~~~h:"+h);
		return  w>0||h>0;//竖屏和横屏两种情况。
	}
	private static int getNavigationBarHeight(Context context) {
		return getSystemComponentDimen(context, "navigation_bar_height");
	}

	/**
	 * 获取状态栏的高度
	 * @param context
	 * @return
	 */
	private  static int getStatusBarHeight(Context context) {
		// 反射手机运行的类：android.R.dimen.status_bar_height.
		return getSystemComponentDimen(context, "status_bar_height");
	}

	private static int getSystemComponentDimen(Context context, String dimenName){
		// 反射手机运行的类：android.R.dimen.status_bar_height.
		int statusHeight = -1;
		try {
			Class<?> clazz = Class.forName("com.android.internal.R$dimen");
			Object object = clazz.newInstance();
			String heightStr = clazz.getField(dimenName).get(object).toString();
			//这是id 不是dp
			int height = Integer.parseInt(heightStr);
			//dp--->px
			statusHeight = context.getResources().getDimensionPixelSize(height);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusHeight;
	}
	/**
	 * 设置状态栏颜色
	 *
	 * @param activity       需要设置的activity
	 * @param color          状态栏颜色值
	 * @param statusBarAlpha 状态栏透明度
	 */

	public static void setStatusColor(Activity activity, @ColorInt int color, int statusBarAlpha) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			activity.getWindow().setStatusBarColor(calculateStatusColor(color, statusBarAlpha));
		} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
			View fakeStatusBarView = decorView.findViewById(FAKE_STATUS_BAR_VIEW_ID);
			if (fakeStatusBarView != null) {
				if (fakeStatusBarView.getVisibility() == View.GONE) {
					fakeStatusBarView.setVisibility(View.VISIBLE);
				}
				fakeStatusBarView.setBackgroundColor(calculateStatusColor(color, statusBarAlpha
						));
			} else {
				decorView.addView(createStatusBarView(activity, color, statusBarAlpha,getStatusBarHeight(activity)));
			}
			setRootView(activity);
		}
	}

	/**
	 *   设置虚拟导航栏 颜色

	 * @param activity
	 * @param color
	 * @param statusBarAlpha
	 */
	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
	public static void setNavigateColor( Activity activity, @ColorInt int color, int
			statusBarAlpha) {

		if (hasNavigationBarShow(activity.getWindowManager())) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
				activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
				activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
				activity.getWindow().setNavigationBarColor(calculateStatusColor(color, statusBarAlpha));
			}
			else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
			{
				activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
				ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
				//这个需要 第一个布局容器 设置颜色 不然就是虚拟导航栏设置的颜色
				//decorView.setBackgroundColor(calculateStatusColor(color,statusBarAlpha));
				View navigate = decorView.findViewById(FAKE_NAVIAGATE_BAR_VIEW_ID);
				if (navigate!=null){
					if (navigate.getVisibility()==View.GONE){
						navigate.setVisibility(View.VISIBLE);
					}
					navigate.setBackgroundColor(calculateStatusColor(color,statusBarAlpha));
				}else{
					View navigateView = createNavigateView(activity, color,
					statusBarAlpha, getNavigationBarHeight(activity));
					decorView.addView(navigateView);
					navigateView.setBackgroundColor(calculateStatusColor(color,statusBarAlpha));
				}
				setRootView(activity);


			}
		}
	}

	/**
	 * 设置根布局参数 腾出空位
	 */
	private static void setRootView(Activity activity) {
		ViewGroup parent = (ViewGroup) activity.findViewById(android.R.id.content);
		for (int i = 0, count = parent.getChildCount(); i < count; i++) {
			View childView = parent.getChildAt(i);
			if (childView instanceof ViewGroup) {
				childView.setFitsSystemWindows(true);
				((ViewGroup) childView).setClipToPadding(true);
			}
		}
	}
	//隐藏 底部导航栏和状态栏
	public static void hideOrShowAll(Activity activity,boolean hide){
		View decorView = activity.getWindow().getDecorView();
		View navigate = decorView.findViewById(FAKE_NAVIAGATE_BAR_VIEW_ID);
		View status = decorView.findViewById(FAKE_STATUS_BAR_VIEW_ID);

		if (navigate!=null){
			navigate.setVisibility(hide?View.GONE:View.VISIBLE);

		}
		if (status!=null){
			status.setVisibility(hide?View.GONE:View.VISIBLE);

		}



	}
	//隐藏 底部导航栏和状态栏
	public static void hideOrShowPersonal(Activity activity,boolean statusHide,boolean navigateHide){
		View decorView = activity.getWindow().getDecorView();
		View navigate = decorView.findViewById(FAKE_NAVIAGATE_BAR_VIEW_ID);
		View status = decorView.findViewById(FAKE_STATUS_BAR_VIEW_ID);

		if (navigate!=null){
			navigate.setVisibility(navigateHide?View.GONE:View.VISIBLE);

		}
		if (status!=null){
			status.setVisibility(statusHide?View.GONE:View.VISIBLE);

		}



	}
	/**
	 * 生成一个半透明的一个状态栏(障眼法)
	 *
	 * @param activity
	 * @param color
	 * @param alpha
	 * @param height
	 * @return
	 */
	private static View createStatusBarView(Activity activity, @ColorInt int color, int
			alpha,int height
	                                                 ) {
		// 绘制一个和状态栏一样高的矩形
		View statusBarView = new View(activity);
		FrameLayout.LayoutParams params =
				new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
		statusBarView.setLayoutParams(params);
		statusBarView.setBackgroundColor(calculateStatusColor(color, alpha));
		statusBarView.setId(FAKE_STATUS_BAR_VIEW_ID);
		return statusBarView;
	}

	/**
	 *   生成底部导航栏
	 * @param activity
	 * @param color
	 * @param alpha
	 * @param height
	 * @return
	 */

	private static View createNavigateView(Activity activity, @ColorInt int color, int
			alpha, int height
	                                                 ) {
		// 绘制一个和状态栏一样高的矩形
		View navigateBarView = new View(activity);
		FrameLayout.LayoutParams params =
				new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);

		params.gravity= Gravity.BOTTOM;
		/*params.topMargin+=height;
		navigateBarView.setPadding(0,0,0,height);*/
		Log.e("ihao", "createNavigateView: 1" );
		/*if (Build.VERSION.SDK_INT<Build.VERSION_CODES.KITKAT&&Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1) {
			Log.e("ihao", "createNavigateView: 2" );
			WindowManager wm = activity.getWindowManager();
			Display display = wm.getDefaultDisplay();
			DisplayMetrics outMetrics = new DisplayMetrics();
			//获取整个屏幕的高度
			View viewById = activity.getWindow().getDecorView().findViewById(android.R
					.id.content);
			display.getRealMetrics(outMetrics);
			int heightPixels = outMetrics.heightPixels;
			navigateBarView.setY(20);
			//View parent = (View) navigateBarView.getParent();
			//parent.scrollBy(0,height);
		}*/

		navigateBarView.setLayoutParams(params);
		navigateBarView.setBackgroundColor(calculateStatusColor(color, alpha));
		navigateBarView.setId(FAKE_NAVIAGATE_BAR_VIEW_ID);
		return navigateBarView;
	}
	/**
	 * 计算状态栏颜色
	 *
	 * @param color color值
	 * @param alpha alpha值
	 * @return 最终的状态栏颜色
	 */
	private static int calculateStatusColor(@ColorInt int color, int alpha) {
		if (alpha == 0) {
			return color;
		}
		float a = 1 - alpha / 255f;
		int red = color >> 16 & 0xff;
		int green = color >> 8 & 0xff;
		int blue = color & 0xff;
		red = (int) (red * a + 0.5);
		green = (int) (green * a + 0.5);
		blue = (int) (blue * a + 0.5);
		return 0xff << 24 | red << 16 | green << 8 | blue;
	}


}
