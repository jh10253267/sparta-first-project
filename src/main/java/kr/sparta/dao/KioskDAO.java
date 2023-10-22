package kr.sparta.dao;

import kr.sparta.domain.Menu;
import kr.sparta.domain.Product;
import lombok.Cleanup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static kr.sparta.dao.DaoSqls.*;

public class KioskDAO {
    public List<Menu> selectAllCategory() throws SQLException {
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(SELECT_ALL_CATEGORY);
        @Cleanup ResultSet rs = ps.executeQuery();

        List<Menu> menuList = new ArrayList<>();
        while(rs.next()) {
            Menu menu = new Menu();

            menu.setId(rs.getLong("id"));
            menu.setName(rs.getString("name"));
            menu.setDescription(rs.getString("description"));

            menuList.add(menu);
        }

    return menuList;
    }
    public List<Product> selectProductByCategory(int category_id) throws SQLException {
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(SELECT_BY_CATEGORY);
        ps.setInt(1, category_id);
        @Cleanup ResultSet rs = ps.executeQuery();

        List<Product> productList = new ArrayList<>();

        while(rs.next()) {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getInt("price"));
            productList.add(product);
        }
        return productList;
    }
    public Product selectOneProduct(int id) throws SQLException {
        @Cleanup Connection  conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID);
        ps.setInt(1, id);
        @Cleanup ResultSet rs = ps.executeQuery();
        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getInt("price"));
        product.setDescription(rs.getString("description"));
        return product;
    }
    public static String getTime() throws SQLException {
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(SELECT_NOW);
        @Cleanup ResultSet rs = ps.executeQuery();
        rs.next();
        String now = rs.getString(1);
        return now;
    }
}
