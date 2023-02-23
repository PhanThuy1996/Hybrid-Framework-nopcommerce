package javaBasic;

import java.util.Scanner;

public class Topic_01_Variables {
	//biến static
	static boolean studentSex;
	//biến global
	int studentNumber;
	//biến hằng số
	static final int STUDENT_AGE=17;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập CMND:");
		// cách gọi biến global
		Topic_01_Variables topic= new Topic_01_Variables();
		topic.studentNumber = scanner.nextInt();
		// Biến toàn cục
		String studentName="Nguyễn Văn A";
		//Cách gọi biến cục bộ
		System.out.println("Tên:"+studentName);
		
		System.out.println("Số CMND: "+topic.studentNumber);
		// Cách gọi biến hằng số
		System.out.println("Tuổi: "+ STUDENT_AGE);
		// Cách gọi biến tĩnh
		System.out.println("Giới tính: "+ Topic_01_Variables.studentSex);
		
	}

}
