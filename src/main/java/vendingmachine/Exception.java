package vendingmachine;

import java.util.HashSet;

public class Exception {
	public HashSet<String> nameSet = new HashSet<String>();

	public boolean checkMoneyException(String moneyStr) {
		try {
			int num = Integer.parseInt(moneyStr);

			if (!checkPositiveNumberMoneyException(num) || !checkNumberIsDividedTen(num)) {
				return false;
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_NOT_NUMBER_MONEY__MESSAGE.toString());
			return false;
		}
	}

	public boolean checkPositiveNumberMoneyException(int number) {
		try {

			if (number <= 0) {
				throw new IllegalArgumentException();
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_NOT_POSITIVE_NUMBER_MONEY_MESSAGE.toString());
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

		if (!checkMoneyException(productInfo[1]) || !checkQuantityException(productInfo[2])) {
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

	public boolean checkQuantityException(String quantityStr) {
		try {
			int num = Integer.parseInt(quantityStr);

			if (!checkPositiveNumberQuantityException(num)) {
				return false;
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_NOT_NUMBER_QUANTITY_MESSAGE.toString());
			return false;
		}
	}

	public boolean checkPositiveNumberQuantityException(int number) {
		try {

			if (number <= 0) {
				throw new IllegalArgumentException();
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_NOT_POSITIVE_NUMBER_QUANTITY_MESSAGE.toString());
			return false;
		}
	}

	public boolean checkCanTakeThisOrder(String order, VendingMachine vendingMachine) {
		if (!isThereThisMenu(order, vendingMachine)) {
			return false;
		}

		if (!isThereAnyRemain(order, vendingMachine) || !checkCanBuyThisProductWithRemainMoney(order, vendingMachine)) {
			return false;
		}

		return true;
	}

	public boolean isThereThisMenu(String order, VendingMachine vendingMachine) {
		try {

			if (!vendingMachine.menuName.containsKey(order)) {
				throw new IllegalArgumentException();
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_NO_NAME_IN_MENU_MESSAGE.toString());
			return false;
		}
	}

	public boolean isThereAnyRemain(String order, VendingMachine vendingMachine) {
		try {

			if (!vendingMachine.findQuantityOfOrder(order)) {
				throw new IllegalArgumentException();
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_NO_QUANTITY_MESSAGE.toString());
			return false;
		}
	}

	public boolean checkCanBuyThisProductWithRemainMoney(String order, VendingMachine vendingMachine) {
		try {

			if (vendingMachine.comparePriceAndRemainMoney(order)) {
				throw new IllegalArgumentException();
			}

			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ERROR_CANNOT_BUY_WITH_REMAIN_MESSAGE.toString());
			return false;
		}
	}
}
