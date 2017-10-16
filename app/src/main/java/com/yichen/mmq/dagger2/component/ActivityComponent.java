package com.yichen.mmq.dagger2.component;

import com.yichen.mmq.dagger2.scope.ActivityScope;
import com.yichen.mmq.ui.activities.MainActivity;
import com.yichen.mmq.ui.activities.PlShowingActivity;
import com.yichen.mmq.ui.activities.PlVideoViewActivity;
import com.yichen.mmq.ui.activities.TestCrossActivity;

import dagger.Component;

/**
 * Created by crf on 2017/9/20.
 * company:逸辰
 * qq:952786280
 * feature:
 */
@ActivityScope
@Component(dependencies = {AppComponent.class})
public interface ActivityComponent {
	void inject(MainActivity mainActivity);
	void inject(PlVideoViewActivity mainActivity);
	void inject(PlShowingActivity mainActivity);

	void inject(TestCrossActivity testCrossActivity);
}
