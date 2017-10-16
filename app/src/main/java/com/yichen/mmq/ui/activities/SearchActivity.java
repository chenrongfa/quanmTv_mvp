package com.yichen.mmq.ui.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuohang.library.utils.StringUtils;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseActivity;
import com.yichen.mmq.base.BasePresenter;
import com.yichen.mmq.bean.P;
import com.yichen.mmq.bean.SearchRequestBody;
import com.yichen.mmq.ui.room.fragments.SearchFragment;
import com.yichen.mmq.utils.InputMethodManagerUtils;
import com.yichen.mmq.utils.UIUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {

	@Bind(R.id.iv_search_back)
	ImageView ivSearchBack;
	@Bind(R.id.iv_edit_clear)
	ImageView ivEditClear;
	@Bind(R.id.tv_search)
	TextView tvSearch;
	@Bind(R.id.at_text)
	AppCompatEditText atText;
	@Bind(R.id.fl_search)
	FrameLayout flSearch;
		@Override
	protected BasePresenter createPresenter() {
		return null;
	}
   private FragmentManager mFragmentManager=getSupportFragmentManager();


	private static final String TAG = "SearchActivity";
	@Override
	public void initListener() {
		super.initListener();
		atText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int
					after) {
				Log.d(TAG, "beforeTextChanged() called with: s = [" + s + "], start = ["
						+ start + "], count = [" + count + "], after = [" + after + "]");
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				if (StringUtils.isEmpty(s.toString())){
					UIUtils.showToast("1");
					ivEditClear.setVisibility(View.GONE);
				}else {
					if (ivEditClear.getVisibility()==View.GONE){
						UIUtils.showToast("2");
					  ivEditClear.setVisibility(View.VISIBLE);}
				}
			}
		});
		atText.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(event.getAction()== MotionEvent.ACTION_DOWN&&keyCode==KeyEvent.KEYCODE_ENTER&&
						keyCode==KeyEvent.KEYCODE_SEARCH){
					search();
					return true;
				}

				return false;
			}
		});
	}

	private void search() {
		String key = atText.getText().toString();
		if (StringUtils.isEmpty(key)){
			UIUtils.showToast("关键词不能为空");
		}else{
			Log.e(TAG, "search: " );

			flSearch.setVisibility(View.VISIBLE);
			InputMethodManagerUtils.HideKeyBoardForView(atText);
			SearchRequestBody body=SearchRequestBody.getInstance(new P(0,key,P.DEFAULT_SIZE));
			mFragmentManager.beginTransaction().replace(R.id.fl_search,SearchFragment.newInstance(body))
					.commit();
		}
	}

	@Override
	protected int provideContentViewId() {
		return R.layout.activity_search;
	}

	@OnClick({R.id.iv_search_back, R.id.at_text,R.id.iv_edit_clear, R.id.tv_search})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.iv_search_back:
				break;
			case R.id.iv_edit_clear:
				atText.setText("");
				flSearch.setVisibility(View.GONE);
				break;
			case R.id.at_text:
				UIUtils.showToast("12");
				InputMethodManagerUtils.showKeyBoardForView(atText);
				break;
			case R.id.tv_search:
				search();
				break;
		}
	}
}
