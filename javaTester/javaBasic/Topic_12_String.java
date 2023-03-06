package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_12_String {
	//@Test
	public void TC_01_demChuHoa() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập chuỗi: ");	
		String chuoiKyTu= scanner.nextLine();
		int dem =0;
		for(int i = 0;i<chuoiKyTu.length();i++) {
			char kyTu= chuoiKyTu.charAt(i);
			if (kyTu>='A'&&kyTu<='Z') {
				dem=dem+1;
			}
		}
		System.out.println("Số ký tự in hoa trong chuỗi là: " + dem);
	}
	//@Test
	public void TC_02_indemchuoi() {
	
		String chuoiKyTu= "Automation Testing 345 Tutorials Online 789 ";
		int dem =0;
		for(int i = 0;i<chuoiKyTu.length();i++) {
			char kyTu= chuoiKyTu.charAt(i);
			if (kyTu=='a'||kyTu=='A') {
				dem=dem+1;
			}
		}
		System.out.println("Số ký tự a trong chuỗi là: " + dem);
	
		if(chuoiKyTu.contains("Testing")) {
			System.out.println("Chuoi co chua Testing: true");
		}else {
			System.out.println("Chuoi co chua Testing: false");
		}
		
		if(chuoiKyTu.startsWith("Automation")) {
			System.out.println("Chuoi bat dau bang Automation: true");
		}else {
			System.out.println("Chuoi bat dau bang Automation: false");
		}
		
		if(chuoiKyTu.endsWith("Online")) {
			System.out.println("Chuoi ket thuc bang Online: true");
		}else {
			System.out.println("Chuoi ket thuc bang Online: false");
		}
		
		int vitri = chuoiKyTu.indexOf("Tutorials");
		System.out.println("Vi tri cua Tutorials:"+vitri);
		chuoiKyTu=chuoiKyTu.replace("Online", "Offline");
		System.out.println(chuoiKyTu);
		
		int demSo =0;
		for(int i = 0;i<chuoiKyTu.length();i++) {
			char kyTu= chuoiKyTu.charAt(i);
			if (kyTu=='0'||kyTu=='1'||kyTu=='2'||kyTu=='3'||kyTu=='4'||kyTu=='5'||kyTu=='6'||kyTu=='7'||kyTu=='8'||kyTu=='9') {
				demSo=demSo+1;
			}			
		}
		System.out.println("Số trong chuỗi là: " + demSo);
	}
	@Test
	public void TC_03_chuoiNguoc() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập chuỗi: ");	
		String chuoiKyTu= scanner.nextLine();
			for(int i = chuoiKyTu.length()-1;i>=0;i--) {
				char kyTu= chuoiKyTu.charAt(i);
				System.out.print(kyTu);
			}
		
		}	
	
}
