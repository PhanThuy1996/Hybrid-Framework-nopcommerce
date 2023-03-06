package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_DoWhile {
	//@Test
	public void TC_01_inSoChan() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số n = ");	
		int n= scanner.nextInt();
		while (n<=100) {
			if(n%2==0) {
				System.out.print(n+" ");
			}else
			{
				System.out.print(n+1+" ");
			}
			n=n+2;
		}
	}
	//@Test
	public void TC_02_inSoTrongKhoangChiaHetCho3Va5() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số a = ");	
		int a= scanner.nextInt();
		System.out.println("Nhập số b = ");	
		int b= scanner.nextInt();
		while (a<=b) {
			if(a%3==0&&a%5==0) {
				System.out.print(a+" ");
			}
			a=a+1;
		}
	
	}
	
	//@Test
	public void TC_03_tongSoLeTrongKhoang() {
		int tong = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số n = ");	
		int n= scanner.nextInt();
		int i= 1;
		while (i<=n) {
			tong = tong+i;
			i=i+2;
		}
		System.out.println("Tổng các số lẻ trong khoảng 1-n là: "+tong);
	}
	//@Test
	public void TC_04_timSoChiaHetCho3TrongKhoang() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số a = ");	
		int a= scanner.nextInt();
		System.out.println("Nhập số b = ");	
		int b= scanner.nextInt();
		while (a<=b) {
			if(a%3==0) {
				System.out.print(a+" ");
			}
			a=a+1;
		}
	}	
	//@Test
	public void TC_05_tinhGiaiThua() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số a = ");	
		int a= scanner.nextInt();
		int giaiThua = 1;
		int i =1;
			while(i<=a)
			{
				giaiThua= giaiThua*i;
				i++;
			}
		System.out.println("Giai thua cua "+a+" la:" +giaiThua);
	}	
	//@Test
	public void TC_06_timSoChanTrongKhoang() {
		
		int i = 0;
		while(i<=10) {
			if(i%2==0)
				{System.out.print(i+ " ");}
			i++;		
		}
			
	}	
	
}
