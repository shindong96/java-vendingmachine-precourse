package vendingmachine;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachine {
	public List<Integer> numberOfCoins;

	VendingMachine() {
		numberOfCoins = new ArrayList<Integer>();
	}

	public void prepareChanges() {
		int changes = Integer.parseInt(Console.readLine());

		for (Coin coin : Coin.values()) {
			changes = coin.prepareChanges(changes, numberOfCoins);
		}

		printNumberOfCoins();
	}

	public void printNumberOfCoins() {
		System.out.println(Constants.PREPARED_NUMBER_OF_COINS_MESSAGE.toString());

		for (Coin coin : Coin.values()) {
			System.out.println(coin.getAmount() + " - " + numberOfCoins.get(coin.ordinal()) + "개");
		}

	}

}
