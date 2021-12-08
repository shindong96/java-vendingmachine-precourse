package vendingmachine;

public class Application {
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		User user = new User();

		vendingMachine.init();
		user.insertMoney(vendingMachine);

		Order order = new Order(vendingMachine, user);
		boolean end = false;

		while (!end) {
			end = order.chooseProduct();
		}
		// TODO: 프로그램 구현
	}
}
