package com.czp.project.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndStringUtil {
	//日期转字符串
	public static String getFisrtDayOfMonth(Date date){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String firstDayOfMonth = sdf.format(date.getTime());
	    
		return firstDayOfMonth;
	}
	//字符串转日期
	public static Date strToDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
	   	try {
		   	date = format.parse(str);
	  	} catch (ParseException e) {
		   	e.printStackTrace();
	   	}
	   	return date;
	}
}
