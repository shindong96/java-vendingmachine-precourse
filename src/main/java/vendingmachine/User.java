package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class User {
	int money;

	public void insertMoney() {
		System.out.println(Constants.INSERT_MONEY_MESSAGE.toString());
		String moneyStr = Console.readLine();
		money = Integer.parseInt(moneyStr);
	}

	public String order() {
		System.out.println(Constants.PRINT_USER_MONEY.toString() + " : " + money);
		System.out.println(Constants.ORDER_MENU_NAME.toString());
		String orderedMenuName = Console.readLine();
		return orderedMenuName;
	}
}
