package kr.sparta.dao;


import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariConfig;

import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionUtil {
    INSTANCE;

    private HikariDataSource ds;

    ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/kiosk");
        config.setUsername("webuser");
        config.setPassword("webuser");
        ds = new HikariDataSource(config);
    }
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
