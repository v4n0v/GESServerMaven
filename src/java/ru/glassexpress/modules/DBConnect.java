package ru.glassexpress.modules;

import javax.xml.bind.helpers.AbstractMarshallerImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBConnect {

//    static Connection connection=null;
//
//    static {
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String jdbcUrl = "jdbc:mysql://localhost:3306/glass_express_db";
//            String user = "root";
//            String pass = "12345";
//
//            connection = DriverManager.getConnection(jdbcUrl, user, pass);
//
//
//          //  connection.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String jdbcUrl = "jdbc:mysql://localhost:3306/glass_express_db";
            String user = "root";
            String pass = "12345";

            Properties properties = new Properties();
            properties.setProperty("characterEncoding","UTF-8");
            properties.setProperty("user", user);
            properties.setProperty("password", pass);

//            final String jdbcUrl = "jdbc:mysql://node148526-env-1571803.jelastic.regruhosting.ru/glass_express_db";
//            final String user = "root";
//            final String pass = "BNErnd76386";
//            properties.setProperty("useUnicode","true");
//            properties.setProperty("characterEncoding","UTF-8");
            return DriverManager.getConnection(jdbcUrl, properties);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
