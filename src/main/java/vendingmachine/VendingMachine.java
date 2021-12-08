package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class VendingMachine {
	public List<Product> menu;
	public Exception exception;

	public List<Integer> numberOfCoins;
	public Map<String, Integer> menuName;
	public int changes;
	public int remainMoney;

	VendingMachine() {
		numberOfCoins = new ArrayList<Integer>();
		menu = new ArrayList<Product>();
		menuName = new HashMap<String, Integer>();
		exception = new Exception();
		changes = 0;
		remainMoney = 0;
	}

	public void init() {
		System.out.println(Constants.PREPARING_COIN_MESSAGE.toString());
		prepareChanges();
		printNumberOfCoins();

		System.out.println(Constants.INPUT_MENU_MESSAGE.toString());
		insertMenu();
	}

	public void prepareChanges() {

		while (true) {
			String changesCoinStr = Console.readLine();

			if (exception.checkNumberException(changesCoinStr)) {
				changes = Integer.parseInt(changesCoinStr);
				break;
			}

		}

		for (Coin coin : Coin.values()) {
			changes = coin.prepareChanges(changes, numberOfCoins);
		}

	}

	public void insertMenu() {

		while (true) {
			String productListStr = Console.readLine();

			if (makeMenu(productListStr)) {
				break;
			}

			menu.clear();
		}

	}

	public boolean makeMenu(String productListStr) {
		String[] productList = productListStr.split(";", -1);

		for (int i = 0; i < productList.length; i++) {
			String productStr = productList[i].substring(1, productList[i].length() - 1);
			String[] productInfo = productStr.split(",", -1);

			if (exception.checkMenuException(productInfo)) {
				return false;
			}

			menuName.put(productInfo[0], i);
			menu.add(new Product(productInfo[0], Integer.parseInt(productInfo[1]), Integer.parseInt(productInfo[2])));
		}

		return true;
	}

	public void printNumberOfCoins() {
		System.out.println(Constants.PREPARED_NUMBER_OF_COINS_MESSAGE.toString());

		for (Coin coin : Coin.values()) {
			System.out.println(coin.getAmount() + " - " + numberOfCoins.get(coin.ordinal()) + "개");
		}

	}

	public void insertMoney(int money) {
		remainMoney = money;
	}

	public boolean receiveOrder(String userOrder) {

		if (menuName.get(userOrder) != null) {

			if (menu.get(menuName.get(userOrder)).quantity > 0 && remainMoney >= menu.get(
				menuName.get(userOrder)).price) {
				menu.get(menuName.get(userOrder)).quantity -= 1;
				remainMoney -= menu.get(menuName.get(userOrder)).price;
				return true;
			}

		}

		return false;
	}

	public boolean endOrder() {

		for (Product product : menu) {

			if (product.price <= remainMoney && product.quantity > 0) {
				return false;
			}

		}

		return true;
	}

	public void printResult() {
		System.out.println(Constants.PRINT_CHANGES);

		for (Coin coin : Coin.values()) {

			if (remainMoney >= coin.getAmount()) {
				countQuantityOfCoin(coin);

			}
		}

	}

	public void countQuantityOfCoin(Coin coin) {
		int quantity = remainMoney / coin.getAmount();

		if (quantity > numberOfCoins.get(coin.ordinal())) {
			quantity = numberOfCoins.get(coin.ordinal());
		}

		printChanges(coin.getAmount(), quantity);

		remainMoney -= coin.getAmount() * quantity;
	}

	public void printChanges(int amount, int quantity) {

		if (quantity == 0) {
			return;
		}

		System.out.println(amount + " - " + quantity + "개");
	}

}
