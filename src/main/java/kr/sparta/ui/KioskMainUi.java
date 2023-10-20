package kr.sparta.ui;

import kr.sparta.dao.KioskDAO;
import kr.sparta.domain.Menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class KioskMainUi {

    private final BufferedReader in;
    private KioskDAO dao = new KioskDAO();
    private List<Menu> menuList;

    private KioskMainUi() {
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    private static final KioskMainUi instance = new KioskMainUi();

    public static KioskMainUi getInstance() {
        return instance;
    }

    public void printMainMenu() throws SQLException {
        menuList = dao.selectAllCategory();

        int index = 0;
        System.out.println("--------------------------------------------");
        System.out.println("**버거킹에 오신것을 환영합니다.**");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요. \n");
        System.out.println("[ BURGER KING MENU ]");
        for (Menu m : menuList) {
            ++index;
            System.out.printf("%d. %-10s| %s\n", index, m.getName(), m.getDescription());
        }
        System.out.println();
        System.out.println("[ ODER MENU ]");
        System.out.println("5.장바구니 보기");
        System.out.println("6.주문 초기화");
        System.out.println("9.프로그램 종료");
        System.out.println("--------------------------------------------");

    }

    public int getNumber() {
        try {
            int menuNumber = Integer.parseInt(in.readLine());
            return menuNumber;
        } catch (Exception e) {
            return -1;
        }
    }

    public void printError() {
        System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
        System.out.println("--------------------------------------------");
    }

    public String getMenuName(int menuNumber) {
        return menuList.get(menuNumber - 1).getName();
    }

}
