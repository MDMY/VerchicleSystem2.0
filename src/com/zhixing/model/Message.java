package com.zhixing.model;
/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月8日 下午3:41:56
* 类说明
*/
import java.util.Vector;

public class Message {
	 public String userPhone;
	 public String userName;
	 public String userEmail;
	 public String carNo;
	 public String carName;
	
	public void getUserMessageInfo(Vector uMessager) throws NullPointerException{
		userPhone=uMessager.get(0).toString();
		userName=uMessager.get(1).toString();
		userEmail=uMessager.get(2).toString();
		carNo=uMessager.get(3).toString();
		carName=uMessager.get(4).toString();
		
	}

}
