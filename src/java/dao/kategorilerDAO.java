package dao;

import entity.kategoriler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class kategorilerDAO extends superDAO{

    PreparedStatement pst;
    ResultSet rs = null;

    public kategoriler find(int id)    {
        
       
        kategoriler k = null;
        try {      
            pst = this.getConnection().prepareStatement("select * from kategoriler where kategori_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                k = new kategoriler();
                k.setKategori_id(rs.getInt("kategori_id"));
                k.setKategori_ad(rs.getString("kategori_ad"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return k;
    }

    public List<kategoriler> getKategori(int page, int pageSize)   {
        
        List<kategoriler> klist = new ArrayList();
        int start = (page-1)*pageSize;
        try {  
            pst = this.getConnection().prepareStatement("Select * from kategoriler ORDER BY kategori_ad ASC limit "+start+","+pageSize);
            rs = pst.executeQuery();
            while (rs.next()) {
                kategoriler tmp = new kategoriler();
                tmp.setKategori_id(rs.getInt("kategori_id"));
                tmp.setKategori_ad(rs.getString("kategori_ad"));
                klist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return klist;
    }
    
     public int count() {
        
        int count =0;
        try {

            pst = this.getConnection().prepareStatement("SELECT count(kategori_id) as kategori_count from kategoriler ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("kategori_count");

          
        } catch (SQLException ex) {
            System.out.println("kategorilerDAO HATA(ReadAll):" + ex.getMessage());
        }
        return count;
    }

    public void create(kategoriler kategoriler) {
        try {     
            pst = this.getConnection().prepareStatement("insert into kategoriler (kategori_ad) values (?)");
            pst.setString(1, kategoriler.getKategori_ad());
            pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(kategoriler kat) {
       
        try {
           
            pst = this.getConnection().prepareStatement("delete from kategoriler where kategori_ad = ?");
            pst.setString(1, kat.getKategori_ad());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void update(kategoriler kat)  {
         
        try {
          
            pst = this.getConnection().prepareStatement("update kategoriler set kategori_ad = ? where kategori_id = ?");
            pst.setString(1, kat.getKategori_ad());
            pst.setInt(2, kat.getKategori_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
