package kr.sparta.ui;


import kr.sparta.dao.KioskDAO;
import kr.sparta.domain.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

/**
 * "SHAKESHACK BURGER 에 오신걸 환영합니다."
 * 아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.
 * <p>
 * [ Burgers MENU ]
 * 1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
 * 2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
 * 3. Shroom Burger | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거
 * 3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
 * 4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
 */
public class KioskDetailUi {
    private static BufferedReader in;
    PurchaseUi purchaseUi = PurchaseUi.getInstance();
    BasketUi basketUi = BasketUi.getInstance();
    private static KioskDAO dao = new KioskDAO();
    private static List<Product> productList;

    private KioskDetailUi() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    private static KioskDetailUi instance = new KioskDetailUi();

    public static KioskDetailUi getInstance() {
        return instance;
    }

    public void printDetailMenu(int menuNumber, String menuName) throws SQLException{
        productList = dao.selectProductByCategory(menuNumber);

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
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
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


}
