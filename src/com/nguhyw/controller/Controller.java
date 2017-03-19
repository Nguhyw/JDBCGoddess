package com.nguhyw.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.nguhyw.dirver.DBDirver;
import com.nguhyw.entity.Goddess;

public class Controller {
	private Scanner sc = new Scanner(System.in);
	
	/*
	 * 关闭输入,释放资源.
	 */
	public void close(){
		sc.close();
	}
	
	/*
	 * 添加女神数据
	 */
	public void addGoddessMessage(){
		DBDirver db = new DBDirver();
		Goddess goddess = new Goddess();

		controllerGetName(goddess);//输入名字
		controllerGetSex(goddess);	//输入性别
		controllerGetAge(goddess);	//输入年龄
		controllerGetBirthday(goddess); //输入生日
		controllerGetMobile(goddess);	//输入手机号
		controllerGetEmail(goddess);	//输入邮箱
		goddess.setCreate_user("nguhyw");
		goddess.setCreate_date(new Date());
		goddess.setUpdate_user("nguhyw");
		goddess.setUpdate_date(new Date());
		goddess.setIsdel(1);
		
		db.addGoddess(goddess); //向数据库中添加数据
	}
	
	/*
	 * 更新女神信息
	 */
	public void updateGoddess(){
		int id;
		DBDirver db = new DBDirver();
		Goddess g = null;
		do{
			System.out.println("请输入女神编号:");
			id = sc.nextInt();
		}while(id<0 || id>10000);
		
		g = db.queryOneUser(id);
		if(g!=null){
			System.out.println(g.toString());
			
			Goddess newGoddess = new Goddess();
			System.out.println("女神姓名"+g.getUser_name()+"修改为:");
			controllerGetName(newGoddess);//输入名字
			controllerGetSex(newGoddess);	//输入性别
			controllerGetAge(newGoddess);	//输入年龄
			controllerGetBirthday(newGoddess); //输入生日
			controllerGetMobile(newGoddess);	//输入手机号
			controllerGetEmail(newGoddess);	//输入邮箱
			newGoddess.setUpdate_user("nguhyw");
			newGoddess.setUpdate_date(new Date());
			newGoddess.setIsdel(g.getIsdel());
			newGoddess.setId(g.getId());
			
			db.updateUser(newGoddess);
		}
		else{
			System.out.println("女神不存在");
		}
	}
	
	/*
	 * 删除全部数据库中的信息
	 */
	public void delAllGoddess(){
		DBDirver db = new DBDirver();
		List<Goddess> list = new ArrayList<Goddess>();
		list = db.getAllUser();
		int count = 0;
		
		if(list!=null && list.size()>0){
			count = list.size();
			for (Goddess g : list) {
				db.delete(g.getId());
			}
		}
		System.out.println("删除完成总共删除"+count+"条女神信息");
	}
	
	/*
	 * 查询全部女神数据,并显示出来(简单信息)
	 */
	public void showAllGoddess(){
		DBDirver db = new DBDirver();
		List<Goddess> list = new ArrayList<Goddess>();
		list = db.getAllUser();
		if(list!=null && list.size()>0){
			for (Goddess g : list) {
				System.out.println(g.show());
			}
		}
		else{
			System.out.println("哎呀 数据为空，快添加你心仪的女神吧");
		}
	}
	
	/*
	 * 通过输入编号，查询女神详细信息
	 */
	public void showOneGoddess(){
		int id;
		DBDirver db = new DBDirver();
		Goddess g = null;
		do{
			System.out.println("请输入女神编号:");
			id = sc.nextInt();
		}while(id<0 || id>10000);
		
		g = db.queryOneUser(id);
		if(g!=null){
			System.out.println(g.toString());

		}
		else{
			System.out.println("女神不存在");
		}
	}
	
	/*
	 * 通过名字查询信息
	 */
	public void showGoddessForName(){
		String name=null;
		DBDirver db = new DBDirver();
		List<Goddess> list =  new ArrayList<Goddess>();
		do{
			System.out.println("请输入女神姓名:");
			name = sc.next();
		}while(name == null);
		
		list = db.queryFrom(name,null,null);
		if(list!=null && list.size()>0){
			for (Goddess g : list) {
				System.out.println(g.toString());
			}
		}
		else{
			System.out.println("无法匹配到你想要的女神");
		}
	}
	
	/*
	 * 通过女神编号删除女神
	 */
	public void delGoddess(){
		int id=0;
		Goddess goddess = null;
		DBDirver db = new DBDirver();
		do{
			System.out.println("请输入女神编号:");
			id = sc.nextInt();
		}while(id<0 || id>10000);
		
		goddess = db.queryOneUser(id);
		
		if(goddess!=null){
			db.delete(id);
			System.out.println("女神"+goddess.getUser_name()+" 删除成功");
		}
		else{
			System.out.println("女神不存在");
		}
	}
	
	
	/*
	 * 控制台输入姓名
	 */
	private void controllerGetName(Goddess goddess){
		
		System.out.println("请输入女神姓名:");
		String name = null;
		name = sc.next();
		goddess.setUser_name(name);
		System.out.println("设置成功");
	}
	
	/*
	 *控制台输入性别 
	 */
	private void controllerGetSex(Goddess goddess){
		int count=0;
		String sex = null;
		while(true)
		{
			System.out.println("请输入女神性别:");
			sex = sc.next();
			if(!sex.equals("女")){
				count++;
				if(count>=20){
					System.out.println("大傻逼....");
					System.out.println("因为你的性取向无下限系统已经吐血身亡..");
					while(true){
						System.out.println("崩溃");
						System.out.println("   崩溃");
						System.out.println("      崩溃");
						System.out.println("         崩溃");
					}
				}
				else if(count==10){
					count++;
					System.out.println("TMD,你傻逼吗，能输错那么多次");
				}
				else{
					System.out.println("你丫的喜欢男的啊，");
				}
			}
			else{
				System.out.println("设置成功");
				goddess.setSex(1);
				break;
			}
		}
	}
	
	/*
	 * 控制台输入年龄
	 */
	private void controllerGetAge(Goddess goddess){
		int count=0;
		int age =0;
		while(true)
		{
			System.out.println("请输入女神年龄:");
			age = sc.nextInt();
			if(age<=0||age>=200){
				count++;
				if(count>=20){
					System.out.println("大傻逼....");
					System.out.println("因为你的智商无下限系统已经吐血身亡..");
					while(true){
						System.out.println("崩溃");
						System.out.println("   崩溃");
						System.out.println("      崩溃");
						System.out.println("         崩溃");
					}
				}
				else if(count==10){
					System.out.println("TMD,你傻逼吗，能输错那么多次");
				}
				else{
					System.out.println("输入错误，请重新输入");
				}
			}
			else{
				System.out.println("设置成功");
				goddess.setAge(age);
				break;
			}
		}
	}
	
	/*
	 * 输入女神生日
	 */
	public void controllerGetBirthday(Goddess goddess){
		int year=0,month=0,day=0; //用于存储用户输入的年月日
		Calendar c = Calendar.getInstance(); //新建一个日历对象
		c.setTime(new Date());	//获取当前日期
		
		System.out.println("请输入女神出生年月日");
		while(true){
			System.out.println("请输入年：");
			year = sc.nextInt();
			if(year<=0 || year>= c.get(Calendar.YEAR)){
				System.out.println(" 你大爷的，你蒙我啊 ");
			}
			else{
				break;
			}			
		}
		while(true){
			System.out.println("请输入月：");
			month = sc.nextInt();
			if(month<=0 || month>12){
				System.out.println(" 你大爷的，你蒙我啊 ");
			}
			else{
				break;
			}			
		}
		while(true){
			System.out.println("请输入日：");
			day = sc.nextInt();
			if(day<=0 || day>31){
				System.out.println(" 你大爷的，你蒙我啊 ");
			}
			else{
				break;
			}			
		}
		String str = year+"-"+month+"-"+day;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(str);
			goddess.setBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 设置邮箱
	 */
	public void controllerGetEmail(Goddess goddess){
		String email =null;
		do{
			System.out.println("请输入邮箱:");
			email = sc.next();
		}while(email==null);
		goddess.setEmail(email);
	}
	
	/*
	 * 设置手机号
	 */
	public void controllerGetMobile(Goddess goddess){
		String mobile=null;
		
		do{
			System.out.println("请输入手机号码");
			mobile = sc.next();
		}
		while(mobile==null || mobile.indexOf("1")!= 0 || mobile.length()!=11);
		goddess.setMobile(mobile);
	}
}
