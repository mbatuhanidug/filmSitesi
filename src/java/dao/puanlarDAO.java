/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.puanlar;
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
public class puanlarDAO {

    public List<puanlar> getPuanlar() throws InstantiationException, IllegalAccessException, SQLException {
        List<puanlar> plist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from puanlar");
            while (rs.next()) {
                puanlar tmp = new puanlar(rs.getInt("puan_id"), rs.getInt("puan_degeri"));
                plist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return plist;
    }

    public puanlar find(int id) throws InstantiationException, IllegalAccessException, SQLException {

        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        puanlar p = null;

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from puanlar where puan_id =" + id);
            rs.next();
            p = new puanlar();
            p.setPuan_id(rs.getInt("puan_id"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
    
    public List<puanlar> getPuan_Film(int film_id) throws InstantiationException, IllegalAccessException, SQLException {
        List<puanlar> puan_film = new ArrayList<>();

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from puan_bulunur where film_id ="+film_id);
            
            while(rs.next()){
                puan_film.add(this.find(rs.getInt("puan_id")));
            }
        } catch(SQLException ex){
            Logger.getLogger(aktorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return puan_film;
    }

    public void create(puanlar puanlar) throws InstantiationException, IllegalAccessException, SQLException {

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            st.executeUpdate("insert into puanlar (puan_degeri) values ('" + puanlar.getPuanDegeri() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(puanlar puanlar) throws InstantiationException, SQLException, IllegalAccessException{
        
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("delete from puanlar where puan_degeri = '"+ puanlar.getPuanDegeri()+"'");
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void update(puanlar puanlar) throws InstantiationException, IllegalAccessException, SQLException {
        
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("update puanlar set puan_degeri = '"+puanlar.getPuanDegeri()+"'where puan_id="+puanlar.getPuan_id());
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
