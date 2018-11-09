package com.longer.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: spring-springmvc
 * @description:
 * @author: SunBiaoLong
 * @create: 2018-11-07 09:40
 **/
public class Test {
	public static void main(String[] args){

		Date date = new Date(Long.valueOf(1512035378000L));
		System.out.println(date);
	}

//	public static Date parseToSecond(String strTime) throws ParseException {
//		SimpleDateFormat secondFormat = null;
//		if(strTime.indexOf("/")==-1)
//			secondFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		else
//			secondFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//		return secondFormat.parse(strTime);
//	}
}
