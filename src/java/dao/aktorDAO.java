package dao;

import entity.aktor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

public class aktorDAO {

    public aktor find(int id) throws InstantiationException, IllegalAccessException, SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        aktor a = null;

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from aktor where aktor_id =" + id);
            rs.next();

            a = new aktor();
            a.setAktor_id(rs.getInt("aktor_id"));
            a.setAktor_ad(rs.getString("aktor_ad"));
            a.setAktor_soyad(rs.getString("aktor_soyad"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return a;
    }

    public List<aktor> getAktor() throws InstantiationException, IllegalAccessException, SQLException {
        List<aktor> alist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from aktor");
            while (rs.next()) {
                aktor tmp = new aktor(rs.getInt("aktor_id"), rs.getString("aktor_ad"), rs.getString("aktor_soyad"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return alist;
    }

    public void create(aktor aktor) throws InstantiationException, IllegalAccessException, SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("insert into aktor (aktor_ad,aktor_soyad) values ('" + aktor.getAktor_ad() + "','" + aktor.getAktor_soyad() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(aktorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void delete(aktor akt) throws InstantiationException, SQLException, IllegalAccessException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("delete from aktor where aktor_ad = '" + akt.getAktor_ad() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(aktorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void update(aktor akt) throws InstantiationException, IllegalAccessException, SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("update aktor set aktor_ad = '" + akt.getAktor_ad() + "', aktor_soyad = '" + akt.getAktor_soyad() + "' where aktor_id= " + akt.getAktor_id());
        } catch (SQLException ex) {
            Logger.getLogger(aktorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public List<aktor> getFilmAktor(int film_id) throws InstantiationException, IllegalAccessException, SQLException {
        List<aktor> filmAktor = new ArrayList<>();

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from film_aktor where film_id ="+film_id);
            
            while(rs.next()){
                filmAktor.add(this.find(rs.getInt("aktor_id")));
            }
        } catch(SQLException ex){
            Logger.getLogger(aktorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return filmAktor;
    }

}
