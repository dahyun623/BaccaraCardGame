package com.baccara.game;

/**
 * 유저가 입력한 베팅 값과 베팅한 금액을 저장하는 클래스
 * 
 * @author KJT
 */
public class BettingResult {
	/**
	 * 게임 결과를 int로 받아 user가 베팅한 정수와 비교하여 user가 베팅한 금액을 계산하는 메소드
	 * 
	 * @param gameResult = 게임 결과, vrvr = 유저가 베팅한 금액
	 * @return long result
	 */
	public long winMoney(int gameResult, long vrvr) {// gameResult 는 1~4중 하나
		long result = 0;
		switch (gameResult) {
		case 1:
			result = vrvr * 2;
			System.out.println("플레이어 승리");
			break;
		case 2:
			result = vrvr * 2;
			System.out.println("뱅커 승리");
			break;
		case 3:
			result = vrvr * 9;
			System.out.println("타이 승리");
			break;
		case 4:
			result = vrvr * 12;
			System.out.println("페어 승리");
			break;
		default:
			break;

		}// switch
		return result;

	}// winMoney()

	/**
	 * 게임의 결과가 int로 변환된 값을 입력받아 해당 결과를 출력하는 메소드
	 * 
	 * @param GameResult
	 */
	public void gameResultPrint(int GameResult) {
		if (GameResult == 1) {
			System.out.println("-----플레이어가 승리 하였습니다-----");
		} else if (GameResult == 2) {
			System.out.println("------뱅커가 승리 하였습니다------");
		} else if (GameResult == 3) {
			System.out.println("--------타이 입니다--------");
		} else if (GameResult == 4) {
			System.out.println("--------페어 입니다--------");
		}

	}

	/**
	 * 게임의 결과, 유저 베팅, 유저 소지금의 최종 결과를 출력하는 메소드
	 * 
	 * @param (int)GameResult
	 * @param (int)n
	 * @param (long)totalMoney
	 */
	public void betResult(int GameResult, int n, long totalMoney) {

		if (n == GameResult) {
			System.out.println("ᕕ( ᐛ )ᕗ 베팅에 성공 하셨습니다 ᕕ( ᐛ )ᕗ\n 현재 소지금:" + totalMoney + "원");

		} else {
			System.out.println("(˃̣̣̣̣︿˂̣̣̣̣ ) 베팅에 실패 하셨습니다 (˃̣̣̣̣︿˂̣̣̣̣ )\n 현재 소지금:" + totalMoney + "원");
		}

	}

}// Class