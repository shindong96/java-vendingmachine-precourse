package vendingmachine;

public class Application {
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		Menu menu = new Menu();
		User user = new User();

		System.out.println(Constants.PREPARING_COIN_MESSAGE.toString());
		vendingMachine.prepareChanges();
		System.out.println(Constants.INPUT_MENU_MESSAGE.toString());
		menu.makeMenu();
		// TODO: 프로그램 구현
	}
}
