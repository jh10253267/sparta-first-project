package kr.sparta;

import kr.sparta.ui.BasketUi;
import kr.sparta.ui.KioskDetailUi;
import kr.sparta.ui.KioskUi;
import java.sql.SQLException;

public class Kiosk {
    public static void main(String[] args) throws SQLException, InterruptedException {
        KioskUi kioskUi = KioskUi.getInstance();
        KioskDetailUi kioskDetailUi = KioskDetailUi.getInstance();
        BasketUi basketUi = BasketUi.getInstance();

        while_loop:
        while(true) {
            kioskUi.printMainMenu();
            int menuNumber = kioskUi.getNumber();
            String menuName = null;
            if(menuNumber > 0 && menuNumber < 5) {
                menuName = kioskUi.getMenuName(menuNumber);
            }
            switch (menuNumber) {
                case 0 :
                    basketUi.printTotalSum();
                    break ;
                case 1:
                case 2:
                case 3:
                case 4:
                    kioskDetailUi.printDetailMenu(menuNumber, menuName);
                    break;
                case 5:
                    BasketUi.getInstance().printMyBasket();
                    break;
                case 6:
                    basketUi.clear();
                    break ;
                case 9:
                    break while_loop;
                default:
                    kioskUi.printError();
                    break;
            }
    }
    }
}
