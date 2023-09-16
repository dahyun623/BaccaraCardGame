package com.baccara.game;

/**
 * 정해진 문양과 카드를 랜덤으로 조합하여 카드를 한장 만드는 클래스
 * @since 2023.05.24
 */
public class OneCardOfDeck {
	private String one;

	public static final String[] SHAPE = {"◆","♥","♠","♣"};
	public static final String[] NUMBER = {"A","2","3","4","5","6","7","8","9","10","K","Q","J"};

	public OneCardOfDeck() {
		int s =(int)(Math.random()*SHAPE.length);
		int n = (int)(Math.random()*NUMBER.length);
		one=SHAPE[s]+NUMBER[n];
	}

	public String getOne() {
		return one;
	}

	@Override
	public String toString() {
		return String.format("%s",one);
	}
}
