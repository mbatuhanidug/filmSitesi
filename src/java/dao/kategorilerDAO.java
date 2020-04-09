package dao;

import entity.kategoriler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

public class kategorilerDAO {

    public kategoriler find(int id) throws InstantiationException, IllegalAccessException, SQLException{
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        
        kategoriler k = null;
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from kategoriler where kategori_id ="+id);
            rs.next();
            
            k= new kategoriler();
            k.setKategori_id(rs.getInt("kategori_id"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return k;
    }
    
    public List<kategoriler> getKategori() throws InstantiationException, IllegalAccessException, SQLException {
        List<kategoriler> klist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from kategoriler");
            while (rs.next()) {
                kategoriler tmp = new kategoriler(rs.getInt("kategori_id"), rs.getString("kategori_ad"));
                klist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return klist;
    }

    public void create(kategoriler kategoriler) throws InstantiationException, IllegalAccessException, SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("insert into kategoriler (kategori_ad) values ('" + kategoriler.getKategori_ad() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public void delete(kategoriler kat) throws InstantiationException, SQLException, IllegalAccessException{
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("delete from kategoriler where kategori_ad = '"+ kat.getKategori_ad()+"'");
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void update(kategoriler kat) throws InstantiationException, IllegalAccessException, SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("update kategoriler set kategori_ad = '"+kat.getKategori_ad()+"'where kategori_id= "+kat.getKategori_id());
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
