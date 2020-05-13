package dao;

import entity.aktor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class aktorDAO extends superDAO{

    PreparedStatement pst = null;
    ResultSet rs = null;

    public aktor find(int id) {
        //System.out.println("Gelen id:"+id);
        aktor a = null;

        try {          
            pst = this.getConnection().prepareStatement("select * from aktor where aktor_id =?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
           //System.out.println("*************************TEST****************************");
                a = new aktor();
                a.setAktor_id(rs.getInt("aktor_id"));
                a.setAktor_ad(rs.getString("aktor_ad"));
                a.setAktor_soyad(rs.getString("aktor_soyad"));
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return a;
    }

    public List<aktor> getAktor() {
        List<aktor> alist = new ArrayList();
        try {           
            pst = this.getConnection().prepareStatement("select * from aktor");
            rs = pst.executeQuery();
            while (rs.next()) {
                aktor tmp = new aktor(rs.getInt("aktor_id"), rs.getString("aktor_ad"), rs.getString("aktor_soyad"));
                alist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return alist;
    }

    public void create(aktor aktor) {

        try {
           
            pst = this.getConnection().prepareStatement("insert into aktor (aktor_ad,aktor_soyad) values(?,?)");
            pst.setString(1, aktor.getAktor_ad());
            pst.setString(2, aktor.getAktor_soyad());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(aktorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void delete(aktor akt) {

        try {
           
            pst = this.getConnection().prepareStatement("delete from aktor where aktor_ad = ?");
            pst.setString(1, akt.getAktor_ad());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(aktorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void update(aktor akt) {

        try {
            
            pst = this.getConnection().prepareStatement("update aktor set aktor_ad = ?, aktor_soyad=? where aktor_id = ?");
            pst.setString(1, akt.getAktor_ad());
            pst.setString(2, akt.getAktor_soyad());
            pst.setInt(3, akt.getAktor_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(aktorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public List<aktor> getFilmAktor(int film_id) {
        List<aktor> filmAktor = new ArrayList<>();
        //System.out.println("*******************************FİLM İD:"+film_id);
        try {
            
           PreparedStatement pst1 = this.getConnection().prepareStatement("select * from film_aktor where film_id = ?");
            pst.setInt(1, film_id);
           ResultSet rs1 = pst.executeQuery();

            while (rs1.next()) {
              
                filmAktor.add(this.find(rs1.getInt("aktor_id")));
                
                //System.out.println("*************************WHİLE************************: "+rs1.getInt("aktor_id"));
                
            }
        } catch (SQLException ex) {
            System.out.println("AKTORDAO(getFilmAktor hata)"+ex.getMessage());
        }
        //System.out.println(film_id+" numaralı filmin aktör listesinin boyutu:"+filmAktor.size()+"  Liste:"+filmAktor.toString());
        return filmAktor;
    }
}
