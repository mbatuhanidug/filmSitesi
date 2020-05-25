package dao;

import java.sql.Connection;
import java.sql.SQLException;
import util.DBConnection;

public class superDAO {
    // *********  superDAO ile bütün dao sınıflarına kalıtım sağlayarak tekrar tekrar aynı kodları yazmaktan ve kod tekrarından kurtarıyoruz.
    private DBConnection db;
    private Connection connection;
 
    public DBConnection getDb() {
        if (this.db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public Connection getConnection() throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            this.connection = this.getDb().connect();
        }
        return connection;
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
