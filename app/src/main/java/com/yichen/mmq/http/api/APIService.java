package com.yichen.mmq.http.api;


import com.yichen.mmq.bean.AppStart;
import com.yichen.mmq.bean.LiveCategory;
import com.yichen.mmq.bean.LiveListResult;
import com.yichen.mmq.bean.Recommend;
import com.yichen.mmq.bean.Room;
import com.yichen.mmq.bean.SearchRequestBody;
import com.yichen.mmq.bean.SearchResult;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/2/13
 */

public interface APIService {

    /**
     * 获取App启动页信息
     * @return
     */
    @GET("json/page/app-data/info.json?v=3.0.1&os=1&ver=4")
    Observable<AppStart> getAppStartInfo();

    /**
     * 获取分类列表
     * @return
     *
     * categories/list.json
     */
    @GET("json/app/index/category/info-android.json?v=3.0.1&os=1&ver=4")
    Observable<List<LiveCategory>> getAllCategories();

    /**
     * 获取推荐列表
     * @return
     */
    @GET("json/app/index/recommend/list-android.json?v=3.0.1&os=1&ver=4")
    Observable<Recommend> getRecommend();

    /**
     * 获取直播列表
     * @return
     */
    @GET("json/play/list.json?v=3.0.1&os=1&ver=4")
    Observable<LiveListResult> getLiveListResult();


    @GET("json/categories/{slug}/list.json?v=3.0.1&os=1&ver=4")
    Observable<LiveListResult> getLiveListResultByCategories(@Path("slug") String slug);

    /**
     * 进入房间
     * @param uid
     * @return
     */
    @GET("json/rooms/{uid}/info.json?v=3.0.1&os=1&ver=4")
    Observable<Room> enterRoom(@Path("uid") String uid);




    @POST("site/search")
    Observable<SearchResult> search(@Body SearchRequestBody searchRequestBody);


    @POST("site/search")
    Observable<ResponseBody> search1(@Body SearchRequestBody searchRequestBody);

}
