package com.yichen.mmq.dagger2.module;

import com.yichen.mmq.App;
import com.yichen.mmq.Constants;
import com.yichen.mmq.http.api.APIService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by crf on 2017/9/20.
 * company:逸辰
 * qq:952786280
 * feature:  提供 与 app 声明周期相同的实例
 */
@Module()
public class AppModule {
    private App context;
	private  String baseUrl;

	public AppModule(App context, String baseUrl){
		this.context=context;
		this.baseUrl=baseUrl;
	}
	@Provides
	@Singleton
	public Retrofit provideRetrofit(){
	return	new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.baseUrl(baseUrl)
			    .client(provideOkHttpClient())
				.build();
	}

	@Provides
	@Singleton
	public OkHttpClient provideOkHttpClient(){
		return new OkHttpClient.Builder()
				.connectTimeout(Constants.CONNECT_TIME_OUT,TimeUnit.MILLISECONDS)
				.readTimeout(Constants.READ_TIME_OUT, TimeUnit.MILLISECONDS)
				.writeTimeout( Constants.WTIRE_TIME_OUT,TimeUnit.MILLISECONDS).build();
	}
	@Provides
	@Singleton
	public APIService provideApiService(){
		return provideRetrofit().create(APIService.class);
	}


	@Provides
	@Singleton
	public App provideApp(){
		return context;
	}
}
