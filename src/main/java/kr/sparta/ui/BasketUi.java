package kr.sparta.ui;

import kr.sparta.domain.Basket;
import kr.sparta.domain.Product;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BasketUi {
    private BufferedReader in;
    private OrderConfirmUi orderConfirmUi = OrderConfirmUi.getInstance();
    private static List<Product> productList = new ArrayList<>();
    //프로그램이 실행될 때 한번만 실행됨.
    private static Basket basket = new Basket(productList);
    private static int basketSum = 0;
    private static int totalSum = 0;


    private BasketUi() {
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }
    private static BasketUi instance = new BasketUi();

    public static BasketUi getInstance() {
        return instance;
    }

    public void printMyBasket() throws InterruptedException, SQLException {
        System.out.println("--------------------------------------------");
        System.out.println("지금과 같이 주문하시겠습니까?");
        System.out.println();
        System.out.println("[ ORDERS ]");
        for(Product p : basket.getBasket()) {
            System.out.printf("%-10s| W %d | %d개 | %s\n", p.getName(), p.getPrice(), p.getOrderCount(), p.getDescription());
            basketSum += p.getPrice() * p.getOrderCount();
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.printf("W %d\n", basketSum);
        System.out.println();
        System.out.println("1. 주문      2. 메뉴판");
        System.out.println("--------------------------------------------");
        int choice;
        try {
            choice = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            return;
        }
        if(choice == 1) {
            if(basketSum == 0) {
                System.out.println("장바구니가 비어있습니다.");
                System.out.println("메뉴 화면으로 돌아갑니다.");
            } else {
                productList.clear();
                totalSum += basketSum;
                basketSum = 0;
                orderConfirmUi.printOrderConfirm();
            }
        } else if(choice == 2) {
            basketSum = 0;
        } else {
            System.out.println("번호를 잘못 입력하셨습니다.");
        }
    }
    public void clear() {
        while(true) {
            System.out.println("진행하던 주문을 취소하시겠습니까?\n");
            System.out.println("1. 확인        2. 취소");

            int choice = getNumber();
            if (choice == 1) {
                productList.clear();
                basketSum = 0;
                break;
            } else if(choice == 2) {
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }
    public void printTotalSum() {
        System.out.println("--------------------------------------------");
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은 [ W %d ] 입니다.\n", totalSum);
        System.out.println("3초 후에 메인메뉴로 돌아갑니다.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void addToBasket(Product product) {
        basket.addProduct(product);
        System.out.println("장바구니에 추가되었습니다.");
    }
    public int getNumber() {
        try  {
           int choice = Integer.parseInt(in.readLine());
           return choice;
        } catch (Exception e) {
            return -1;
        }

    }
}
