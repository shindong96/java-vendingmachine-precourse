package vendingmachine.view;

import vendingmachine.constants.InputMessage;
import vendingmachine.constants.OutputMessage;
import vendingmachine.constants.Rule;
import vendingmachine.model.Coin;

public class VendingMachineView {
	public void askInitCoins() {
		System.out.println(InputMessage.PREPARING_COIN_MESSAGE);
	}

	public void askProductsInfo() {
		System.out.println("\n" + InputMessage.INPUT_MENU_MESSAGE);
	}

	public void askInsertMoney() {
		System.out.println("\n" + InputMessage.INSERT_MONEY_MESSAGE);
	}

	public void askOrderMenu() {
		System.out.println(InputMessage.ORDER_MENU_NAME);
	}

	public void printInitCoinsComment() {
		System.out.println("\n" + OutputMessage.PREPARED_NUMBER_OF_COINS_MESSAGE);
	}

	public void printCoin(int countCoin, Coin coin) {
		System.out.println(coin.getAmount() + Rule.AMOUNT_UNIT + Rule.DASH + countCoin + Rule.QUANTITY_UNIT);
	}

	public void printRemainOfInsertedMoney(int remainMoney) {
		System.out.println("\n" + OutputMessage.PRINT_USER_MONEY + remainMoney + Rule.AMOUNT_UNIT);
	}

	public void printChangesComment(int remainMoney) {
		printRemainOfInsertedMoney(remainMoney);
		System.out.println(OutputMessage.PRINT_CHANGES);
	}

}
