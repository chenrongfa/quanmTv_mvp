package com.yichen.mmq.ui.index.view;

import com.yichen.mmq.base.BaseView;
import com.yichen.mmq.bean.LiveCategory;

import java.util.List;

/**
 * Created by crf on 2017/9/21.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public interface ICategoryView extends BaseView {
	void onSuccess(List<LiveCategory> categoryList);

}
