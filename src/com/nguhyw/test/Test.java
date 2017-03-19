package com.nguhyw.test;
import java.util.Scanner;

import com.nguhyw.controller.Controller;


public class Test {
	public static void main(String[] args) {
		boolean Life = true;	//用于控制退出菜单
		Test ts = new Test();	
		Controller cr = new Controller();	//控制器
		Scanner sc = new Scanner(System.in);
		ts.showMenu();	//显示菜单
		String menu = "";
		
		while(Life){
			
			menu = sc.next();
			if(menu!=null){
				switch(menu){
				case "a":	
					cr.showAllGoddess();	//显示所有女神的简要信息
					break;
				case "b":
					cr.showOneGoddess();	//通过id查找单个女神的详细详细信息
					break;
				case "b2":
					cr.showGoddessForName(); //通过名字查找对应女神的详细信息
					break;
				case "c":
					cr.delGoddess();	//删除某个女神
					break;
				case "d":
					cr.addGoddessMessage(); //添加一个新的女神
					break;
				case "e":
					cr.updateGoddess(); //修改女神信息
					break;
				case "clear":
					cr.delAllGoddess(); //清空所有的女神
					break;
				case "q":
					Life = false;
					break;
				default :
					System.out.println("没有该选项");
					break;
				}
			}
			System.out.println();
			ts.showMenu();	//显示菜单
		}
		sc.close();//释放资源
		cr.close();//释放资源
		System.out.println("退出系统.");
	}
	
	
	public void showMenu(){
		System.out.println("----------主菜单------------");
		System.out.println("a: 获取女神简介");
		System.out.println("b: 输入女神编号获取详细信息");
		System.out.println("b2: 输入女神姓名,查询女神详细信息");
		System.out.println("c: 输入女神编号删除女神");
		System.out.println("d: 添加一个新的女神");
		System.out.println("e: 更新女神信息女神");
		System.out.println("clear: 清空所有女神信息女神");
		System.out.println("q: 退出");
		System.out.println("--------------------------");
	}
}
