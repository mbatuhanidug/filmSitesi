/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.yorumlar;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    PreparedStatement pst;
    ResultSet rs = null;

    public yorumlar find(int id) throws SQLException {

        DBConnection db = DBConnection.getInstance();
        yorumlar y = null;

        try {
            pst = db.getConnection().prepareStatement("select * from yorumlar where yorum_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                y = new yorumlar();
                y.setYorum_id(rs.getInt("yorum_id"));
                y.setYorumMetni(rs.getString("yorum_metni"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return y;
    }

    public List<yorumlar> getYorumlar() throws SQLException {
        List<yorumlar> ylist = new ArrayList();

        DBConnection db = DBConnection.getInstance();

        try {
            pst= db.getConnection().prepareStatement("select * from yorumlar");
            rs = pst.executeQuery();
            while (rs.next()) {
                yorumlar tmp = new yorumlar();
                tmp.setYorum_id(rs.getInt("yorum_id"));
                tmp.setYorumMetni(rs.getString("yorum_metni"));
                ylist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ylist;
    }

    public void create(yorumlar yorumlar) throws SQLException {

        DBConnection db = DBConnection.getInstance();

        try {
            pst = db.getConnection().prepareStatement("insert into yorumlar (yorum_metni) values (?)");
            pst.setString(1, yorumlar.getYorumMetni());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(yorumlar yorumlar) throws SQLException {

        DBConnection db = DBConnection.getInstance();
        try {
            pst = db.getConnection().prepareStatement("delete from yorumlar where yorum_metni = ?");
            pst.setString(1, yorumlar.getYorumMetni());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(yorumlar yorumlar) throws SQLException {

        DBConnection db = DBConnection.getInstance();

        try {
            pst = db.getConnection().prepareStatement("update yorumlar set yorum_metni=? where yorum_id=? ");
            pst.setString(1, yorumlar.getYorumMetni());
            pst.setInt(2, yorumlar.getYorum_id());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
