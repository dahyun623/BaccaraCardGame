package com.baccara.game;

/**
 * 게임진행 클래스
 * @since 2023.05.24
 */
public class BaccaraGame {// 바카라 게임을 진행하는 클래스


	public void BaccaraGamePlay() throws InterruptedException{
		long mymoney = 500000000;
		System.out.println(" ______   ___   _____  _____   ___  ______   ___  ");
		System.out.println("| ___ \\ / _ \\ /  __ \\|  __ \\ / _ \\| ___ \\ / _ \\ ");
		System.out.println("| |_/ // /_\\ \\| /  \\/| |  \\/| /_\\ \\| |_/ // /_\\ \\");
		System.out.println("| ___ \\|  _  || |    | |    |  _  ||    / |  _  |");
		System.out.println("| |_/ /| | | || \\__/\\| \\__/\\| | | || |\\ \\ | | | |");
		System.out.println("\\____/ \\_| |_/ \\____/ \\____/\\_| |_/\\_| \\_||_| |_|");
		System.out.println("초기자금: "+mymoney+"원");
		while(true) {
			int n = 0;//배팅선택지 초기화
			n =bet();//배팅선택지 입력
			long b = 0;//배팅금 초기화
			b = betMoney(mymoney);//배팅금 입력
			mymoney-=b;//소지금-배팅금
			Deck d = new Deck();
			d.getAllCards();//덱 생성
			Hand h = new Hand();
			h.makeHand();//플레이어 뱅커 2장씩 패 생성
			ShowCard sc = new ShowCard();
			sc.show(h.playerHand, h.bankerHand);//플레이어 뱅커 한장씩 출력
			CardCompareClass csc = new CardCompareClass();
			BettingResult br = new BettingResult();
			//페어
			if(csc.checkPair(h.playerHand)) {//플레이어 패의 2카드가 같은 수나 문자일 경우
				long totalMoneyP = mymoney;
				if(n==4) { // 페어 선택지인 4번을 입력했고 내부의 페어 값인 4와 동일할 경우 지정된 금액을 반환
					totalMoneyP+=br.winMoney(4,b);
				}
				else{
					totalMoneyP = mymoney;
				}
				br.gameResultPrint(4);//게임 결과 출력
				br.betResult(4,n,totalMoneyP);//배팅 결과+남은 소지금 출력
				mymoney=totalMoneyP;
				if(mymoney<=0) {
					System.out.println("ԅ( ิิ∇ ิิ ԅ) 파산하셨습니다 ԅ( ิิ∇ ิิ ԅ)");
					System.out.println("플레이해주셔서 감사합니다");
					break;
				}
				if(gameRestart()) {//게임재시작여부
					continue;
				}
				System.out.println("플레이해주셔서 감사합니다");
				break;
			}
			else if(csc.checkPair(h.bankerHand)) { //페어 선택지인 4번을 입력했고 내부의 페어 값인 4와 동일할 경우 지정된 금액을 반환
				long totalMoneyP = mymoney;
				if(n==4) {
					totalMoneyP+=br.winMoney(4,b);
				}
				else{
					totalMoneyP = mymoney;
				}
				br.gameResultPrint(4);//게임 결과 출력
				br.betResult(4,n,totalMoneyP);//배팅 결과+남은 소지금 출력
				mymoney=totalMoneyP;
				if(mymoney<=0) {
					System.out.println("ԅ( ิิ∇ ิิ ԅ) 파산하셨습니다 ԅ( ิิ∇ ิิ ԅ)");
					System.out.println("플레이해주셔서 감사합니다");
					break;
				}
				if(gameRestart()) {//게임재시작여부
					continue;
				}
				System.out.println("플레이해주셔서 감사합니다");
				break;
			}
			HandCalculator hc = new HandCalculator();
			int playerHandSum = hc.HandCal(h.playerHand);//플레이어 패합을 계산
			HitAndStay has = new HitAndStay(); // 플레이어와 뱅커의 패의 합에 따라 hit와 stay를 결정하는 인스턴스
			HandCalculator hs = new HandCalculator(); //받은 패의 합을 계산하는 인스턴스
			HandCompare hc1 = new HandCompare(); // 게임의 승부를 결정짓는 인스턴스
			switch (has.shouldPlayerStay(playerHandSum)) {//플레이어 패합에 따라 플레이어 추가행동
			case 1:// 네추럴
				int grn = hc1.gameResultReturn(hs.HandCal(h.playerHand), hs.HandCal(h.bankerHand));
				long totalMoney = mymoney;
				if(grn==n) {//사용자가 배팅을 올바르게 맞췄을 때
					totalMoney += br.winMoney(grn,b);//소지금에 배팅성공반환금을 더해준다
				}else {
					totalMoney=mymoney;
				}
				br.gameResultPrint(grn);//게임 결과 출력
				br.betResult(grn,n,totalMoney);//배팅 결과+남은 소지금 출력
				mymoney=totalMoney;
				break;

			case 2:// 플레이어가 히트
				String 플레이어다음카드 =h.nextCard();
				h.playerHand.add(플레이어다음카드);// 플레이어 히트일 경우 랜덤한 패 한 장을 추가
				if(has.shouldBankerStay(hs.HandCal(h.bankerHand), 플레이어다음카드)) {
					String 뱅커다음카드 =h.nextCard(); // 플레이어 3번째 카드를 룰에 의해 뱅커도 hit 판단
					h.bankerHand.add(뱅커다음카드);
				}
			    Thread.sleep(2000);
				System.out.println("--------최종 카드 패---------");
				System.out.println("Player: " + h.playerHand);
				System.out.println("Banker: " + h.bankerHand);
				long totalMoney1 = mymoney;
				int gr = hc1.gameResultReturn(hs.HandCal(h.playerHand), hs.HandCal(h.bankerHand));
				if(gr==n) {//사용자가 배팅을 올바르게 맞췄을 때
					totalMoney1 +=br.winMoney(gr,b);//소지금에 배팅성공반환금을 더해준다
				}else {
					totalMoney1=mymoney;
				}
				br.gameResultPrint(gr);//게임 결과 출력
				br.betResult(gr,n,totalMoney1);//배팅 결과+남은 소지금 출력
				mymoney=totalMoney1;
				break;
			case 3:// 플레이어가 스탠드
				if(has.shouldBankerStay(hs.HandCal(h.bankerHand))) {// 게임 룰에 의해 첫 패의 합을 보고 stay판단 됐을경우
					String 뱅커다음카드 =h.nextCard();
					h.bankerHand.add(뱅커다음카드);
				}
			    Thread.sleep(2000);
				System.out.println("--------최종 카드 패---------");
				System.out.println("Player: " + h.playerHand);
				System.out.println("Banker: " + h.bankerHand);
				long totalMoney2 = mymoney;
				int grs = hc1.gameResultReturn(hs.HandCal(h.playerHand), hs.HandCal(h.bankerHand));
				if(grs==n) {//사용자가 배팅을 올바르게 맞췄을 때
					totalMoney2 +=br.winMoney(grs,b);//소지금에 배팅성공반환금을 더해준다
				}else {
					totalMoney2=mymoney;
				}
				br.gameResultPrint(grs);//게임 결과 출력
				br.betResult(grs,n,totalMoney2);//배팅 결과+남은 소지금 출력
				mymoney=totalMoney2;
				break;

			}
			if(mymoney<=0) {
				System.out.println("ԅ( ิิ∇ ิิ ԅ) 파산하셨습니다 ԅ( ิิ∇ ิิ ԅ)");
				System.out.println("플레이해주셔서 감사합니다");
				break;
			}
			if(gameRestart()) {//게임재시작여부
				continue;
			}
			System.out.println("플레이해주셔서 감사합니다");
			break;

		}

	}
	public boolean gameRestart() {// 1번 입력시 게임 재시작 2번 입력시 게임 종료 
		boolean a = false;
		int select = Input.restart();
		if(select == 1) {
			a = true;
		}
		else if(select ==2) {
			a = false;
		}
		return a;
	}

	
	public int bet() { // 선택지를 입력받는 스캔 메소드
		int choice = 0;
		System.out.println("원하는 곳에 배팅을 선택해 주십시오");
		System.out.println("1. Player , 2. Banker 3. TIE 4. PAIR" );
		choice = Input.DefineUtil();
		return choice;
	}

	public long betMoney(long mymoney) {//배팅금액을 입력받고 반환하는 메소드
		long ba = 0;
		while(true) {
			ba = Input.getInputMoney();
			if (ba > mymoney) {
				System.out.println("소지금을 넘는 배팅은 불가능합니다.");
				continue;
			}
			else {
				break;
			}
		}
		return ba;

	}

}



