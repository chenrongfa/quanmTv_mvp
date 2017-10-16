package com.yichen.mmq.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yichen.mmq.ui.index.adapter.RecommentChildAdater1;

/**
 * Created by crf on 2017/9/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class PhotoLayoutManage extends GridLayoutManager {
	@Override
	public int getSpanCount() {
		return spanCount;
	}

	// RecyclerView高度随Item自适应
	private int spanCount;
	RecommentChildAdater1 adapter;
	public PhotoLayoutManage(Context context, int spanCount,RecommentChildAdater1 adapter) {
		super(context,spanCount);
		this.spanCount=spanCount;
		this.adapter=adapter;
	}
	@Override
	public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, final int widthSpec, final int heightSpec) {
		try {
			//不能使用   View view = recycler.getViewForPosition(0);
			//measureChild(view, widthSpec, heightSpec);
			// int measuredHeight  view.getMeasuredHeight();  这个高度不准确

			if(adapter!=null&&adapter.getItemHeight()>0) {
				int measuredWidth = View.MeasureSpec.getSize(widthSpec);

				int line = adapter.getItemCount() / getSpanCount();
				if (adapter.getItemCount() % getSpanCount() > 0) line++;
				int measuredHeight = adapter.getItemHeight()* line;//*+rvPhotos.getPaddingBottom()+rvPhotos.getPaddingTop();*/
				setMeasuredDimension(measuredWidth, measuredHeight);
			}else{
				super.onMeasure(recycler,state,widthSpec,heightSpec);
			}

		}catch (Exception e){
			super.onMeasure(recycler,state,widthSpec,heightSpec);
		}
	}
}