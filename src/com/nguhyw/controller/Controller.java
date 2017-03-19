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
	 * �ر�����,�ͷ���Դ.
	 */
	public void close(){
		sc.close();
	}
	
	/*
	 * ���Ů������
	 */
	public void addGoddessMessage(){
		DBDirver db = new DBDirver();
		Goddess goddess = new Goddess();

		controllerGetName(goddess);//��������
		controllerGetSex(goddess);	//�����Ա�
		controllerGetAge(goddess);	//��������
		controllerGetBirthday(goddess); //��������
		controllerGetMobile(goddess);	//�����ֻ���
		controllerGetEmail(goddess);	//��������
		goddess.setCreate_user("nguhyw");
		goddess.setCreate_date(new Date());
		goddess.setUpdate_user("nguhyw");
		goddess.setUpdate_date(new Date());
		goddess.setIsdel(1);
		
		db.addGoddess(goddess); //�����ݿ����������
	}
	
	/*
	 * ����Ů����Ϣ
	 */
	public void updateGoddess(){
		int id;
		DBDirver db = new DBDirver();
		Goddess g = null;
		do{
			System.out.println("������Ů����:");
			id = sc.nextInt();
		}while(id<0 || id>10000);
		
		g = db.queryOneUser(id);
		if(g!=null){
			System.out.println(g.toString());
			
			Goddess newGoddess = new Goddess();
			System.out.println("Ů������"+g.getUser_name()+"�޸�Ϊ:");
			controllerGetName(newGoddess);//��������
			controllerGetSex(newGoddess);	//�����Ա�
			controllerGetAge(newGoddess);	//��������
			controllerGetBirthday(newGoddess); //��������
			controllerGetMobile(newGoddess);	//�����ֻ���
			controllerGetEmail(newGoddess);	//��������
			newGoddess.setUpdate_user("nguhyw");
			newGoddess.setUpdate_date(new Date());
			newGoddess.setIsdel(g.getIsdel());
			newGoddess.setId(g.getId());
			
			db.updateUser(newGoddess);
		}
		else{
			System.out.println("Ů�񲻴���");
		}
	}
	
	/*
	 * ɾ��ȫ�����ݿ��е���Ϣ
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
		System.out.println("ɾ������ܹ�ɾ��"+count+"��Ů����Ϣ");
	}
	
	/*
	 * ��ѯȫ��Ů������,����ʾ����(����Ϣ)
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
			System.out.println("��ѽ ����Ϊ�գ�����������ǵ�Ů���");
		}
	}
	
	/*
	 * ͨ�������ţ���ѯŮ����ϸ��Ϣ
	 */
	public void showOneGoddess(){
		int id;
		DBDirver db = new DBDirver();
		Goddess g = null;
		do{
			System.out.println("������Ů����:");
			id = sc.nextInt();
		}while(id<0 || id>10000);
		
		g = db.queryOneUser(id);
		if(g!=null){
			System.out.println(g.toString());

		}
		else{
			System.out.println("Ů�񲻴���");
		}
	}
	
	/*
	 * ͨ�����ֲ�ѯ��Ϣ
	 */
	public void showGoddessForName(){
		String name=null;
		DBDirver db = new DBDirver();
		List<Goddess> list =  new ArrayList<Goddess>();
		do{
			System.out.println("������Ů������:");
			name = sc.next();
		}while(name == null);
		
		list = db.queryFrom(name,null,null);
		if(list!=null && list.size()>0){
			for (Goddess g : list) {
				System.out.println(g.toString());
			}
		}
		else{
			System.out.println("�޷�ƥ�䵽����Ҫ��Ů��");
		}
	}
	
	/*
	 * ͨ��Ů����ɾ��Ů��
	 */
	public void delGoddess(){
		int id=0;
		Goddess goddess = null;
		DBDirver db = new DBDirver();
		do{
			System.out.println("������Ů����:");
			id = sc.nextInt();
		}while(id<0 || id>10000);
		
		goddess = db.queryOneUser(id);
		
		if(goddess!=null){
			db.delete(id);
			System.out.println("Ů��"+goddess.getUser_name()+" ɾ���ɹ�");
		}
		else{
			System.out.println("Ů�񲻴���");
		}
	}
	
	
	/*
	 * ����̨��������
	 */
	private void controllerGetName(Goddess goddess){
		
		System.out.println("������Ů������:");
		String name = null;
		name = sc.next();
		goddess.setUser_name(name);
		System.out.println("���óɹ�");
	}
	
	/*
	 *����̨�����Ա� 
	 */
	private void controllerGetSex(Goddess goddess){
		int count=0;
		String sex = null;
		while(true)
		{
			System.out.println("������Ů���Ա�:");
			sex = sc.next();
			if(!sex.equals("Ů")){
				count++;
				if(count>=20){
					System.out.println("��ɵ��....");
					System.out.println("��Ϊ�����ȡ��������ϵͳ�Ѿ���Ѫ����..");
					while(true){
						System.out.println("����");
						System.out.println("   ����");
						System.out.println("      ����");
						System.out.println("         ����");
					}
				}
				else if(count==10){
					count++;
					System.out.println("TMD,��ɵ�����������ô���");
				}
				else{
					System.out.println("��Ѿ��ϲ���еİ���");
				}
			}
			else{
				System.out.println("���óɹ�");
				goddess.setSex(1);
				break;
			}
		}
	}
	
	/*
	 * ����̨��������
	 */
	private void controllerGetAge(Goddess goddess){
		int count=0;
		int age =0;
		while(true)
		{
			System.out.println("������Ů������:");
			age = sc.nextInt();
			if(age<=0||age>=200){
				count++;
				if(count>=20){
					System.out.println("��ɵ��....");
					System.out.println("��Ϊ�������������ϵͳ�Ѿ���Ѫ����..");
					while(true){
						System.out.println("����");
						System.out.println("   ����");
						System.out.println("      ����");
						System.out.println("         ����");
					}
				}
				else if(count==10){
					System.out.println("TMD,��ɵ�����������ô���");
				}
				else{
					System.out.println("�����������������");
				}
			}
			else{
				System.out.println("���óɹ�");
				goddess.setAge(age);
				break;
			}
		}
	}
	
	/*
	 * ����Ů������
	 */
	public void controllerGetBirthday(Goddess goddess){
		int year=0,month=0,day=0; //���ڴ洢�û������������
		Calendar c = Calendar.getInstance(); //�½�һ����������
		c.setTime(new Date());	//��ȡ��ǰ����
		
		System.out.println("������Ů�����������");
		while(true){
			System.out.println("�������꣺");
			year = sc.nextInt();
			if(year<=0 || year>= c.get(Calendar.YEAR)){
				System.out.println(" ���ү�ģ������Ұ� ");
			}
			else{
				break;
			}			
		}
		while(true){
			System.out.println("�������£�");
			month = sc.nextInt();
			if(month<=0 || month>12){
				System.out.println(" ���ү�ģ������Ұ� ");
			}
			else{
				break;
			}			
		}
		while(true){
			System.out.println("�������գ�");
			day = sc.nextInt();
			if(day<=0 || day>31){
				System.out.println(" ���ү�ģ������Ұ� ");
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
	 * ��������
	 */
	public void controllerGetEmail(Goddess goddess){
		String email =null;
		do{
			System.out.println("����������:");
			email = sc.next();
		}while(email==null);
		goddess.setEmail(email);
	}
	
	/*
	 * �����ֻ���
	 */
	public void controllerGetMobile(Goddess goddess){
		String mobile=null;
		
		do{
			System.out.println("�������ֻ�����");
			mobile = sc.next();
		}
		while(mobile==null || mobile.indexOf("1")!= 0 || mobile.length()!=11);
		goddess.setMobile(mobile);
	}
}
