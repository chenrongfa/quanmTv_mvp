package com.yichen.mmq.dagger2.component;

import com.yichen.mmq.App;
import com.yichen.mmq.dagger2.module.AppModule;
import com.yichen.mmq.http.api.APIService;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by crf on 2017/9/20.
 * company:逸辰
 * qq:952786280
 * feature:
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
	void inject(App baseApp);

	App getApp();
	APIService getApiService();

	Retrofit getRetrofit();
	OkHttpClient getOkHttpClient();
}
