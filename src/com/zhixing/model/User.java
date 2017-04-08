package com.zhixing.model;
/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月8日 下午3:41:17
* 类说明
*/
public class User {
	private int id;//编号
	private String username;
	private String password;
	private String email;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public  String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	
	
	
	
		
	
}
