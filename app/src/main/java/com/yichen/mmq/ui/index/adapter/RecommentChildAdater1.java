package com.yichen.mmq.ui.index.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yichen.mmq.R;
import com.yichen.mmq.base.BaseViewHolder;
import com.yichen.mmq.bean.Recommend;

import java.util.List;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class RecommentChildAdater1 extends RecyclerView.Adapter<com.yichen.mmq.base.BaseViewHolder> {
	List<Recommend.RoomBean.ListBean>
			list;
	Context context;
	public RecommentChildAdater1(Context context, List<Recommend.RoomBean.ListBean>
			list) {
		this.list=list;
		this.context=context;
	}
	private int itemHeight;
	int i=0;
	@Override
	public com.yichen.mmq.base.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			final View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_recomment_item_child,
				null);

		return new RecommentChildHolder1(inflate);
	}

	@Override
	public void onBindViewHolder(com.yichen.mmq.base.BaseViewHolder holder, int position) {
		holder.bindData(list.get(position),context);
	}

	@Override
	public int getItemCount() {
		return list.size();
	}



	public int getItemHeight() {
		return itemHeight;
	}
	class RecommentChildHolder1 extends BaseViewHolder<Recommend.RoomBean.ListBean> {
		//@Bind(R.id.tv_title)
		TextView tv_title;
		//Bind(R.id.tv_name)
		TextView tv_name;
		//@Bind(R.id.tv_viewer)
		TextView tv_viewer;
		//@Bind(R.id.iv_live_photo)
		ImageView iv_live_photo;


		public RecommentChildHolder1(final View view) {
			super(view);
			view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

				@Override
				public boolean onPreDraw() {
					itemHeight=view.getMeasuredHeight();
					return true;
				}
			});
			//ButterKnife.bind(itemView);
			iv_live_photo= (ImageView) view.findViewById(R.id.iv_live_photo);
			tv_viewer= (TextView) view.findViewById(R.id.tv_viewer);
			tv_name= (TextView) view.findViewById(R.id.tv_name);
			tv_title= (TextView) view.findViewById(R.id.tv_title);
		}


		@Override
		public void bindData(Recommend.RoomBean.ListBean data, Context co) {
			Glide.with(co).load(data.getThumb()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(iv_live_photo);
			tv_title.setText(data.getTitle());
			tv_name.setText(data.getNick());
			tv_viewer.setText(data.getFollow()+"");
		}
	}
}
