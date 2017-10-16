package com.yichen.mmq.bean;

import android.util.Log;

import com.yichen.mmq.dagger2.scope.ActivityScope;
import com.yichen.mmq.http.api.APIService;

import javax.inject.Inject;

/**
 * Created by crf on 2017/9/20.
 * company:逸辰
 * qq:952786280
 * feature: Test  dagger2
 */
@ActivityScope
public class User {
	private String name;
	private String pwd;
	@Inject
	public User(APIService apiService){
		Log.e("tt", "sayHello: "+apiService );
	}
	public void sayHello(){

		Log.e("tt", "sayHello: " );
	}
}
