package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_Operator {

	//@Test
	public static void TC_01() {
		String name;
		int age;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mời bạn nhập tên: ");
		name = scanner.nextLine();
		System.out.println("Mời bạn nhập tuổi: ");
		age = scanner.nextInt();
		System.out.println("Sau 15 năm nữa, tuổi của "+name+" sẽ là: "+(age+15));
		
	}
	//@Test
	public static void TC_02() {
		int a= 6;
		int b = 5;
		System.out.println("a: "+a+" b:"+b);
		a= a+b;
		b= a-b;
		a= a-b;
		System.out.println("a: "+a+" b:"+b);
	}
	
	@Test
	public static void TC_03() {
		int a,b;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mời bạn nhập a: ");
		a = scanner.nextInt();
		System.out.println("Mời bạn nhập b: ");
		b = scanner.nextInt();
		if(a>b) {
			System.out.println("a>b: true");
		}
		else System.out.println("a>b: false");
	}
	
	
	
	

}
