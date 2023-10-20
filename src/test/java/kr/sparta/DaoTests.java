package kr.sparta;

import kr.sparta.dao.KioskDAO;
import kr.sparta.domain.Menu;
import kr.sparta.domain.Product;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.List;

public class DaoTests {

    @Test
    void selectProductTest() throws SQLException {
        KioskDAO dao = new KioskDAO();
        List<Product> productList = dao.selectProductByCategory(4);
        for(Product p : productList) {
            System.out.println(p);
        }

    }

    @Test
    void name() throws SQLException {
        KioskDAO dao = new KioskDAO();
        List<Menu> menuList = dao.selectAllCategory();
        for(Menu menu : menuList) {
            System.out.println(menu.getName());
    }

}
}
