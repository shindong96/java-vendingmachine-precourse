package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Order {
	public VendingMachine vendingMachine;
	public User user;
	public Exception exception;

	Order(VendingMachine vendingMachine, User user) {
		this.vendingMachine = vendingMachine;
		this.user = user;
		exception = new Exception();
	}

	public boolean chooseProduct() {
		System.out.println(Constants.PRINT_USER_MONEY.toString() + vendingMachine.remainMoney);
		String userOrder;

		System.out.println(Constants.ORDER_MENU_NAME.toString());
		userOrder = repeatOrderUntilReceive();

		vendingMachine.receiveOrder(userOrder);

		if (vendingMachine.endOrder()) {
			System.out.println(Constants.PRINT_USER_MONEY.toString() + vendingMachine.remainMoney);
			vendingMachine.printResult();
			return true;
		}

		return false;
	}

	public String repeatOrderUntilReceive() {
		String userOrder;

		while (true) {
			userOrder = Console.readLine();

			if (exception.checkCanTakeThisOrder(userOrder, vendingMachine)) {
				return userOrder;
			}
		}

	}

}
