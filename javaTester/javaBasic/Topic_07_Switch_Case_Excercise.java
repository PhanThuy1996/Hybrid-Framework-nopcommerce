package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_Switch_Case_Excercise {
	//@Test
	public void TC_01_inSoTiengAnh() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số: ");	
		int a= scanner.nextInt();
		switch (a){
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;			
		case 3:
			System.out.println("Three");
			break;			
		case 4:
			System.out.println("Four");
			break;			
		case 5:
			System.out.println("Five");
			break;			
		case 6:
			System.out.println("Six");
			break;			
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;			
		case 10:
			System.out.println("Ten");
			break;
		default:
			System.out.println("Not belong from one to ten");
			break;
		}
	}
	//@Test
	public void TC_02_tinhToan() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập a= ");	
		int a= scanner.nextInt();
		System.out.println("Nhập b= ");	
		int b= scanner.nextInt();
		System.out.println("Nhập phép toán = ");
		char toanTu = scanner.next().charAt(0);
		switch (toanTu){
		case '+':
			System.out.println("a+b="+(a+b));
			break;
		case '-':
			System.out.println("a-b="+(a-b));
			break;			
		case '*':
			System.out.println("a*b="+(a*b));
			break;			
		case '/':
			System.out.println("a/b="+(a/b));
			break;			
		case '%':
			System.out.println("a%b="+(a%b));
			break;
		default:
			System.out.println("Không thể tính");
			break;
		}
	}
	
	//@Test
	public void TC_03_hienThiNgayTrongThang() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập tháng= ");	
		int thang= scanner.nextInt();
		switch (thang){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(" Tháng " +thang+" có 31 ngày");
			break;
		case 2:
			System.out.println(" Tháng " +thang+" có 28 ngày");
			break;			
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(" Tháng " +thang+" có 30 ngày");
			break;	
		default:
			System.out.println("Bạn nhập sai tháng. Vui lòng nhập lại!");
		}
		
	}

}
