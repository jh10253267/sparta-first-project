package kr.sparta.ui;


import kr.sparta.dao.KioskDAO;
import kr.sparta.domain.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class DetailMenuUi {
    private static BufferedReader in;
    AddToBasketConfirmUi purchaseUi = AddToBasketConfirmUi.getInstance();
    private KioskDAO dao = new KioskDAO();


    private DetailMenuUi() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    private static final DetailMenuUi instance = new DetailMenuUi();

    public static DetailMenuUi getInstance() {
        return instance;
    }

    public void printDetailMenu(int menuNumber, String menuName) throws SQLException {
        List<Product> productList = dao.selectProductByCategory(menuNumber);

        while (true) {
            int index = 0;
            System.out.println("--------------------------------------------");
            System.out.println("**버거킹에 오신것을 환영합니다.**");
            System.out.println("아래 상품메뉴판을 보시고 메뉴를 골라 입력해주세요. \n");
            System.out.printf("[ %s ]\n", menuName);
            for (Product p : productList) {
                ++index;
                System.out.printf("%d. %-15s  | W %d | %s\n", index, p.getName(), p.getPrice(), p.getDescription());
            }
            System.out.println();
            System.out.println("--------------------------------------------");
            int choice = getNumber();
            if (index >= choice && choice >= 1) {
                purchaseUi.printPurchasePage(productList.get(choice - 1));
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
        } catch (IOException e) {
            return -1;
        }
    }

    public void printError() {
        System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
        System.out.println("--------------------------------------------");
    }


}
