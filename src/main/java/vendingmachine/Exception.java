package vendingmachine;

public class Exception {
	public boolean checkNumberException(String numberStr) {
		try {
			int num = Integer.parseInt(numberStr);

			if (!checkPositiveNumberException(num) || !checkNumberIsDividedTen(num)) {
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

	public boolean checkNumberIsDividedTen(int number) {
		try {

			if (number % 10 != 0) {
				throw new IllegalArgumentException();
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_NOT_DIVIDED_TEN_NUMBER_MESSAGE.toString());
			return false;
		}
	}

	public boolean checkMenuException(String[] productInfo) {

		if (!checkArraySize(productInfo)) {
			return false;
		}

	}

	public boolean checkArraySize(String[] productInfo) {
		try {

			if (productInfo.length != 3) {
				throw new IllegalArgumentException();
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_ARRAY_SIZE_MESSAGE.toString());
			return false;
		}
	}
}
