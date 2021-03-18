package step02;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyPhoneBook {

	public static List<String> list = new LinkedList<>();
	
	public static void showMenu() {
		
		System.out.println("---원하는 기능을 선택하세요---");
		System.out.println("1. 전화번호 입력");
		System.out.println("2. 전화번호 조회");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 프로그램 종료");
		
	}
	public static void selectMenu() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			showMenu();
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				addNumber();
				break;
			case 2:
				//조회 메소드
				break;
			case 3: 
				//삭제 메소드
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 숫자를 누르셨습니다.");
			}
			
		}
	}
	
	public static void addNumber() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---전화번호 입력---");
		System.out.println("이름을 입력하세요.");
		String name = sc.next();
		System.out.println("전화번호를 입력하세요.");
		String phoneNumber = sc.next();
		System.out.println("이메일을 입력하세요. 없다면 그냥 엔터를 눌러주세요");
		String email = sc.next();
		sc.nextLine();
		
		PhoneInfo addNum;
		if(email != " ") {
			addNum = new PhoneInfo(name, phoneNumber, email);
		}
		else {
			addNum = new PhoneInfo(name, phoneNumber);
		}
		
		addNum.showPhoneInfo();
	}
	public static void main(String[] args) 
	{
			
		PhoneInfo pInfo1 = new PhoneInfo("손오공", "010-1234-5678", "test1@test.com");
		PhoneInfo pInfo2 = new PhoneInfo("전우치", "010-4321-8765");
		
		selectMenu();
		

	}

}
