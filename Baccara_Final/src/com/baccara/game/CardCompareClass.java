package com.baccara.game;


import java.util.List;
/**
 * 페어 체크 클래스
 */
public class CardCompareClass {

		/**
		 * 패를 받아서 패의 2장의 카드의 수나 문자를 비교해서 페어를 판단하는 메소드
		 * @return true 페어
		 */
		public boolean checkPair(List<String> hand) {
			boolean isc = false;								
			char hand1Num = hand.get(0).charAt(1);
			char hand2Num = hand.get(1).charAt(1);
			// charAt을 사용해 잘려진 인자를 비교해 같다면 true 반환 :하트1:k, :스페이드:k -> k, k
			if (hand1Num == hand2Num) {						
				isc = true;
			}
			return isc;
		
		
	}
}