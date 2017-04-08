package com.zhixing.cn.MyUtil;
/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月8日 下午3:39:16
* 类说明
*/
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
//import java.util.*;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang.StringEscapeUtils;

import com.zhixing.model.User;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBHelper implements DBConfig{
	
	public static Connection getConnection(){
		MysqlDataSource mds=new MysqlDataSource();
		mds.setDatabaseName(databaseName);
		mds.setUser(username);
		mds.setPassword(password);
		try{
			return mds.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static boolean exists(String username){
		QueryRunner runner=new QueryRunner();
		String sql="select id from tb_user where username='"+username+"';";
		Connection conn=getConnection();
		ResultSetHandler<List<Object>> rsh=new ColumnListHandler();
		try{
			List<Object> result =runner.query(conn,sql,rsh);
			if(result.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}
	
	public static boolean check(String username,char[] password){
		username=StringEscapeUtils.escapeSql(username);
		QueryRunner runner=new QueryRunner();
		String sql="select password from tb_user where username = '" + username + "';";
		Connection conn=getConnection();
		ResultSetHandler<Object> rsh=new ScalarHandler();
		try{
			String result=(String)runner.query(conn, sql,rsh);
			char [] queryPassword=result.toCharArray();
			if(Arrays.equals(password,queryPassword)){
				Arrays.fill(password, '0');
				Arrays.fill(queryPassword, '0');
				return true;
			}else{
				Arrays.fill(password, '0');
				Arrays.fill(queryPassword,'0');
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}
	
	public static boolean save(User user){
		QueryRunner runner=new QueryRunner();
		String sql="insert into tb_user (username,password,email) values(?,?,?);";
//		String sql="insert into  tb_user (username,password,email) values "
//				+ "('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"')";
		Connection conn=getConnection();
		Object[] params={user.getUsername(),user.getPassword(),user.getEmail()};
		System.out.println("dddd<<<<" +sql);
		try{
			int result=runner.update(conn,sql,params);
			if(result >0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}
}

