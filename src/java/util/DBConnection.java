package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection connect() throws InstantiationException, IllegalAccessException, SQLException {
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/film", "postgres", "134962");
            System.out.println("Veritabanı bağlantısı başarılı!!!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Veritabanı bağlantısı başarısız: " + ex.getMessage());
        }
        return conn;
    }
}

