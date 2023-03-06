package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_10_BreakContinue {
	//@Test
	public void TC_01_inTrinhDuyet() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập trình duyệt: ");	
		String browser= scanner.nextLine();
		switch(browser) {
		case "Firefox":
			System.out.println(browser);
			break;
		case "IE":	
			break;
		case "Safari":
			System.out.println(browser);
			break;
		case "Chrome":
			System.out.println(browser);
			break;
		case "Opera":
			System.out.println(browser);
			break;
		default:
			System.out.println("Nhập lại tên trình duyệt");
		}
	}
	//@Test
	public void TC_02_inThang() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập tháng: ");	
		int month= scanner.nextInt();
		switch(month) {
		case 1:
			System.out.println("JAN");
			break;
		case 2:	
			System.out.println("FEB");
			break;
		case 3:
			System.out.println("MAR");
			break;
		case 4:
			System.out.println("APR");
			break;
		case 5:
			System.out.println("MAY");
			break;
		case 6:
			System.out.println("JUN");
			break;
		case 7:
			System.out.println("JUL");
			break;
		case 8:
			System.out.println("AUG");
			break;
		case 9:
			System.out.println("SEP");
			break;
		case 10:
			System.out.println("OCT");
			break;
		case 11:
			System.out.println("NOV");
			break;
		case 12:
			System.out.println("DEC");
			break;
		default:
			System.out.println("Nhập lại tháng");
		}
	
	}
	
	
}
