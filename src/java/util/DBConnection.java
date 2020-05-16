package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection connect() {
        Connection c = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:mariadb://localhost:3307/film?user=root&password=134962");
            System.out.println("bağlantı başarılı");
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        return c;
    }
}
