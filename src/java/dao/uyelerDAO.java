package dao;

import entity.uyeler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author Asus
 */
public class uyelerDAO {

    public List<uyeler> findAll() throws InstantiationException, IllegalAccessException, SQLException {
        List<uyeler> uyelist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from uyeler");
            while (rs.next()) {
                uyeler tmp = new uyeler();
                tmp.setUye_id(rs.getInt("uye_ide"));
                tmp.setUye_sifre(rs.getString("sifre"));
                uyelist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return uyelist;
    }

    public uyeler find(int id) throws InstantiationException, IllegalAccessException, SQLException {

        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        uyeler u = null;

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from uyeler where uye_id =" + id);
            rs.next();
            u = new uyeler();
            u.setUye_id(rs.getInt("uye_id"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u;
    }

    public void create(uyeler uyeler) throws InstantiationException, IllegalAccessException, SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("insert into uyeler (uye_id,sifre) values ('" + uyeler.getUye_id() + uyeler.getUye_sifre() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(filmlerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void update(uyeler uye) throws InstantiationException, IllegalAccessException, SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("update uyeler set sifre = '" + uye.getUye_sifre() + "'where uye_id=" + uye.getUye_id());
        } catch (SQLException ex) {
            Logger.getLogger(uyelerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void delete(uyeler uye) throws InstantiationException, SQLException, IllegalAccessException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("delete from uyeler where uyeler = '" + uye.getUye_id() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
