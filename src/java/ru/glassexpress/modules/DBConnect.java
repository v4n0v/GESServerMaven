package ru.glassexpress.modules;

import javax.xml.bind.helpers.AbstractMarshallerImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBConnect {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();


//            String jdbcUrl = "jdbc:mysql://localhost:3306/glass_express_db";
//            String user = "root";
//            String pass = "12345";

            final String jdbcUrl = "jdbc:mysql://node148803-glass-express.jelastic.regruhosting.ru/glass_express_db";
            final String user = "root";
            final String pass = "QXEoas47731" ;

//            properties.setProperty("characterEncoding","UTF-8");
//            properties.setProperty("user", user);
//            properties.setProperty("password", pass);


            properties.setProperty("useUnicode", "true");
            properties.setProperty("characterEncoding", "UTF-8");
            properties.setProperty("user", user);
            properties.setProperty("password", pass);

            return DriverManager.getConnection(jdbcUrl, properties);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
