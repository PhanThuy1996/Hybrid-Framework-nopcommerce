package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_11_Array {
	//@Test
	public void TC_01_timSoLonNhatTrongMang() {	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số lượng phần tử trong mảng");
		int number = scanner.nextInt();
		int[] A= new int[number];
		for(int i = 0; i<number;i++) {
			System.out.print("Nhập A["+i+"]: ");
			A[i]=scanner.nextInt();
		}
		System.out.println("Mảng là:");
		for(int i = 0; i<number;i++) {
			System.out.print(A[i]+" ");
		}
		int max = 0;
		for(int i = 0; i<number;i++) {
			if(A[i]>max) {
				max=A[i];
			}
		}
		System.out.println("\nSố lớn nhất trong mảng lả: "+max);
		
	}
	//@Test
	public void TC_02_inThang() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử trong mảng: ");
		int number = scanner.nextInt();
		int[] A= new int[number];
		for(int i = 0; i<number;i++) {
			System.out.print("\nNhập A["+i+"]: ");
			A[i]=scanner.nextInt();
		}
		
		System.out.println("Mảng là:");
		for(int i = 0; i<number;i++) {
			System.out.print(A[i]+" ");
		}	
		int tong = A[0]+A[number-1];
		System.out.println("\nTổng số thứ 1 và cuối cùng trong mảng là: "+tong);
		
	}
	//@Test
	public void TC_03_inSoChanTrongMang() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử trong mảng: ");
		int number = scanner.nextInt();
		int[] A= new int[number];
		for(int i = 0; i<number;i++) {
			System.out.print("\nNhập A["+i+"]: ");
			A[i]=scanner.nextInt();
		}
		
		System.out.println("Mảng là:");
		for(int i = 0; i<number;i++) {
			System.out.print(A[i]+" ");
		}	
		System.out.println("Các số chẵn trong mảng là:");
		for(int i = 0; i<number;i++) {
			if(A[i]%2==0)
			System.out.print(A[i]+" ");
		}
		
	}
	//@Test
	public void TC_04_inTongSoLeTrongMang() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử trong mảng: ");
		int number = scanner.nextInt();
		int[] A= new int[number];
		for(int i = 0; i<number;i++) {
			System.out.print("\nNhập A["+i+"]: ");
			A[i]=scanner.nextInt();
		}
		
		System.out.println("Mảng là:");
		for(int i = 0; i<number;i++) {
			System.out.print(A[i]+" ");
		}	
		int tong=0;
		for(int i = 0; i<number;i++) {
			if(A[i]%2==1&&A[i]>0)
			tong = tong +A[i];
		}
		System.out.println("\nTổng các số lẻ trong mảng là:"+tong);
	}
	//@Test
	public void TC_05_inSoDuongTrongMang() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử trong mảng: ");
		int number = scanner.nextInt();
		int[] A= new int[number];
		for(int i = 0; i<number;i++) {
			System.out.print("\nNhập A["+i+"]: ");
			A[i]=scanner.nextInt();
		}
		
		System.out.println("Mảng là:");
		for(int i = 0; i<number;i++) {
			System.out.print(A[i]+" ");
		}	
		System.out.println("\nCác số dương nhỏ hơn 10 trong mảng là:");
		for(int i = 0; i<number;i++) {
			if(A[i]>0&&A[i]<=10)
				System.out.println(A[i]+" ");
		}
		
	}
	@Test
	public void TC_06_inTongVaTrungBinhCong() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số lượng phần tử trong mảng: ");
		int number = scanner.nextInt();
		int[] A= new int[number];
		for(int i = 0; i<number;i++) {
			System.out.print("\nNhập A["+i+"]: ");
			A[i]=scanner.nextInt();
		}
		
		System.out.println("Mảng là:");
		for(int i = 0; i<number;i++) {
			System.out.print(A[i]+" ");
		}	
		int tong = 0;
		for(int i = 0; i<number;i++) {
			tong = tong+A[i];
		}
		int TBCong= tong/number;
		System.out.println("Tổng của mảng là: "+tong);
		System.out.println("Trung bình cộng của mảng là: "+TBCong);
		
	}
}
