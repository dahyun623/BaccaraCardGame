package com.baccara.game;

import java.util.ArrayList;
import java.util.List;

/**
 * 이번 게임에서 사용될 덱을 생성하고 플레이어와 뱅커에게 카드를 뽑아 손패에 넣어주는 클래스
 */
public class Hand {
	public List<String> playerHand; //플레이어의 손패
	public List<String> bankerHand; //뱅커의 손패
	
	/**
	 * 뽑은 카드를 각 손패에 한장씩 번갈아가며 나눠주는 메소드
	 */
	public void makeHand(){
		playerHand = new ArrayList<String>();
		bankerHand = new ArrayList<String>();
		playerHand.add(nextCard());
		bankerHand.add(nextCard());
		playerHand.add(nextCard());
		bankerHand.add(nextCard());
	}
	
	/**
	 * 덱을 생성하고 덱에서 한장을 뽑은 뒤, 뽑은 카드는 덱에서 제거하는 메소드 
	 * @return 덱에서 뽑은 카드
	 */
	public String nextCard() {
		Deck dk = new Deck();
		List<OneCardOfDeck> deck = dk.getAllCards(); // 덱 생성
		String nextCard = deck.get(0).toString(); // 카드 한 장 뽑기
		deck.remove(0); // 덱에서 뽑은 카드를 지우기
		return nextCard;
	}
}//class
