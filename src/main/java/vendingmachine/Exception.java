package vendingmachine;

public class Exception {
	public boolean checkNumberException(String numberStr) {
		try {
			System.out.println(numberStr);
			int num = Integer.parseInt(numberStr);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_NOT_NUMBER_MESSAGE.toString());
			return false;
		}
	}

	public boolean checkMenuException(String[] productInfo) {
		
	}
}
