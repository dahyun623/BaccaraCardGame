package com.baccara.game;

/**
 * 플레이어와 뱅커의 추가행동을 결정하는 클래스 
 */
public class HitAndStay {

	// 플레이어가 Hit 또는 Stay 판단 메소드
	public int shouldPlayerStay(int playerTotal) { // 토탈 값을 인수로 받아서 비교 연산
		int result = 0;
		if (playerTotal >= 8) {// 네추럴
			result = 1; // 플레이어 또는 뱅커가 8 또는 9인 경우, 더 이상 카드를 뽑지 않음
		} else if (playerTotal <= 5) {//히트
			result = 2; // 플레이어의 총점이 5 이하인 경우, 카드를 더 뽑아야 함
		} else {//스탠드
			result = 3; // 그 외의 경우, 플레이어는 카드를 더 뽑지 않음
		}
		return result;
	}

	/**
	 * 플레이어가 스탠드 했을 떄의 행동 메소드
	 * @return true는 뱅커가 카드를 뽑는다
	 */
	public boolean shouldBankerStay(int bankerTotal) {
		System.out.println("플레이어 스테이");
		if (bankerTotal <= 5) {
			System.out.println("뱅커 히트");
			return true; // 플레이어가 Stay를 선택하고, 뱅커의 총점이 5 이하인 경우, 카드를 뽑음
		}
		else {
			System.out.println("뱅커 스테이");
			return false;
		}

	}

	/**
	 * 플레이어가 히트 했을 떄의 행동 메소드
	 * @return true는 뱅커가 카드를 뽑는다
	 */
	public boolean shouldBankerStay(int bankerTotal, String playerThirdCard) {
		HandCalculator hc = new HandCalculator(); 
		int ptc = hc.getCardValue(playerThirdCard);
		//플레이어 히트
		System.out.println("플레이어 히트");
		if (bankerTotal <= 2) {
			System.out.println("뱅커 스탠드");
			return false; // 뱅커의 총점이 2 이하인 경우, 더 이상 카드를 뽑지 않음
		} else if (bankerTotal == 3 && ptc != 8) {
			System.out.println("뱅커 스탠드");
			return false; // 뱅커의 총점이 3이고, 플레이어의 총점이 8이 아닌 경우, 더 이상 카드를 뽑지 않음
		} else if (bankerTotal == 4 && ptc >= 2 && ptc <= 7) {
			System.out.println("뱅커 스탠드");
			return false; // 뱅커의 총점이 4이고, 플레이어의 총점이 2 이상 7 이하인 경우, 더 이상 카드를 뽑지 않음
		} else if (bankerTotal == 5 && ptc >= 4 && ptc <= 7) {
			System.out.println("뱅커 스탠드");
			return false; // 뱅커의 총점이 5이고, 플레이어의 총점이 4 이상 7 이하인 경우, 더 이상 카드를 뽑지 않음
		} else if (bankerTotal == 6 && ptc >= 6 && ptc <= 7) {
			System.out.println("뱅커 스탠드");
			return false; // 뱅커의 총점이 6이고, 플레이어의 총점이 6 이상 7 이하인 경우, 더 이상 카드를 뽑지 않음
		}
		System.out.println("뱅커 히트");
		return true; // 그 외의 경우, 뱅커는 카드를 뽑음
	}
}
