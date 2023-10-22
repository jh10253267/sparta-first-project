package kr.sparta;

import kr.sparta.dao.ConnectionUtil;
import kr.sparta.dao.KioskDAO;
import kr.sparta.domain.Product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DaoTests {

    @DisplayName("Connection테스트")
    @Test
    void connectionTest() throws SQLException {
        Connection conn = ConnectionUtil.INSTANCE.getConnection();
        assertThat(conn).isNotNull();
    }

    @DisplayName("Select By Category_id")
    @Test
    void selectProductTest() throws SQLException {
        KioskDAO dao = new KioskDAO();
        List<Product> productList = dao.selectProductByCategory(4);
        productList.stream().forEach(System.out::println);
    }

}

