package com.baccara.game;

import java.util.List;

/**
 * 입력 받은 손패의 합을 구하는 클래스
 */
public class HandCalculator {

	//입력받은 손패의 합을 길이와 상관없이 계산해주는 메소드
	public int HandCal(List<String> hand) {
		int total = 0;
		for (int i = 0; i < hand.size(); i++) {
			String oneCard= hand.get(i);
			total += getValue(oneCard);
		}
		return total%10;// 카드의 합을 바카라 계산법에 맞게 1의자리숫자만 반환
	}
	
	//get value의 값을 반환해주는 메소드
	public int getCardValue(String card) {
		return getValue(card);
	}

	//입력받은 카드 한장의 int 값을 반환해주는 메소드
	private static int getValue(String card) {
		String rank = card.substring(1);
		int result=switch (rank) {
		case "A"->1;				
		case "K","Q","J"->10;
		default->Integer.parseInt(rank);
		};
		return result;
	}

}
