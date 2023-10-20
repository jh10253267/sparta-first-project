package kr.sparta.service;

import kr.sparta.dao.KioskDAO;
import kr.sparta.domain.Menu;
import kr.sparta.domain.Product;

import java.sql.SQLException;
import java.util.List;

public enum KioskService {
    INSTANCE;

    private KioskDAO dao;

    KioskService() {
        dao = new KioskDAO();
    }

//    public List<Menu> listAll() throws SQLException {
//        List<Menu> menuList = dao.selectAllCategory();
//
//
//    }


}
