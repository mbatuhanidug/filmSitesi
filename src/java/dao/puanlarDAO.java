/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.puanlar;
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
public class puanlarDAO {

    PreparedStatement pst;
    ResultSet rs = null;

    public List<puanlar> getPuanlar() throws SQLException {
        List<puanlar> plist = new ArrayList();
        DBConnection db = DBConnection.getInstance();
        try {
            pst = db.getConnection().prepareStatement("select * from puanlar");
            rs = pst.executeQuery();
            while (rs.next()) {
                puanlar tmp = new puanlar();
                tmp.setPuan_id(rs.getInt("puan_id"));
                tmp.setPuanDegeri(rs.getInt("puan_degeri"));
                plist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return plist;
    }

    public puanlar find(int id) throws SQLException {

        DBConnection db = DBConnection.getInstance();
        puanlar p = null;

        try {
            pst = db.getConnection().prepareStatement("Select * from puanlar where puan_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                p = new puanlar();
                p.setPuan_id(rs.getInt("puan_id"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public void create(puanlar puanlar) throws SQLException {
        DBConnection db = DBConnection.getInstance();
        try {
            pst = db.getConnection().prepareStatement("insert into puanlar (puan_degeri) values (?)");
            pst.setInt(1, puanlar.getPuanDegeri());
            pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(puanlar puanlar) throws SQLException {
        DBConnection db = DBConnection.getInstance();
        try {
            pst = db.getConnection().prepareStatement("delete from puanlar where puan_id = ?");
            pst.setInt(1, puanlar.getPuan_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(puanlar puanlar) throws SQLException {
        DBConnection db = DBConnection.getInstance();
        try {
            pst = db.getConnection().prepareStatement("update puanlar set puan_degeri = ? where puan_id = ? ");
            pst.setInt(1, puanlar.getPuanDegeri());
            pst.setInt(2, puanlar.getPuan_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
