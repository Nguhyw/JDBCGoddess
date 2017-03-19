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
	 * ��̬����飬�ڴ��౻�����ʱ���ִ�о�̬����飬��ʼ�����ݿ����ӣ���ִ��һ�Σ�
	 */
	static {
		try {
			//�������ݿ�����
			Class.forName(driver);
			//������ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()){
//				System.out.println("���ݿ����ӳɹ�");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
	}
	
	/*
	 * �������ݿ�����Ӷ���,���������п���ͨ���˶������������ݿ⣬ʵ������ɾ���ġ��顣
	 */
	public static Connection getConnection(){
		
		return conn;
	}
	
	/*
	 * �����������ݿ��Ƿ�ɹ�
	 */
	public static void main(String[] args) {
		new DBUtil();
	}
}
