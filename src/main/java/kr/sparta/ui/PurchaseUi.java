package kr.sparta.ui;

import kr.sparta.domain.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//상품이 추가되는 시점에서 중복체크를 해야한다.

public class PurchaseUi {

    private BasketUi basketUi = BasketUi.getInstance();
    private BufferedReader in;

    private PurchaseUi() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    private static PurchaseUi instance = new PurchaseUi();

    public static PurchaseUi getInstance() {
        return instance;
    }

    public void printPurchasePage(Product product) {

        while (true) {
            System.out.println("--------------------------------------------");
            System.out.printf("%-10s     | W %d | %s\n", product.getName(), product.getPrice(), product.getDescription());
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
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
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

}
