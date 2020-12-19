package com.wlz.db;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection connection = null;

    public Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("JDBC:mysql:///小区物业管理?serverTimezone=GMT%2B8", "root", "6107015");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
