package com.yichen.mmq.ui.room.view;

import com.yichen.mmq.base.BaseView;
import com.yichen.mmq.bean.LiveInfo1;
import com.yichen.mmq.bean.SearchResult;

import java.util.List;

/**
 * Created by crf on 2017/9/28.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public interface ISearchView   extends BaseView{
	 void getSearchResult(SearchResult.DataBean string);
	 void getSearchMoreResult(List<LiveInfo1> string);

}
