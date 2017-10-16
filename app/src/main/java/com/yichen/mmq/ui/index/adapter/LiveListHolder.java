package com.yichen.mmq.ui.index.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.yichen.mmq.Constants;
import com.yichen.mmq.R;
import com.yichen.mmq.bean.LiveInfo1;
import com.yichen.mmq.utils.DecimalUtil;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class LiveListHolder extends BaseViewHolder<LiveInfo1> {
	//@Bind(R.id.tv_title)
	 TextView tv_title;
	//Bind(R.id.tv_name)
	TextView tv_name;
	//@Bind(R.id.tv_viewer)
	 TextView tv_viewer;
	//@Bind(R.id.iv_live_photo)
	 ImageView iv_live_photo;


	public LiveListHolder(ViewGroup parent) {
		super(parent,R.layout.fragment_recomment_item_child);
		//ButterKnife.bind(itemView);
		iv_live_photo=$(R.id.iv_live_photo);
		tv_viewer=$(R.id.tv_viewer);
		tv_name=$(R.id.tv_name);
		tv_title=$(R.id.tv_title);
	}

	@Override
	public void setData(final LiveInfo1 data) {
		Glide.with(getContext()).load(data.getThumb()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(iv_live_photo);
		tv_title.setText(data.getTitle());
		tv_name.setText(data.getNick());
		tv_viewer.setText(DecimalUtil.getInstance().formatNumber(data.getView()));

		iv_live_photo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (photoListener!=null){
					boolean isShow=false;
					if (Constants.SHOWING.equalsIgnoreCase(data.getCategory_slug())){
						isShow=true;
					}
					photoListener.clickPhotoListener(Integer.parseInt(data.getUid()),isShow);
				}
			}
		});
	}



	private OnClickPhotoListener photoListener;

	public void setPhotoListener(OnClickPhotoListener photoListener) {
		this.photoListener = photoListener;
	}

	public interface  OnClickPhotoListener{
		void clickPhotoListener(int  uid,boolean showing);
	}
}
