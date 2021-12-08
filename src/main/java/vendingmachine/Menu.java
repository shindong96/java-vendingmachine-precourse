package vendingmachine;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Menu {
	List<Product> products;

	Menu() {
		products = new ArrayList<Product>();
	}

	public void makeMenu() {
		String productListStr = Console.readLine();
		String[] productList = productListStr.split(";");

		for (int i = 0; i < productList.length; i++) {
			String productStr = productList[i].substring(1, productList[i].length() - 1);
			String[] productInfo = productStr.split(",");
			Product product = new Product(productInfo[0], Integer.parseInt(productInfo[1]),
				Integer.parseInt(productInfo[2]));
			products.add(product);
		}

	}
}
