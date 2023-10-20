package kr.sparta.service;

import kr.sparta.dao.KioskDAO;

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
