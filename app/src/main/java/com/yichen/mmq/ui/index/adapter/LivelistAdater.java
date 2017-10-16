package com.yichen.mmq.ui.index.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.yichen.mmq.bean.LiveInfo1;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class LivelistAdater extends RecyclerArrayAdapter<LiveInfo1> {
	Context context;
	public LivelistAdater(Context context) {
		super(context);
		this.context=context;
	}

	public void setOnClickPhotoListener(LiveListHolder.OnClickPhotoListener
			                                    onClickPhotoListener) {
		this.onClickPhotoListener = onClickPhotoListener;
	}

	LiveListHolder.OnClickPhotoListener onClickPhotoListener;

	@Override
	public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
		LiveListHolder holder = new LiveListHolder(parent);
		if (onClickPhotoListener!=null)
			holder.setPhotoListener(onClickPhotoListener);
		return holder;
	}

	@Override
	public int getViewType(int position) {
		return super.getViewType(position);
	}
}
