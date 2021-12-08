package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachine {
	public List<Integer> numberOfCoins;
	public List<Product> menu;
	public Map<String, Integer> menuName;
	public int changes;

	VendingMachine() {
		numberOfCoins = new ArrayList<Integer>();
		menu = new ArrayList<Product>();
		menuName = new HashMap<String, Integer>();
		changes = 0;
	}

	public void init() {
		System.out.println(Constants.PREPARING_COIN_MESSAGE.toString());
		prepareChanges();
		System.out.println(Constants.INPUT_MENU_MESSAGE.toString());
		makeMenu();
	}

	public void prepareChanges() {
		int changes = Integer.parseInt(Console.readLine());

		for (Coin coin : Coin.values()) {
			changes = coin.prepareChanges(changes, numberOfCoins);
		}

		printNumberOfCoins();
	}

	public void makeMenu() {
		String productListStr = Console.readLine();
		String[] productList = productListStr.split(";");

		for (int i = 0; i < productList.length; i++) {
			String productStr = productList[i].substring(1, productList[i].length() - 1);
			String[] productInfo = productStr.split(",");
			menuName.put(productInfo[0], i);
			menu.add(new Product(productInfo[0], Integer.parseInt(productInfo[1]), Integer.parseInt(productInfo[2])));
		}

	}

	public void printNumberOfCoins() {
		System.out.println(Constants.PREPARED_NUMBER_OF_COINS_MESSAGE.toString());

		for (Coin coin : Coin.values()) {
			System.out.println(coin.getAmount() + " - " + numberOfCoins.get(coin.ordinal()) + "개");
		}

	}

	public void insertMoney(int money) {
		changes = money;
	}

}
