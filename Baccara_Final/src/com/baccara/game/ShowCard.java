package com.baccara.game;

import java.util.List;

/**
 * 카드 손패를 한장씩 출력하는 클래스 
 */
public class ShowCard {
	public void show(List<String> playerHand,List<String> bankerHand ) throws InterruptedException {


		String playerCard1 = playerHand.get(0);
		String playerCard2 = playerHand.get(1);
		String bankerCard1 = bankerHand.get(0);
		String bankerCard2 = bankerHand.get(1);



		System.out.println("-------플레이어 카드 오픈------");
		System.out.println("Player: " + playerCard1 + "　" + "*"); 
		System.out.println("Banker: " + "ㅤ*" + " " + "*"); 
		Thread.sleep(2000);
		System.out.println("--------벵커 카드 오픈--------");
		System.out.println("Player: " + playerCard1 + "　" + "*"); 
		System.out.println("Banker: " + bankerCard1 + "　" + "*");
		Thread.sleep(2000); // sleep을 사용해 카드를 나중에 오픈하는 효과를 보여줌
		System.out.println("-------플레이어 카드 오픈------");
		System.out.println("Player: " + playerCard1 + "　" + playerCard2);
		System.out.println("Banker: " + bankerCard1 + "　" + "*");
		Thread.sleep(2000);
		System.out.println("--------벵커 카드 오픈--------");
		System.out.println("Player: " + playerCard1 + "　" + playerCard2);
		System.out.println("Banker: " + bankerCard1 + "　" + bankerCard2);
	}
}
