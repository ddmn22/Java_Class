package step06;
import java.util.Scanner;
import java.util.Set;

import step06.PhoneInfo;

import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.io.Writer;

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
//		pInfo.showPhoneInfo();
		map.put(name, pInfo);
		System.out.println("맵의 크기 : " + map.size());
		
	}
	
	//연락처 조회
	public static void selNumber() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---전화번호 조회---");
		System.out.print("이름 : ");
		String name = sc.nextLine();

//		디버그용
//		Set<String> ks = map.keySet();
//		for(String s : ks)
//			System.out.println(s + " : " + map.get(s).toString());
//		System.out.println("------------------------------");
		
		PhoneInfo pInfo = map.get(name);
		if(pInfo != null)
			pInfo.showPhoneInfo();
		else
			System.out.println("[" + name + "] 데이터가 없습니다.");
		
	}
	
	//전화번호 삭제
	public static void delNumber() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---전화번호 삭제---");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		PhoneInfo pInfo = map.remove(name);
		if(pInfo != null) {
			System.out.println("[" + name + "] 데이터를 삭제했습니다.");
			pInfo.showPhoneInfo();
		}else
			System.out.println("[" + name + "] 데이터가 없습니다.");
		
		
		//내가 만든 코드
//		PhoneInfo pInfo = map.get(name);
//		if(pInfo != null) {
//			map.remove(name);
//			System.out.println("[" + name + "] 데이터를 삭제했습니다.");
//		}else
//			System.out.println("[" + name + "] 데이터가 없습니다.");
		
		//디버그용
//		Set<String> ks = map.keySet();
//		for(String s : ks)
//			System.out.println(s + " : " + map.get(s).toString());
//		System.out.println("------------------------------");
	}
	
	// 프로그램 종료 시 데이터 저장
	public static void saveInfo() {
		try(ObjectOutputStream oo =
				new ObjectOutputStream(new FileOutputStream("Object.bin"))){
			
			Set<String> ks = map.keySet();
			for(String s : ks) {
				PhoneInfo pInfo = map.get(s);
				oo.writeObject(pInfo);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
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
				delNumber();
				break;
			case 4:
				saveInfo();
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

		selectMenu();
	}
	
	

}
