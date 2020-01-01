package com.mine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author yanyimim
 * @since 2020/1/1 17:10
 */
public class ConnectionMine {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/icc_mz";
    private static String username = "root";
    private static String password = "1217";

    public static Connection getInstance() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url,username,password);
    }
}
