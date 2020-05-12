    package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private static DBConnection instance;
    private Connection connection;

    private DBConnection() throws SQLException  {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/film", "postgres", "134962");
            System.out.println("Veritabanı bağlantısı başarılı!!!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Veritabanı bağlantısı başarısız: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }
        return instance;
    }

   
}
   
    

