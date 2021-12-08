package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class User {
	Exception exception = new Exception();

	public void insertMoney(VendingMachine vendingMachine) {
		System.out.println(Constants.INSERT_MONEY_MESSAGE.toString());
		while (true) {
			String moneyStr = Console.readLine();
			if (exception.checkNumberException(moneyStr)) {
				vendingMachine.insertMoney(Integer.parseInt(moneyStr));
				return;
			}
		}
	}

	public String order() {
		System.out.println(Constants.ORDER_MENU_NAME.toString());
		String orderedMenuName = Console.readLine();
		return orderedMenuName;
	}
}
