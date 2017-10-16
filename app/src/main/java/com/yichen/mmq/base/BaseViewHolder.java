package com.yichen.mmq.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 *  //todo代抽
 * Created by chenrongfa on 2017/1/19
 * email:18720979339@163.com
 * qq:952786280
 * company:yy
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    public void bindData(T object, Context co){}

}
