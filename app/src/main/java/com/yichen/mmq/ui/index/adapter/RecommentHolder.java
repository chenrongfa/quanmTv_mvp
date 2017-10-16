package com.yichen.mmq.ui.index.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.yichen.mmq.R;
import com.yichen.mmq.bean.Recommend;
import com.yichen.mmq.utils.UIUtils;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class RecommentHolder extends BaseViewHolder<Recommend.RoomBean> {
	//@Bind(R.id.tv_more)
    TextView tv_more;
    TextView tv_category_name;
	 //@Bind(R.id.iv_logo)
	 ImageView iv_category_logo;
	//@Bind(R.id.el_recyler_item)
	EasyRecyclerView el_recyler_item;
	//RecyclerView recyclerView;
	RecommentChildAdater recommentChildAdater;
	//List<Recommend.RoomBean.ListBean> list=new ArrayList<>();
	public RecommentHolder(ViewGroup itemView) {

		super(itemView,R.layout.fragment_recomment_item);
		Log.e("ggg", "RecommentHolder: " );
		//ButterKnife.bind(itemView);
		el_recyler_item=$(R.id.el_recyler_item);
		tv_category_name=$(R.id.tv_category_name);
		recommentChildAdater=new RecommentChildAdater(getContext());

		el_recyler_item.setAdapter(recommentChildAdater);

		//recyclerView=el_recyler_item.getRecyclerView();
		iv_category_logo=$(R.id.iv_category_logo);
		tv_more=$(R.id.tv_more);



		SpaceDecoration spaceDecoration = new SpaceDecoration(UIUtils.dip2Px(6));
		el_recyler_item.addItemDecoration(spaceDecoration);
	}

	@Override
	public void setData(final Recommend.RoomBean data) {
		Glide.with(getContext()).load(data.getIcon()).centerCrop().placeholder(R.drawable.btn_gift).diskCacheStrategy(DiskCacheStrategy.ALL).into(iv_category_logo);
		tv_more.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					if (moreListener!=null)
						moreListener.clickMoreListener(data);
			}
		});
		tv_category_name.setText(data.getName());
		recommentChildAdater.clear();
		recommentChildAdater.addAll(data.getList());
		recommentChildAdater.setmOnClickPhotoListener(onClickPhotoListener);
		el_recyler_item.setLayoutManager(new GridLayoutManager(getContext(),2));
		recommentChildAdater.notifyDataSetChanged();
	}

	private OnClickMoreListener moreListener;
	private RecommentChildHolder.OnClickPhotoListener onClickPhotoListener;

	public void setMoreListener(OnClickMoreListener moreListener) {
		this.moreListener = moreListener;
	}

	public void setPhoteListener(RecommentChildHolder.OnClickPhotoListener
			                             onClickPhotoListener) {
		this.onClickPhotoListener=onClickPhotoListener;
	}


	public interface  OnClickMoreListener{
		void clickMoreListener(Recommend.RoomBean data);
	}
}
