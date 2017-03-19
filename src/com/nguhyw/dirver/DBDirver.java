package com.nguhyw.dirver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nguhyw.entity.Goddess;
import com.nguhyw.util.DBUtil;

public class DBDirver {
	
	/*
	 * 获取所有的用户信息并通过集合的方式进行返回
	 */
	public List<Goddess> getAllUser(){
		Connection conn = DBUtil.getConnection();
		String sql = " select * from imooc_goddess ";
		List<Goddess> list = new ArrayList<Goddess>();
		Goddess goddess = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				goddess = new Goddess();
				goddess.setId(rs.getInt("id"));
				goddess.setUser_name(rs.getString("user_name"));
				goddess.setAge(rs.getInt("age"));
				goddess.setSex(rs.getInt("sex"));
				goddess.setBirthday(rs.getDate("birthday"));
				goddess.setEmail(rs.getString("email"));
				goddess.setMobile(rs.getString("mobile"));
				goddess.setCreate_user(rs.getString("create_user"));
				goddess.setCreate_date(rs.getDate("create_date"));
				goddess.setUpdate_user(rs.getString("update_user"));
				goddess.setUpdate_date(rs.getDate("update_date"));
				goddess.setIsdel(rs.getInt("isdel"));
				list.add(goddess);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/*
	 * 添加新的用户信息
	 */
	public void addGoddess(Goddess g){
		Connection conn = DBUtil.getConnection();
		String sql = " insert into imooc_goddess("+ 
		"user_name,age,sex,birthday,email,mobile,create_user,create_date,update_user,update_date,isdel) "+
		"values(?,?,?,?,?,?,?,current_date(),?,current_date(),?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getUser_name());
			pstmt.setInt(2, g.getAge());
			pstmt.setInt(3, g.getSex());
			pstmt.setDate(4, new Date(g.getBirthday().getTime()));
			pstmt.setString(5, g.getEmail());
			pstmt.setString(6, g.getMobile());
			pstmt.setString(7, g.getCreate_user());
			pstmt.setString(8, g.getUpdate_user());
			pstmt.setInt(9, g.getIsdel());
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 更新用户信息
	 */
	public void updateUser(Goddess g){
		Connection conn = DBUtil.getConnection();
		String sql = " update imooc_goddess "+
		" set user_name=?,age=?,sex=?,birthday=?,email=?,mobile=?,update_user=?,update_date=current_date(),isdel=? "+
		" where id=? "; 
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getUser_name());
			pstmt.setInt(2, g.getAge());
			pstmt.setInt(3, g.getSex());
			pstmt.setDate(4, new Date(g.getBirthday().getTime()));
			pstmt.setString(5, g.getEmail());
			pstmt.setString(6, g.getMobile());
			pstmt.setString(7, g.getUpdate_user());
			pstmt.setInt(8, g.getIsdel());
			pstmt.setInt(9, g.getId());
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 通过关键字查询用户信息
	 */
	public List<Goddess> queryFrom(String user_name, String mobile, String email){
		Connection conn = DBUtil.getConnection();
		String sql = " select * from imooc_goddess "+
		" where user_name like ? or mobile like ? or email like ?";
		List<Goddess> list = new ArrayList<Goddess>();
		Goddess goddess = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+user_name+"%");
			pstmt.setString(2, "%"+mobile+"%");
			pstmt.setString(3, "%"+email+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				goddess = new Goddess();
				goddess.setId(rs.getInt("id"));
				goddess.setUser_name(rs.getString("user_name"));
				goddess.setAge(rs.getInt("age"));
				goddess.setSex(rs.getInt("sex"));
				goddess.setBirthday(rs.getDate("birthday"));
				goddess.setEmail(rs.getString("email"));
				goddess.setMobile(rs.getString("mobile"));
				goddess.setCreate_user(rs.getString("create_user"));
				goddess.setCreate_date(rs.getDate("create_date"));
				goddess.setUpdate_user(rs.getString("update_user"));
				goddess.setUpdate_date(rs.getDate("update_date"));
				goddess.setIsdel(rs.getInt("isdel"));
				list.add(goddess);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/*
	 * 通过传递集合的方式来查询
	 */
	public List<Goddess> query(List<Map<String, Object>> params){
		Connection conn = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		List<Goddess> list = new ArrayList<Goddess>();
		Goddess goddess = null;
		
		sql.append(" select * from imooc_goddess where 1=1 ");
		if(params!=null&&params.size()>0){
			for(Map<String, Object> map: params){
				sql.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}

		System.out.println("sql:"+sql.toString());
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				goddess = new Goddess();
				goddess.setId(rs.getInt("id"));
				goddess.setUser_name(rs.getString("user_name"));
				goddess.setAge(rs.getInt("age"));
				goddess.setSex(rs.getInt("sex"));
				goddess.setBirthday(rs.getDate("birthday"));
				goddess.setEmail(rs.getString("email"));
				goddess.setMobile(rs.getString("mobile"));
				goddess.setCreate_user(rs.getString("create_user"));
				goddess.setCreate_date(rs.getDate("create_date"));
				goddess.setUpdate_user(rs.getString("update_user"));
				goddess.setUpdate_date(rs.getDate("update_date"));
				goddess.setIsdel(rs.getInt("isdel"));
				list.add(goddess);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	/*
	 * 通过id来查询用户信息
	 */
	public Goddess queryOneUser(int id){
		Connection conn = DBUtil.getConnection();
		String sql = " select * from imooc_goddess where id="+id+" ";
		Goddess goddess = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				goddess = new Goddess();
				goddess.setId(rs.getInt("id"));
				goddess.setUser_name(rs.getString("user_name"));
				goddess.setAge(rs.getInt("age"));
				goddess.setSex(rs.getInt("sex"));
				goddess.setBirthday(rs.getDate("birthday"));
				goddess.setEmail(rs.getString("email"));
				goddess.setMobile(rs.getString("mobile"));
				goddess.setCreate_user(rs.getString("create_user"));
				goddess.setCreate_date(rs.getDate("create_date"));
				goddess.setUpdate_user(rs.getString("update_user"));
				goddess.setUpdate_date(rs.getDate("update_date"));
				goddess.setIsdel(rs.getInt("isdel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return goddess;
	}
	
	/*
	 * 通过id删除某条数据
	 */
	public void delete(int id){
		Connection conn = DBUtil.getConnection();
		String sql = " delete from imooc_goddess "+
		" where id=? ";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
