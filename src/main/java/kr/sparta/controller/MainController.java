package kr.sparta.controller;

import kr.sparta.dao.KioskDAO;
import kr.sparta.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 메인에서 보여줄 것 상품 목록.
 * 카데고리는 그냥 적어두기.
 * 가장 처음에 나오게 할 목록은 버거.
 * 버거 데이터만 넘겨주고 나머지는 Ajax로 받아오기.
 */

@WebServlet("/kiosk")
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KioskDAO dao = new KioskDAO();

        List<Product> productList;
        try {
            productList = dao.selectProductByCategory(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
    }
}
