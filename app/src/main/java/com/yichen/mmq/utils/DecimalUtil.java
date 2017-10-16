package com.yichen.mmq.utils;

import java.text.DecimalFormat;

/**
 * Created by crf on 2017/9/25.
 * company:逸辰
 * qq:952786280
 * feature:
 */

public class DecimalUtil {
	private static DecimalUtil decimalFormat=new DecimalUtil();
   public static DecimalUtil getInstance(){

	  return decimalFormat;
  }
	public String formatNumber(String num){
		float v = Long.parseLong(num) / 10000.0f;
		DecimalFormat decimalFormat=new DecimalFormat();
		//decimalFormat.format()
		if (v>=1){
			decimalFormat.applyPattern("#.#");
			return decimalFormat.format(v)+"万";
		}


		return num;
	}
	// 格式化网速
	public String formatInternetSpeed(long num){
		float v = num / 1024;
		DecimalFormat decimalFormat=new DecimalFormat();
		//decimalFormat.format()
			if (v>=1){
				float mv=v/1024;
				if (mv>0.7){
					float gv=mv/1024;

					if (gv>0.7){
						decimalFormat.applyPattern("#.#");
						return decimalFormat.format(mv)+"gb/s";
					}
					decimalFormat.applyPattern("#.#");
					return decimalFormat.format(mv)+"m/s";
				}
				decimalFormat.applyPattern("#.#");
				return decimalFormat.format(v)+"k/s";
			}



		return num +"k/s";
	}
}
