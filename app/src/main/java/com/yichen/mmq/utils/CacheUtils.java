package com.yichen.mmq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.yichen.mmq.base.BaseApp;


/**
 * 待完善
 * Created by chenrongfa on 2017/3/3
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public class CacheUtils {
	private static CacheUtils mCache=new CacheUtils();
	private static final String name="mmq";
	private CacheUtils(){

	}
	public static CacheUtils getInstance(){
		return mCache;
	}
	public static SharedPreferences sharedPreferences;


	public void init() {
		sharedPreferences = BaseApp.getContext().getSharedPreferences(name, Context.MODE_PRIVATE);
	}

	/**
	 *
	 *  保存
	 * @param key
	 * @param value
	 */

	public void save(String key, Object value) {
		SharedPreferences.Editor edit = sharedPreferences.edit();
		if (value instanceof String) {
			edit.putString(key, (String) value);

		} else if (value instanceof Boolean) {

			edit.putBoolean(key, (Boolean) value);
		} else if (value instanceof Integer) {
			edit.putInt(key, (Integer) value);
		}
       edit.commit();
	}

	/**
	 *  读取数据
	 * @param key
	 * @param t
	 * @param <T>
	 * @return
	 */
	public <T extends Object> T get(String key, T t) {
		if (t instanceof String) {
			return (T) sharedPreferences.getString(key, (String) t);
		} else if (t instanceof Integer) {

			Integer result = sharedPreferences.getInt(key, (Integer) t);
			return (T) result;
		} else if (t instanceof Boolean) {
			Boolean result = sharedPreferences.getBoolean(key, (Boolean) t);
			return (T) result;
		} else {
			return t;
		}

	}


}
