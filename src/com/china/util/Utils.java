package com.china.util;

import android.util.Log;


public class Utils {

	private static final boolean DEVELOPE_MODE = true;
	private static final String TAG = "info";
	
	public static void debug(String str){
		
		if(DEVELOPE_MODE){
			Log.i(TAG, str);
		}
	}
	
}
