package vendingmachine;

import java.util.HashSet;

public class Exception {
	public HashSet<String> nameSet = new HashSet<String>();

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
		nameSet.clear();

		if (!checkArraySize(productInfo) || !checkSpaceInProductName(productInfo[0]) || !checkTabInProductName(
			productInfo[0]) || !checkNameReduplication(productInfo[0], nameSet)) {
			return false;
		}

		if (!checkNumberException(productInfo[1]) || !checkNumberException(productInfo[2])) {
			return false;
		}

		return true;
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

	public boolean checkSpaceInProductName(String name) {
		String[] tmp = name.split(" ", -1);
		try {

			if (tmp.length != 1) {
				throw new IllegalArgumentException();
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_SPACE_IN_PRODUCT_NAME_MESSAGE.toString());
			return false;
		}
	}

	public boolean checkTabInProductName(String name) {
		String[] tmp = name.split("\t", -1);
		try {

			if (tmp.length != 1) {
				throw new IllegalArgumentException();
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_TAB_IN_PRODUCT_NAME_MESSAGE.toString());
			return false;
		}
	}

	public boolean checkNameReduplication(String name, HashSet<String> nameSet) {
		try {

			if (nameSet.contains(name)) {
				throw new IllegalArgumentException();
			}

			nameSet.add(name);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_REDUPLICATION_NAME_MESSAGE.toString());
			return false;
		}
	}

}
