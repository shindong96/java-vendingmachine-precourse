package vendingmachine;

public final class Constants {
	public static final String PREPARING_COIN_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String PREPARED_NUMBER_OF_COINS_MESSAGE = "자판기가 보유한 동전";

	public static final String INPUT_MENU_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String INSERT_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";
	public static final String PRINT_USER_MONEY = "투입 금액 : ";
	public static final String ORDER_MENU_NAME = "구매할 상품명을 입력해 주세요.";

	public static final String PRINT_CHANGES = "잔돈";

	public static final String ERROR_NOT_NUMBER_MONEY__MESSAGE = "[ERROR] 금액은 숫자만 입력할 수 있습니다.";
	public static final String ERROR_NOT_POSITIVE_NUMBER_MONEY_MESSAGE = "[ERROR] 금액은 0보다 큰 숫자만 입력할 수 있습니다.";
	public static final String ERROR_NOT_DIVIDED_TEN_NUMBER_MESSAGE = "[ERROR] 1 단위의 금액은 투입할 수 없습니다.";

	public static final String ERROR_ARRAY_SIZE_MESSAGE = "[ERROR] 상품 정보가 잘못되었습니다.";
	public static final String ERROR_SPACE_IN_PRODUCT_NAME_MESSAGE = "[ERROR] 상품 이름에 공백이 있으면 안됩니다.";
	public static final String ERROR_TAB_IN_PRODUCT_NAME_MESSAGE = "[ERROR] 상품 이름에 탭이 있으면 안됩니다.";
	public static final String ERROR_REDUPLICATION_NAME_MESSAGE = "[ERROR] 상품 이름이 중복입니다.";

	public static final String ERROR_NOT_NUMBER_QUANTITY_MESSAGE = "[ERROR] 수량은 숫자만 입력할 수 있습니다.";
	public static final String ERROR_NOT_POSITIVE_NUMBER_QUANTITY_MESSAGE = "[ERROR] 수량은 0보다 큰 숫자만 입력할 수 있습니다.";

	public static final String ERROR_NO_NAME_IN_MENU_MESSAGE = "[ERROR] 주문하신 상품은 메뉴에 없습니다.";
	public static final String ERROR_NO_QUANTITY_MESSAGE = "[ERROR] 주문하신 상품은 품절입니다.";

}
