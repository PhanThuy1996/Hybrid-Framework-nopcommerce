package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_Switch_Case_Excercise {
	
	public void TC_01_chanLe() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số: ");	
		int a= scanner.nextInt();
		if (a%2==0){
			System.out.println(a + " là số chẵn");
		}
		else {
			System.out.println(a + " là số lẻ");
		}
		
	}
	//@Test
	public void TC_02_soSanh() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập a= ");	
		int a= scanner.nextInt();
		System.out.println("Nhập b= ");	
		int b= scanner.nextInt();
		if (a>b){
			System.out.println(a + " lớn hơn " +b);
		}
		else if(a==b) {
			System.out.println(a + " bằng " +b);
		}
		else {
			System.out.println(a + " nhỏ hơn " +b);
		}
		
	}
	//@Test
	public void TC_03_soSanhTen() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tên 1 = ");	
		String a= scanner.nextLine();
		System.out.println("Tên 2= ");	
		String b= scanner.nextLine();
		if (a.equalsIgnoreCase(b)){
			System.out.println("Hai người là cùng tên");
		}
		else {
			System.out.println("Hai người là khác tên");
		}
		
	}
	//@Test
	public void TC_04_timSoLonNhat() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập a= ");	
		int a= scanner.nextInt();
		System.out.println("Nhập b= ");	
		int b= scanner.nextInt();
		System.out.println("Nhập c= ");	
		int c= scanner.nextInt();
		if (a>b&&a>c){
			System.out.println(a + " lớn nhất ");
		}
		else if(b>a && b>c) {
			System.out.println(b + " lớn nhất");
		}
		else {
			System.out.println(c + " lớn nhất");
		}
		
	}
	//@Test
	public void TC_05_timSoCoTrongKhoang() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập a= ");	
		int a= scanner.nextInt();
		
		if (a>=10&&a<=100){
			System.out.println(a + " nằm trong khoảng 10-100 ");
		}
		else {
			System.out.println(a + " không nằm trong khoảng 10-100");
		}
	}
	//@Test
	public void TC_06_kiemTraDiemSV() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập a= ");	
		float diem= scanner.nextFloat();
		
		if (diem>=0&&diem<=5){
			System.out.println(" Điểm D");
		}
		else if (diem>5&&diem<7.5) {
			System.out.println(" Điểm C");
		}
		else if (diem>=7.5&&diem<8.5) {
			System.out.println(" Điểm B");
		}
		else {
			System.out.println(" Điểm A");
		}
	}
	@Test
	public void TC_07_kiemTraThang() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập tháng= ");	
		int thang= scanner.nextInt();
		
		if (thang==1||thang==3||thang==5||thang==7||thang==8||thang==10||thang==12){
			System.out.println(" Tháng " +thang+" có 31 ngày");
		}
		else if(thang==4||thang==6||thang==9||thang==11) {
			System.out.println(" Tháng " +thang+" có 30 ngày");
		}
		else {
			System.out.println(" Tháng " +thang+" có 28 ngày");
		}
		
	}
}
