package kr.sparta.ui;

import kr.sparta.domain.Product;
import kr.sparta.util.PriceParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddToBasketConfirmUi {

    private final BasketUi basketUi = BasketUi.getInstance();
    private final BufferedReader in;
    private PriceParser priceParser = PriceParser.getInstance();

    private AddToBasketConfirmUi() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    private static final AddToBasketConfirmUi instance = new AddToBasketConfirmUi();

    public static AddToBasketConfirmUi getInstance() {
        return instance;
    }

    public void printPurchasePage(Product product) {

        while (true) {
            System.out.println("--------------------------------------------");
            System.out.printf("%-10s     | W %s | %s\n", product.getName(), priceParser.parsePrice(product.getPrice()), product.getDescription());
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");
            System.out.println("--------------------------------------------");

            int choice = getNumber();
            if (choice == 1) {
                basketUi.addToBasket(product);
                break;
            } else if (choice == 2) {
                break;
            } else {
                printError();
            }
        }
    }

    public int getNumber() {
        try {
            int choice = Integer.parseInt(in.readLine());
            return choice;
        } catch (Exception e) {
            return -1;
        }
    }

    public void printError() {
        System.out.println("[ 잘못된 입력입니다. 다시 시도해 주세요. ]");
        System.out.println("--------------------------------------------");
    }

}