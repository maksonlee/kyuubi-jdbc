package org.example;

import java.sql.*;

public class Main {
    private static String kyuubiJdbcUrl = "jdbc:hive2://demo.com:10010/default;transportMode=http;ssl=true;httpPath=cliservice";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try (Connection conn = DriverManager.getConnection(kyuubiJdbcUrl, "user", "password")) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("show tables")) {
                    while (rs.next()) {
                        System.out.println(rs.getString(2));
                    }
                }
            }
        }
    }
}