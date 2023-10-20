package kr.sparta.ui;

import kr.sparta.dao.KioskDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 * 주문이 완료되었습니다!
 *
 * 대기번호는 [ 1 ] 번 입니다.
 * (3초후 메뉴판으로 돌아갑니다.)
 */

public class OrderConfirmUi {
    private BufferedReader in;
    private static int orderNum = 0;

    public OrderConfirmUi() {
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }
    private static OrderConfirmUi instance = new OrderConfirmUi();

    public static OrderConfirmUi getInstance() {
        return instance;
    }

    public void printOrderConfirm() throws InterruptedException, SQLException {
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.printf("대기번호는 [ %d ] 번 입니다.\n", ++orderNum);
        System.out.println();
        System.out.println("주문 시각 : " + KioskDAO.getTime());
        System.out.println();
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        Thread.sleep(3000);
        }
}
