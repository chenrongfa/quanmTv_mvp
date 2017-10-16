package com.yichen.mmq.ui.index.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.yichen.mmq.bean.Recommend;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class RecommentChildAdater extends RecyclerArrayAdapter<Recommend.RoomBean.ListBean> {
	Context context;

	public void setmOnClickPhotoListener(RecommentChildHolder.OnClickPhotoListener
			                                     mOnClickPhotoListener) {
		this.mOnClickPhotoListener = mOnClickPhotoListener;
	}

	private RecommentChildHolder.OnClickPhotoListener mOnClickPhotoListener;
	public RecommentChildAdater(Context context) {
		super(context);
		this.context=context;
	}

	@Override
	public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
		RecommentChildHolder recommentChildHolder = new RecommentChildHolder(parent);
		if (mOnClickPhotoListener!=null){
			recommentChildHolder.setPhotoListener(mOnClickPhotoListener);
		}
		return recommentChildHolder;
	}

	@Override
	public int getViewType(int position) {
		return super.getViewType(position);
	}
}
