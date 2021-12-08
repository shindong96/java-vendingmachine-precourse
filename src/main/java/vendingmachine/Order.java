package vendingmachine;

public class Order {
	public VendingMachine vendingMachine;
	public User user;

	Order(VendingMachine vendingMachine, User user) {
		this.vendingMachine = vendingMachine;
		this.user = user;
	}

	public boolean chooseProduct() {
		System.out.println(Constants.PRINT_USER_MONEY.toString() + vendingMachine.changes);
		String userOrder = user.order();

		if (vendingMachine.receiveOrder(userOrder)) {

			if (vendingMachine.endOrder()) {
				System.out.println(Constants.PRINT_USER_MONEY.toString() + " : " + vendingMachine.changes);
				vendingMachine.printResult();
				return true;
			}

		}

		return false;
	}

}
