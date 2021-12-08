package vendingmachine;

public class Order {
	public VendingMachine vendingMachine;
	public User user;

	Order(VendingMachine vendingMachine, User user) {
		this.vendingMachine = vendingMachine;
		this.user = user;
	}

	public void chooseProduct() {
		System.out.println(Constants.PRINT_USER_MONEY.toString() + " : " + vendingMachine.changes);
		String userOrder = user.order();

		if (vendingMachine.receiveOrder(userOrder)) {
			
		}
	}
}
