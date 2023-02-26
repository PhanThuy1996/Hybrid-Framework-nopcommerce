package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_For_ForEach {
	//@Test
	public void TC_01_inSo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số n = ");	
		int n= scanner.nextInt();
		for (int i = 1;i<=n;i++) {
			System.out.print(i+" ");
		}
	}
	//@Test
	public void TC_02_inSoTrongKhoang() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số a = ");	
		int a= scanner.nextInt();
		System.out.println("Nhập số b = ");	
		int b= scanner.nextInt();
		if (a<=b) {
		for (int i = a;i<=b;i++) {
			System.out.print(i+" ");
		}
		}
		else {
			for (int i = b;i<=a;i++) {
				System.out.print(i+" ");
			}
		}
	
	}
	
	//@Test
	public void TC_03_tong() {
		int tong = 0;
		for (int i = 1;i<=10;i++) {
			if(i%2==0) {
				tong = tong+i;
			}
		}
		System.out.println("Tổng là: "+tong);	
	}
	//@Test
	public void TC_04_tinhTong() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Nhập số a = ");	
			int a= scanner.nextInt();
			System.out.println("Nhập số b = ");	
			int b= scanner.nextInt();
			int tong = 0;
			if (a<=b) {
				for (int i = a;i<=b;i++) {
					tong = tong+i;
				}
				}
				else {
					for (int i = b;i<=a;i++) {
						tong = tong+i;
					}
				}
	
			System.out.println("Tổng là: "+tong);	
	}	
	//@Test
	public void TC_05_tinhTongSoLe() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số a = ");	
		int a= scanner.nextInt();
		int tong = 0;		
			for (int i = 1;i<=a;) {
				tong = tong+i;
				i=i+2;
			}
		System.out.println("Tổng là: "+tong);	
	}	
	//@Test
	public void TC_06_timSoChiaHetCho3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số a = ");	
		int a= scanner.nextInt();
		System.out.println("Nhập số b = ");	
		int b= scanner.nextInt();		
			for (int i = a;i<=b;i++) {
				if (i%3==0) {
					System.out.println(i);
				}
			}
	}	
	@Test
	public void TC_07_tinhGiaiThua() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số a = ");	
		int a= scanner.nextInt();
		int giaiThua = 1;
			for (int i = 1;i<=a;i++) {
				giaiThua= giaiThua*i;
			}
		System.out.println("Giai thua cua "+a+" la:" +giaiThua);
	}	
}
