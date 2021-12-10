package vendingmachine.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constants.ErrorMessage;

public class Menu {
	public Set<String> nameList;
	public List<Product> menuList;

	public Menu() {
		nameList = new HashSet<String>();
		menuList = new ArrayList<Product>();
	}

	public void setProductList() {
		menuList = makeProductList();
	}

	public List<Product> makeProductList() {
		List<Product> productList = new ArrayList<Product>();
		try {
			String productListStr = Console.readLine();
			String[] productStrList = productListStr.split(";", -1);

			for (int i = 0; i < productStrList.length; i++) {
				productList.add(new Product(productStrList[i]));
			}

		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return makeProductList();
		}
	}
}
