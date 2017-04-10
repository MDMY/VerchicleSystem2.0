package com.zhixing.cn.MyUtil;
/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月9日 下午3:40:04
* 类说明
*/


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

//import org.apache.commons.dbutils.DbUtils;
//import org.apache.commons.dbutils.QueryRunner;

//import com.ding.model.User;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class UserDataBack implements DBConfig{
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
	
	public static Vector queryData(String sql){
		Connection conn=getConnection();
		Vector data=new Vector();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				Vector line=new Vector();
				for(int i=1;i<=5;i++){
					line.add(rs.getObject(i));
				}
				data.add(line);
			}
			rs.close();
			stmt.close();
			conn.close();
			return data;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
