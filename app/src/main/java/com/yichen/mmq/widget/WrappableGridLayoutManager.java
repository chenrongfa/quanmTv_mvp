package com.yichen.mmq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by crf on 2017/9/23.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class WrappableGridLayoutManager extends GridLayoutManager {

	public WrappableGridLayoutManager(Context context, int spanCount) {
		super(context, spanCount);
	}
	private int[] mMeasuredDimension = new int[2];

	@Override
	public boolean canScrollVertically() {
		return false;
	}

	@Override
	public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
		final int widthMode = View.MeasureSpec.getMode(widthSpec);
		final int heightMode = View.MeasureSpec.getMode(heightSpec);
		final int widthSize = View.MeasureSpec.getSize(widthSpec);
		final int heightSize = View.MeasureSpec.getSize(heightSpec);

		int spanWidth = 0;
		int spanHeight = 0;
		int viewWidth = 0;
		int viewHeight = 0;

		int spanCount = getSpanCount();
	   try {
			for (int i = 0; i < getItemCount(); i++) {
				measureScrapChild(recycler, i, View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED), mMeasuredDimension);


				if (i % spanCount == 0) {
					spanWidth = mMeasuredDimension[0];
					spanHeight = mMeasuredDimension[1];
				} else {
					if (getOrientation() == VERTICAL) {
						spanWidth += mMeasuredDimension[0];
						spanHeight = Math.max(spanHeight, mMeasuredDimension[1]);
					} else {
						spanWidth = Math.max(spanWidth, mMeasuredDimension[0]);
						spanHeight += mMeasuredDimension[1];
					}
				}

				if (i % spanCount == spanCount - 1 || i == getItemCount() - 1) {
					if (getOrientation() == VERTICAL) {
						viewWidth = Math.max(viewWidth, spanWidth);
						viewHeight += spanHeight;
					} else {
						viewWidth += spanWidth;
						viewHeight = Math.max(viewHeight, spanHeight);
					}
				}
			}
			int finalHeight;
			int finalWidth;

			switch (widthMode){
				case View.MeasureSpec.EXACTLY:
					finalWidth=widthSize;
					break;
				case View.MeasureSpec.AT_MOST:
					finalWidth=Math.min(widthSize,viewWidth);
					break;
				case View.MeasureSpec.UNSPECIFIED:
					finalWidth=viewWidth;
					break;
				default:
					finalWidth=widthSize;
					break;
			}

			switch (heightMode){
				case View.MeasureSpec.EXACTLY:
					finalHeight=heightSize;
					break;
				case View.MeasureSpec.AT_MOST:
					finalHeight=Math.min(heightSize,viewHeight);
					break;
				case View.MeasureSpec.UNSPECIFIED:
					finalHeight=viewHeight;
					break;
				default:
					finalHeight=heightSize;
					break;
			}
		   Log.e("tt", "onMeasure: finalWidth"+finalWidth );
		   Log.e("tt", "onMeasure: finalHeight"+finalHeight );
			setMeasuredDimension(finalWidth,finalHeight);
		}catch (Exception e){
			super.onMeasure(recycler,state,widthSpec,heightSize);
		    Log.e("tt", "onMeasure:recycler " );

		}

	}

	private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec, int heightSpec, int[] measuredDimension) {

		View view = recycler.getViewForPosition(position);

		if (view != null) {

			RecyclerView.LayoutParams p = (RecyclerView.LayoutParams) view.getLayoutParams();

			int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec,
					getPaddingLeft() + getPaddingRight(), p.width);
			int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec,
					getPaddingTop() + getPaddingBottom(), p.height);

			view.measure(childWidthSpec, childHeightSpec);

			measuredDimension[0] = view.getMeasuredWidth() + p.leftMargin + p.rightMargin;
			measuredDimension[1] = view.getMeasuredHeight() + p.bottomMargin + p.topMargin;

			Rect decoratorRect=new Rect();
			calculateItemDecorationsForChild(view,decoratorRect);
			measuredDimension[0]+=decoratorRect.left;
			measuredDimension[0]+=decoratorRect.right;
			measuredDimension[1]+=decoratorRect.top;
			measuredDimension[1]+=decoratorRect.bottom;

			recycler.recycleView(view);
		}
	}
}
