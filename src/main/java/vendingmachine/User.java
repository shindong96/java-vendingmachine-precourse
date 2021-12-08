package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class User {

	public void insertMoney(VendingMachine vendingMachine) {
		System.out.println(Constants.INSERT_MONEY_MESSAGE.toString());
		String moneyStr = Console.readLine();
		vendingMachine.insertMoney(Integer.parseInt(moneyStr));
	}

	public String order() {
		System.out.println(Constants.ORDER_MENU_NAME.toString());
		String orderedMenuName = Console.readLine();
		return orderedMenuName;
	}
}
