package com.yichen.mmq.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.lang.reflect.Field;

import static android.content.ContentValues.TAG;

/**
 * Created by chenrongfa on 2017/9/5.
 * QQ:952786280
 * email:18720979339@163.com
 * company:逸臣有限公司
 * function:
 */
public class InputMethodManagerUtils {

	/**
	 * @param destContext 上下文对象
	 * 用于解决输入法内存泄露
	 * 参考：http://blog.csdn.net/sodino/article/details/32188809
	 */
	public static void fixInputMethodManagerLeak(Context destContext) {
		if (destContext == null) {
			return;
		}

		InputMethodManager imm = (InputMethodManager) destContext.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm == null) {
			return;
		}

		String [] arr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
		Field f = null;
		Object obj_get = null;
		for (int i = 0;i < arr.length;i ++) {
			String param = arr[i];
			try{
				f = imm.getClass().getDeclaredField(param);
				if (f.isAccessible() == false) {
					f.setAccessible(true);
				} // author: sodino mail:sodino@qq.com
				obj_get = f.get(imm);
				if (obj_get != null && obj_get instanceof View) {
					View v_get = (View) obj_get;
					if (v_get.getContext() == destContext) { // 被InputMethodManager持有引用的context是想要目标销毁的
						f.set(imm, null); // 置空，破坏掉path to gc节点
					} else {
						// 不是想要目标销毁的，即为又进了另一层界面了，不要处理，避免影响原逻辑,也就不用继续for循环了
						break;
					}
				}
			}catch(Throwable t){
				t.printStackTrace();
			}
		}
	}
	public static void HideKeyBoardForView(EditText e){
		InputMethodManager imm = (InputMethodManager) e.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm!=null){
			Log.e(TAG, "HideKeyBoardForView: " );
			imm.hideSoftInputFromWindow(e.getWindowToken(),0);
		}
		e.clearFocus();
	}
	public static void showKeyBoardForView(EditText e){
		InputMethodManager imm = (InputMethodManager) e.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		e.requestFocus();
		if (imm!=null){
			Log.e(TAG, "showKeyBoardForView: " );
			imm.showSoftInput(e,InputMethodManager.SHOW_IMPLICIT);
		}

	}
}
