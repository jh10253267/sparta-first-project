package kr.sparta;

import kr.sparta.ui.BasketUi;
import kr.sparta.ui.DetailMenuUi;
import kr.sparta.ui.KioskMainUi;

import java.sql.SQLException;

public class Kiosk {
    public static void main(String[] args) throws SQLException, InterruptedException {
        KioskMainUi kioskUi = KioskMainUi.getInstance();
        DetailMenuUi kioskDetailUi = DetailMenuUi.getInstance();
        BasketUi basketUi = BasketUi.getInstance();

        while_loop:
        while (true) {
            kioskUi.printMainMenu();

            int menuNumber = kioskUi.getNumber();

            String menuName = null;
            if (menuNumber > 0 && menuNumber < 5) {
                menuName = kioskUi.getMenuName(menuNumber);
            }

            switch (menuNumber) {
                case 0:
                    basketUi.printTotalSum();
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                    kioskDetailUi.printDetailMenu(menuNumber, menuName);
                    break;
                case 5:
                    basketUi.printMyBasket();
                    break;
                case 6:
                    basketUi.clear();
                    break;
                case 9:
                    break while_loop;
                default:
                    kioskUi.printError();
                    break;
            }
        }
    }
}
