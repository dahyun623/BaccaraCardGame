package com.baccara.game;

/**
 * 플레이어와 뱅커의 패를 비교하는 클래스 
 */
public class HandCompare {
	
	//게임의 결과를 판단하는 메소드
	public int gameResultReturn(int playerHand, int bankerHand ) {
		char result=0;
		if(playerHand>bankerHand) {//플레이어 승리
			result=1;
		}else if(playerHand<bankerHand) {//뱅커 승리
			result= 2;
		}else if(playerHand==bankerHand){//타이
			result=3;
		}
		return result;
	}
}