package vendingmachine;

public class Exception {
	public boolean checkNumberException(String numberStr) {
		try {
			int num = Integer.parseInt(numberStr);

			if (!checkPositiveNumberException(num)) {
				return false;
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_NOT_NUMBER_MESSAGE.toString());
			return false;
		}
	}

	public boolean checkPositiveNumberException(int number) {
		try {

			if (number <= 0) {
				throw new IllegalArgumentException();
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_NOT_POSITIVE_NUMBER_MESSAGE.toString());
			return false;
		}
	}

	public boolean checkMenuException(String[] productInfo) {

	}
}
