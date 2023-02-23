package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Data_Type_Excercise {
	@Test
	public static void TC01_TinhToan() {
		int a = 6;
		int b = 2;
		System.out.println("Tổng a+b="+(a+b));
		System.out.println("Hiệu a-b="+(a-b));
		System.out.println("Tích a*b="+(a*b));
		System.out.println("Thương a/b="+(a/b));
	}
	
	@Test
	public static void TC02_TinhDienTich() {
		float width = 3.8f;
		float height = 7.5f;
		System.out.println("Diện tích hình chữ nhật là: "+(width*height));
	
	}
	
	@Test
	public static void TC03_InChuoi() {
		String name = "Automation Testing";
		System.out.println("Hello "+name);
	
	}
	

}
