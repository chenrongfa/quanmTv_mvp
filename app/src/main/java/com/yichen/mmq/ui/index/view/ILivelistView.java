package com.yichen.mmq.ui.index.view;

import com.yichen.mmq.base.BaseView;
import com.yichen.mmq.bean.LiveInfo1;

import java.util.List;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public interface ILivelistView extends BaseView {
	void   onLiveList(List<LiveInfo1> data);
}
