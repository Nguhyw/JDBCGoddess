package com.nguhyw.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
	private static String mysqlName = "nguhyw";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/"+mysqlName+"?useUnicode=true&characterEncoding=utf-8";
	private static String user = "root";
	private static String password = "";
	private static Connection conn=null;
	
	/*
	 * 静态代码块，在此类被导入的时候会执行静态代码块，初始化数据库连接（仅执行一次）
	 */
	static {
		try {
			//加载数据库驱动
			Class.forName(driver);
			//获得数据库连接
			conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()){
//				System.out.println("数据库连接成功");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
	
	/*
	 * 返回数据库的链接对象,在其他类中可以通过此对象来操作数据库，实现增、删、改、查。
	 */
	public static Connection getConnection(){
		
		return conn;
	}
	
	/*
	 * 测试连接数据库是否成功
	 */
	public static void main(String[] args) {
		new DBUtil();
	}
}
