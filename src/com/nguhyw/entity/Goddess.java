package com.nguhyw.entity;

import java.util.Date;

public class Goddess {
	private int id;
	private String user_name;
	private int sex;
	private int age;
	private Date birthday;
	private String email;
	private String mobile;
	private String create_user;
	private Date create_date;
	private String update_user;
	private Date update_date;
	private int isdel;
	
	public Goddess(){
		
	}
	
	public Goddess(String user_name, int sex, int age, Date birthday, String email, String mobile, String create_user,
			Date create_date, String update_user, Date update_date, int isdel) {
		super();
		this.user_name = user_name;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.email = email;
		this.mobile = mobile;
		this.create_user = create_user;
		this.create_date = create_date;
		this.update_user = update_user;
		this.update_date = update_date;
		this.isdel = isdel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}

	@Override
	public String toString() {
		return "女神编号=" + id + " 姓名=" + user_name + " 性别(1:女 2:男)=" + sex + ", 年龄=" + age + ", 生日="
				+ birthday + " 邮箱=" + email + " 手机号=" + mobile + " 创建人=" + create_user
				+ " 创建时间=" + create_date + " 更新人=" + update_user + " 更新时间=" + update_date
				+ ", 是否删除(1:否  0:是)=" + isdel + "]";
	}
	
	public String show() {
		return "女神编号:" + id + " 姓名:" + user_name;
	}
	
	
	
}
