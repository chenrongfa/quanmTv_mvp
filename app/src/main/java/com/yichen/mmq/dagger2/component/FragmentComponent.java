package com.yichen.mmq.dagger2.component;

import com.yichen.mmq.dagger2.module.FragmentModule;
import com.yichen.mmq.dagger2.scope.FragmentScope;
import com.yichen.mmq.ui.index.fragment.IndexFragment;
import com.yichen.mmq.ui.index.fragment.LiveListFragment;
import com.yichen.mmq.ui.index.fragment.RecommendFragment;
import com.yichen.mmq.ui.index.presenter.CategoryPresenter;
import com.yichen.mmq.ui.index.presenter.LivelistPresenter;
import com.yichen.mmq.ui.index.presenter.RecommentPresenter;
import com.yichen.mmq.ui.room.fragments.SearchLiveFragment;
import com.yichen.mmq.ui.room.presenter.SearchLivePresenter;

import dagger.Component;

/**
 * Created by crf on 2017/9/21.
 * company:逸辰
 * qq:952786280
 * feature:
 */
@FragmentScope
@Component(modules = {FragmentModule.class
}, dependencies = ActivityComponent.class)
public interface FragmentComponent {
	void inject(IndexFragment indexFragment);


	CategoryPresenter getCateGoryPresenter();

	LivelistPresenter getLivelistPresenter();

	void inject(LiveListFragment liveListFragment);

	void inject(RecommendFragment recommendFragment);

	RecommentPresenter getRecommendpresenter();

	void inject(SearchLiveFragment searchLiveFragment);

	SearchLivePresenter getSearchLivePresenter();
}
