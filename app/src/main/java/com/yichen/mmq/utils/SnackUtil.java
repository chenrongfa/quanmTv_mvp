package com.yichen.mmq.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.yichen.mmq.R;

/**
 * Created by crf on 2017/9/2.
 * company:逸辰
 * qq:952786280
 * feature: 底部吐司
 */

public class SnackUtil {
	private static final int red = 0xffb95050;
	private static final int green = 0xff4caf50;
	private static final int blue = 0xff2195f3;
	private static final int orange = 0xffffc107;
	private static final int black = 0xff2e2e2e;
	private static final int white = 0xffFFFFFF;
	private static final int nightTextColor = 0xff9AACEC;
	private static final int nightBgColor = 0xff2A2F41;
	public static View getView(Snackbar snackbar){
		if(snackbar!=null){
			return snackbar.getView();
		}
		return null;
	}

	/**
	 *
	 * @param v
	 * @param message
	 * @param time -1 为无限 0 短,1 长
	 * @return
	 */
	public static Snackbar createSnackbar(View v,String message,int time){
		Snackbar snackbar=null;
		if(-1==time)
			snackbar=Snackbar.make(v,message,Snackbar.LENGTH_INDEFINITE);
		else if(0==time)
			snackbar=Snackbar.make(v,message,Snackbar.LENGTH_SHORT);
		else if(1==time)
			snackbar=Snackbar.make(v,message,Snackbar.LENGTH_LONG);

		return snackbar;
	}
	public static Snackbar setColorWithIsShow(Snackbar snackbar, int baColor ,int textColor){
		return setColorWithIsShow(snackbar,  baColor , textColor,false);

	}

	public static Snackbar setColorWithIsShow(Snackbar snackbar, int baColor, int textColor, boolean isShow) {
		View view = getView(snackbar);
		if(view!=null){
			view.setBackgroundColor(baColor);
			view.findViewById(R.id.snackbar_text).setBackgroundColor(textColor);
			if(isShow){
				snackbar.show();
			}
			return snackbar;
		}
	    return null;
	}
	public static Snackbar setColorIDWithIsShow(Snackbar snackbar, int baColor ,int textColor){
		return setColorIDWithIsShow(snackbar,  baColor , textColor,false);

	}

	public static Snackbar setColorIDWithIsShow(Snackbar snackbar, int baColor, int textColor, boolean isShow) {
		View view = getView(snackbar);
		if(view!=null){
			view.setBackgroundResource(baColor);
			view.findViewById(R.id.snackbar_text).setBackgroundResource(textColor);
			if(isShow){
				snackbar.show();
			}
			return snackbar;
		}
	    return null;
	}

	public static Snackbar defaultInfo(Snackbar snackbar) {
		return setColorWithIsShow(snackbar, black, white);
	}

	public static Snackbar defaultInfoNight(Snackbar snackbar) {
		return setColorWithIsShow(snackbar, nightBgColor, nightTextColor,true);
	}

	public static Snackbar info(Snackbar snackbar) {
		return setColorWithIsShow(snackbar, blue, white,true);
	}

	public static Snackbar warning(Snackbar snackbar) {
		return setColorWithIsShow(snackbar, orange, white,true);
	}

	public static Snackbar alert(Snackbar snackbar) {
		return setColorWithIsShow(snackbar, red, white,true);
	}

	public static Snackbar confirm(Snackbar snackbar) {
		return setColorWithIsShow(snackbar, green, white,true);
	}


}
