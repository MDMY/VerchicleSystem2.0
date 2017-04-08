package com.iflytek.util;
/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月8日 下午2:37:51
* 类说明
*/
import java.text.SimpleDateFormat;

public class DebugLog {
	
	private static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"); 
	
	public static void Log(String tag,String log)
	{
		if(true)
		    System.out.println(log);
	}
	
	public static void Log(String log)
	{
		String date=sDateFormat.format(new java.util.Date());
		if(true){
		    System.out.println("<" + date + ">" + log);
		}
	}
}