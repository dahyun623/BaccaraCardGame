package com.baccara.game;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 사용자로부터 입력을 받는 클래스
 * @since 2023.05.24
 */
public class Input {

	/**
	 * 베팅을 선택하기 위한 숫자를 입력받는 메소드 
	 * 1. 플레이어 2. 뱅커 3. 타이 4. 페어
	 */
	public static int DefineUtil() {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int userInput; 
		 while (true) {
	            System.out.println("배팅을 선택해주십시오");
	            if (scanner.hasNextInt()) {
	            	userInput = scanner.nextInt();
	                if (userInput >= 1 && userInput <= 5) { // 선택지 안의 숫자가 입력될 시 진행
	                    break;
	                }
	            }
	            scanner.nextLine();
	            System.out.println("잘못된 입력입니다. 재입력 해주십시오."); // 선택지 바깥을 입력했을 경우 재입력
	        }

	        return userInput;
	    }
	
	/**
	 * 베팅할 금액을 입력받아 반환하는 메소드
	 * @return
	 */
	public static long getInputMoney() {
		Scanner scanner = new Scanner(System.in);
		long inputMoney = 0;

		try {
			System.out.println("배팅 금액을 입력해주세요");
			inputMoney = scanner.nextLong();
		} catch (InputMismatchException e) {
			System.out.println("정수를 입력해주세요");
		}
		System.out.println("당신의 배팅금은: " + inputMoney);
		return inputMoney;
	}
	
	/**
	 * 정수 값을 입력받아 게임을 재시작하는 메소드
	 */
	public static int restart() {
		Scanner scanner = new Scanner(System.in);
		int select = 0;
		try {
			System.out.println("게임을 다시 시작하시겠습니까?");
			System.out.println("   [1]네  [2]아니요");
			select = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("정수를 입력해주세요");
		}
		return select;
	}
}
