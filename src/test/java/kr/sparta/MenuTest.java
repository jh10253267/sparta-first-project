package kr.sparta;

import kr.sparta.dao.KioskDAO;
import kr.sparta.domain.Basket;
import kr.sparta.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class MenuTest {



    @DisplayName("basket 출력 테스트")
    @Test
    void name() throws SQLException {
        KioskDAO dao = new KioskDAO();
        List<Product> list = dao.selectProductByCategory(1);
        Basket basket = new Basket(list);
        List<Product> list2 = basket.getBasket();
        basket.addProduct(list2.get(0));
        basket.addProduct(list2.get(0));
        for(Product p : list2) {
            System.out.println(p);
        }
    }
}
