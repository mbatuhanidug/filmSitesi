/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.kullanicilar;
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
public class kullanicilarDAO {

    public List<kullanicilar> findAll() throws InstantiationException, IllegalAccessException, SQLException {
        List<kullanicilar> kullist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from kullanicilar");
            while (rs.next()) {
                kullanicilar tmp = new kullanicilar();
                tmp.setK_id(rs.getInt("kullanici_id"));
                tmp.setK_Ad(rs.getString("kullanici_ad"));
                tmp.setK_Soyad(rs.getString("kullanici_soyad"));
                tmp.setE_mail(rs.getString("email"));
                tmp.setTelefon_no(rs.getInt("telefon"));

                kullist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return kullist;
    }

    public kullanicilar find(int id) throws InstantiationException, IllegalAccessException, SQLException {

        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        kullanicilar k = null;

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from kullanicilar where kullanici_id =" + id);
            rs.next();
            k = new kullanicilar();
            k.setK_id(rs.getInt("kullanici_id"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return k;
    }

    public void create(kullanicilar kullanicilar) throws InstantiationException, IllegalAccessException, SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("insert into kullanicilar (kullanici_id,kullanici_ad,kullanici_soyad,email,telefon) values ('" + kullanicilar.getK_id() + "','" + kullanicilar.getK_Ad() + "'," + kullanicilar.getK_Soyad() + ",'" + kullanicilar.getE_mail() + ",'" + kullanicilar.getTelefon_no() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(filmlerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void update(kullanicilar kullanicilar) throws InstantiationException, IllegalAccessException, SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("update kullanicilar set kullanici_ad = '" + kullanicilar.getK_Ad() + "',kullanici_soyad ='" + kullanicilar.getK_Soyad() + "',email = " + kullanicilar.getE_mail() + ",telefon='" + kullanicilar.getTelefon_no() + "' where kullanici_id= " + kullanicilar.getK_id());
        } catch (SQLException ex) {
            Logger.getLogger(filmlerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void delete(kullanicilar kullanicilar) throws InstantiationException, SQLException, IllegalAccessException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("delete from kullanicilar where kullanici_ad = '" + kullanicilar.getK_Ad() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
