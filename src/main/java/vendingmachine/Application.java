package vendingmachine;

public class Application {
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();

		System.out.println(Constants.PREPARING_COIN_MESSAGE.toString());
		vendingMachine.prepareChanges();
		// TODO: 프로그램 구현
	}
}
