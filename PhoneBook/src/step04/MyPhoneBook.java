package step04;
import java.util.Scanner;

import step04.PhoneInfo;

import java.util.HashMap;
import java.util.Collections;

public class MyPhoneBook {

	static Scanner sc = new Scanner(System.in);
	static HashMap<String, PhoneInfo> map = new HashMap<>();
	
	
	//메뉴 프린트
	public static void showMenu() {
		
		System.out.println("---원하는 기능을 선택하세요---");
		System.out.println("1. 전화번호 입력");
		System.out.println("2. 전화번호 조회");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 프로그램 종료");
		
	}
	
	//전화번호 입력
	public static void addNumber() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---전화번호 입력---");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("전화번호 : ");
		String phoneNumber = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		PhoneInfo pInfo;
		if(email != null && !email.equals("")) {
			pInfo = new PhoneInfo(name, phoneNumber, email);
		}
		else {
			pInfo = new PhoneInfo(name, phoneNumber);
		}
		pInfo.showPhoneInfo();
		map.put(name, pInfo);
		System.out.println("맵의 크기 : " + map.size());
		
	}
	
	//연락처 조회
	public static void selNumber() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---전화번호 조회---");
		System.out.print("이름 : ");
		String name = sc.nextLine();
	
		PhoneInfo getInfo = (PhoneInfo)map.get(name);
		
		getInfo.showPhoneInfo();
		
	}
	
	//메뉴 선택
	public static void selectMenu() {
		
		while(true) {
			
			showMenu();
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				addNumber();
				break;
			case 2:
				selNumber();
				break;
			case 3: 
				//delNumber();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 숫자를 누르셨습니다.");
				break;
			}
			
		}
	}
	
	
	public static void main(String[] args) 
	{
		PhoneInfo pInfo1 = new PhoneInfo("손오공", "010-1234-5678", "test1@test.com");
		PhoneInfo pInfo2 = new PhoneInfo("전우치", "010-4321-8765");
		
		map.put("손오공", pInfo1);
		map.put("전우치", pInfo2);
		selectMenu();
	}

}
