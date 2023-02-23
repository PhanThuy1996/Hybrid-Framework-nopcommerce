package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	// Primitive type/value type: Nguyên thuỷ: Chiếm 1 bộ nhớ nhất định trong RAM
	// Không có các function đi theo
	//1-4: Kiểu số nguyên
	byte bNumber =1;
	short sNumber = 1000;
	int iNumber=10000;
	long lNumber=1000000;
	//5-6: Kiểu số thực
	float fNumber= 16.5f;
	double dnumber=166.8d;
	//7: kiểu ký tự
	char cText = 'c';
	// 8: Kiểu boolean
	boolean bStatus= true;
	
	// Kiểu dữ liệu tham chiếu: Do người dùng định nghĩa
	// Có các function (hàm) đi kèm
	// String
		String city="Ninh Bình";
	// Array: Bao hàm nhiều kiểu dữ liệu khác
	String[] studentAddress = {"Hồ Chí Minh","Hà Nội",city};
	Integer[] studentAge = {15,16,17};
	// Class
	Topic_02_Data_Type topic;
	// Interface
	WebDriver driver;
	// Object
	Object aObject;
	// Collection
	// List/Set/Queue/Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName(""));
	Set<String> allWindows =driver.getWindowHandles() ;
	List<String> productName = new ArrayList<String>(); 
	public static void main(String[] args) {
		
		
	}

}
