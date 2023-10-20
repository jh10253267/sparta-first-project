package kr.sparta.ui;

import kr.sparta.domain.Basket;
import kr.sparta.domain.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasketUi {
    private final BufferedReader in;
    private OrderConfirmUi orderConfirmUi = OrderConfirmUi.getInstance();
    private static final List<Product> productList = new ArrayList<>();
    private static Basket basket = new Basket(productList);
    private static int totalPrice = 0;


    private BasketUi() {
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    private static final BasketUi instance = new BasketUi();

    public static BasketUi getInstance() {
        return instance;
    }

    public void printMyBasket() throws InterruptedException, SQLException {
        int totalBasketPrice = basket.getTotalBasketPrice();
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("지금과 같이 주문하시겠습니까?");
            System.out.println();
            System.out.println("[ ORDERS ]");
            for (Product p : basket.getBasket()) {
                System.out.printf("%-10s| W %d | %d개 | %s\n", p.getName(), p.getPrice(), p.getOrderCount(), p.getDescription());
            }
            System.out.println();
            System.out.println("[ Total ]");
            System.out.printf("W %d\n", totalBasketPrice);
            System.out.println();
            System.out.println("1. 주문      2. 메뉴판");
            System.out.println("--------------------------------------------");
            int choice = getNumber();

            if (choice == 1) {
                if (basket.isEmpty()) {
                    System.out.println("장바구니가 비어있습니다.");
                    System.out.println("메뉴 화면으로 돌아갑니다.");
                    break;
                } else {
                    basket.clearBasket();
                    totalPrice += totalBasketPrice;
                    orderConfirmUi.printOrderConfirm();
                    break;
                }
            } else if (choice == 2) {
                break;
            } else {
                printError();
            }
        }
    }

    public void clear() {
        while (true) {
            System.out.println("진행하던 주문을 취소하시겠습니까?\n");
            System.out.println("1. 확인        2. 취소");

            int choice = getNumber();
            if (choice == 1) {
                basket.clearBasket();
                break;
            } else if (choice == 2) {
                break;
            } else {
                printError();
            }
        }
    }

    public void printTotalSum() {
        System.out.println("--------------------------------------------");
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은 [ W %d ] 입니다.\n", totalPrice);
        System.out.println("3초 후에 메인메뉴로 돌아갑니다.");
        try {
            Thread.sleep(500);
            System.out.println();
            System.out.println("3");
            Thread.sleep(1000);
            System.out.println("2");
            Thread.sleep(1000);
            System.out.println("1");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void addToBasket(Product product) {
        basket.addProduct(product);
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
        System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
        System.out.println("--------------------------------------------");
    }
}
