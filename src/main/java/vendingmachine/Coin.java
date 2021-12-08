package vendingmachine;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int prepareChanges(int money, List<Integer> numberOfCoins) {

		if (amount == 10) {
			numberOfCoins.add(money / amount);
			return 0;
		}

		int limit = money / amount;
		List<Integer> randomNumberList = makeRandomNumberList(limit);
		int numberOfCoin = Randoms.pickNumberInList(randomNumberList);
		numberOfCoins.add(numberOfCoin);

		return money - numberOfCoin * amount;
	}

	private List<Integer> makeRandomNumberList(int limit) {
		List<Integer> numberList = new ArrayList<Integer>();

		for (int i = 0; i <= limit; i++) {
			numberList.add(i);
		}

		return numberList;
	}

	public int getAmount() {
		return this.amount;
	}

	// 추가 기능 구현
}
