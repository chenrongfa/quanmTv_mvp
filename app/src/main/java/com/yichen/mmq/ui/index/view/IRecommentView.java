package com.yichen.mmq.ui.index.view;

import com.yichen.mmq.base.BaseView;
import com.yichen.mmq.bean.AppStart;
import com.yichen.mmq.bean.Recommend;

import java.util.List;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public interface IRecommentView extends BaseView {
	void   onRecommendBanner(List<AppStart.AppfocusBean> appfocusBeen);
	void   onRecommendLiveList(Recommend recommends);
}
