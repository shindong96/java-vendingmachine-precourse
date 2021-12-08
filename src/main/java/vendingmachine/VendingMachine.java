package vendingmachine;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachine {
	public List<Integer> numberOfCoins;
	public Menu menu;

	VendingMachine() {
		numberOfCoins = new ArrayList<Integer>();
		menu = new Menu();
	}

	public void init() {
		System.out.println(Constants.PREPARING_COIN_MESSAGE.toString());
		prepareChanges();
		System.out.println(Constants.INPUT_MENU_MESSAGE.toString());
		menu.makeMenu();
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
