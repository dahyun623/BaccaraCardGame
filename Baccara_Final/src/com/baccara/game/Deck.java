package com.baccara.game;

import java.util.ArrayList;
import java.util.List;

/**
 * OneCardOfDeck 클래스에서 카드들을 받아 덱을 구성하는 클래스
 */
public class Deck {

	private List<OneCardOfDeck> cardcase;//덱
	
	public Deck() {
		cardcase= new ArrayList<OneCardOfDeck>();
		make();
	}
	
	public List<OneCardOfDeck> getAllCards(){
		return cardcase;
	}
	
	public List<OneCardOfDeck> make() {//덱 생성 메소드
		int cnt=0;
		while (true) {
			OneCardOfDeck card = new OneCardOfDeck();
			if(!cardcase.contains(card)) {//랜덤으로 받은 카드 중복체크
				cardcase.add(card);
				cnt++;
			}
			if(cnt==OneCardOfDeck.SHAPE.length*OneCardOfDeck.NUMBER.length) {
				for (int i = 0; i < 3; i++) {//8개의 덱으로 구성된 하나의 덱을 만들어줌
					cardcase.addAll(cardcase);
				}
				break;
			}
		}
		return cardcase;
	}
	
	@Override
	public String toString() {
		return "Deck [make()=" + make() + "]";
	}

}
