package com.yichen.mmq;

import com.yichen.mmq.base.BaseApp;
import com.yichen.mmq.dagger2.component.AppComponent;
import com.yichen.mmq.dagger2.component.DaggerAppComponent;
import com.yichen.mmq.dagger2.module.AppModule;

/**
 * Created by chenrongfa on 2017/9/1.
 * QQ:952786280
 * email:18720979339@163.com
 * company:逸臣有限公司
 * function:
 */
public class App extends BaseApp {
  private AppComponent appComponent;
	@Override
	public void onCreate() {
		super.onCreate();
		appComponent=DaggerAppComponent.builder().appModule(new AppModule(this,Constants.BASE_URL))
				.build();

	}

	public AppComponent getAppComponent() {
		return appComponent;
	}
}
