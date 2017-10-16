package com.yichen.mmq.ui.index.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.yichen.mmq.bean.Recommend;
import com.yichen.mmq.ui.index.fragment.RecommendFragment;

import java.util.List;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class RecommentAdater extends RecyclerArrayAdapter<Recommend.RoomBean> {
	Context context;
	RecommentHolder.OnClickMoreListener onClickMoreListener;
	public RecommentAdater(Context context, List<Recommend.RoomBean> objects,RecommentHolder.OnClickMoreListener onClickMoreListener) {
		super(context, objects);
		this.context=context;
		this.onClickMoreListener=onClickMoreListener;
	}

	@Override
	public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
	/*	View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_recomment_item,
				null);*/
		RecommentHolder holder = new RecommentHolder(parent);
		holder.setMoreListener(onClickMoreListener);
		if (onClickPhotoListener!=null)
		holder.setPhoteListener(onClickPhotoListener);
		return holder;
	}
	private RecommentChildHolder.OnClickPhotoListener onClickPhotoListener;
	public void setOnPhotoClickListener(RecommendFragment recommendFragment) {
		onClickPhotoListener=recommendFragment;
	}
}
