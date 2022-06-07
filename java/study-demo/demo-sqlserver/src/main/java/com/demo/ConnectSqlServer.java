package com.demo;

import java.sql.*;

public class ConnectSqlServer {
    public static void main(String[] args) {

        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://10.6.201.7:1433;databaseName=master;user=ismonitor;password=MONITOR@uih2022";
//         String connectionUrl = "jdbc:sqlserver://10.6.12.135:1433;databaseName=master;user=sa;password=Minzhufuqiang135!#%";
//         String connectionUrl = "jdbc:sqlserver://10.8.85.22:1433;databaseName=master;user=test;password=123456@qwe";

        try (
                Connection con = DriverManager.getConnection(connectionUrl);
                Statement stmt = con.createStatement();
        ) {
            String SQL = "SELECT @@VERSION as version";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
//                System.out.println(rs.getString("server_id") + " " + rs.getString("name"));
                System.out.println(rs.getString("version"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
