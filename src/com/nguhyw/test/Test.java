package com.nguhyw.test;
import java.util.Scanner;

import com.nguhyw.controller.Controller;


public class Test {
	public static void main(String[] args) {
		boolean Life = true;	//���ڿ����˳��˵�
		Test ts = new Test();	
		Controller cr = new Controller();	//������
		Scanner sc = new Scanner(System.in);
		ts.showMenu();	//��ʾ�˵�
		String menu = "";
		
		while(Life){
			
			menu = sc.next();
			if(menu!=null){
				switch(menu){
				case "a":	
					cr.showAllGoddess();	//��ʾ����Ů��ļ�Ҫ��Ϣ
					break;
				case "b":
					cr.showOneGoddess();	//ͨ��id���ҵ���Ů�����ϸ��ϸ��Ϣ
					break;
				case "b2":
					cr.showGoddessForName(); //ͨ�����ֲ��Ҷ�ӦŮ�����ϸ��Ϣ
					break;
				case "c":
					cr.delGoddess();	//ɾ��ĳ��Ů��
					break;
				case "d":
					cr.addGoddessMessage(); //���һ���µ�Ů��
					break;
				case "e":
					cr.updateGoddess(); //�޸�Ů����Ϣ
					break;
				case "clear":
					cr.delAllGoddess(); //������е�Ů��
					break;
				case "q":
					Life = false;
					break;
				default :
					System.out.println("û�и�ѡ��");
					break;
				}
			}
			System.out.println();
			ts.showMenu();	//��ʾ�˵�
		}
		sc.close();//�ͷ���Դ
		cr.close();//�ͷ���Դ
		System.out.println("�˳�ϵͳ.");
	}
	
	
	public void showMenu(){
		System.out.println("----------���˵�------------");
		System.out.println("a: ��ȡŮ����");
		System.out.println("b: ����Ů���Ż�ȡ��ϸ��Ϣ");
		System.out.println("b2: ����Ů������,��ѯŮ����ϸ��Ϣ");
		System.out.println("c: ����Ů����ɾ��Ů��");
		System.out.println("d: ���һ���µ�Ů��");
		System.out.println("e: ����Ů����ϢŮ��");
		System.out.println("clear: �������Ů����ϢŮ��");
		System.out.println("q: �˳�");
		System.out.println("--------------------------");
	}
}
