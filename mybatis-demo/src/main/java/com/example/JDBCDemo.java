package com.example;

import javax.sql.DataSource;
import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=utf-8&useSSL=false",
                    "root",
                    "123456");
            ps = connection.prepareStatement("SELECT * FROM user LIMIT ?");
            ps.setInt(1, 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }




    }
}
