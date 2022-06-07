package com.example;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class MyDataSource  {
    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    static {
        Connection connection = null;
        for (int i = 0; i < 3; i++) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf-8&useSSL=false",
                        "root",
                        "123456");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pool.add(connection);
        }
    }

    public Connection getConnection() throws SQLException {
        if (pool.size() == 0) {
            // 初始化连接池
        }

        return pool.removeFirst();
    }
}
