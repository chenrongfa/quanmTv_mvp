package com.yichen.mmq.dagger2.module;

import com.yichen.mmq.App;
import com.yichen.mmq.dagger2.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by crf on 2017/9/29.
 * company:逸辰
 * qq:952786280
 * feature:
 */
@Module
public class FragmentModule {
	private App app;
	public FragmentModule(App app
	){
		this.app=app;

	}
	@FragmentScope
	@Provides
	App getApp(){
		return this.app;
	}
}
