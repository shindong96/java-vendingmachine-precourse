package vendingmachine.util;

import vendingmachine.constants.ErrorMessage;

public class NameException {

	public static String checkNameException(String productName) {
		try {
			checkNameIsBlank(productName);
			checkSpaceInProductName(productName);
			checkTabInProductName(productName);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		return productName;
	}

	public static void checkNameIsBlank(String name) {
		if (name.equals("")) {
			throw new IllegalArgumentException(ErrorMessage.BLANK_PRODUCT_NAME_MESSAGE);
		}
	}

	public static void checkSpaceInProductName(String name) {
		String[] tmp = name.split(" ", -1);

		if (tmp.length != 1) {
			throw new IllegalArgumentException(ErrorMessage.SPACE_IN_PRODUCT_NAME_MESSAGE);
		}

	}

	public static void checkTabInProductName(String name) {
		String[] tmp = name.split("\t", -1);

		if (tmp.length != 1) {
			throw new IllegalArgumentException(ErrorMessage.TAB_IN_PRODUCT_NAME_MESSAGE);
		}

	}
}
