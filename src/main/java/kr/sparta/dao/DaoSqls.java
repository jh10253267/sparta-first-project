package kr.sparta.dao;

public class DaoSqls {
    public static final String SELECT_ALL_CATEGORY = "SELECT * FROM category";
    public static final String SELECT_BY_CATEGORY = "SELECT * FROM menu WHERE category_id = ?";
    public static final String SELECT_BY_ID = "SELECT * FROM menu WHERE id = ?";
    public static final String SELECT_NOW = "SELECT NOW()";
}
