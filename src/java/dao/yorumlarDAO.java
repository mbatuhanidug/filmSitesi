/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.yorumlar;
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
 * @author asus
 */
public class yorumlarDAO {


    public yorumlar find(int id) throws InstantiationException, IllegalAccessException, SQLException {

        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        yorumlar y = null;

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from yorumlar where yorum_id =" + id);
            rs.next();
            y = new yorumlar();
            y.setYorum_id(rs.getInt("yorum_id"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return y;
    }
    
    public List<yorumlar> getYorum_Film(int film_id) throws InstantiationException, IllegalAccessException, SQLException {
        List<yorumlar> yorum_film = new ArrayList<>();

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from yorum_bulunur where film_id ="+film_id);
            
            while(rs.next()){
                yorum_film.add(this.find(rs.getInt("yorum_id")));
            }
        } catch(SQLException ex){
            Logger.getLogger(aktorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return yorum_film;
    }
    
    public List<yorumlar> getYorumlar() throws InstantiationException, IllegalAccessException, SQLException {
        List<yorumlar> ylist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from yorumlar");
            while (rs.next()) {
                yorumlar tmp = new yorumlar(rs.getInt("yorum_id"), rs.getString("yorum_metni"));
                ylist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ylist;
    }

    public void create(yorumlar yorumlar) throws InstantiationException, IllegalAccessException, SQLException {

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            st.executeUpdate("insert into yorumlar (yorum_metni) values ('" + yorumlar.getYorumMetni() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(yorumlar yorumlar) throws InstantiationException, SQLException, IllegalAccessException {

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            st.executeUpdate("delete from yorumlar where yorum_metni = '" + yorumlar.getYorumMetni() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(yorumlar yorumlar) throws InstantiationException, IllegalAccessException, SQLException {

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            st.executeUpdate("update yorumlar set yorum_metni = '" + yorumlar.getYorumMetni() + "'where yorum_id= " + yorumlar.getYorum_id());
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
