package dao;

import entity.puanlar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class puanlarDAO extends superDAO{

    PreparedStatement pst;
    ResultSet rs = null;
    
    private filmlerDAO fdao;
    
    public List<puanlar> getPuanlar()  {
        List<puanlar> plist = new ArrayList();
        
        try {
            pst = this.getConnection().prepareStatement("select * from puanlar ORDER BY film_id ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                puanlar tmp = new puanlar();
                tmp.setPuan_id(rs.getInt("puan_id"));
                tmp.setPuanDegeri(rs.getInt("puan_degeri"));
                tmp.setFilm(this.getFdao().find(rs.getInt("film_id")));
                plist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return plist;
    }

    public puanlar find(int id)  {

        
        puanlar p = null;

        try {
            pst = this.getConnection().prepareStatement("Select * from puanlar where puan_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                p = new puanlar();
                p.setPuan_id(rs.getInt("puan_id"));
                p.setPuanDegeri(rs.getInt("puan_degeri"));
                p.setFilm(this.getFdao().find(rs.getInt("film_id")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public void create(puanlar puanlar)  {
        
        try {
            pst = this.getConnection().prepareStatement("insert into puanlar (puan_degeri,film_id) values (?,?)");
            pst.setInt(1, puanlar.getPuanDegeri());
            pst.setInt(2, puanlar.getFilm().getFilm_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(puanlar puanlar) {
       
        try {
            pst = this.getConnection().prepareStatement("delete from puanlar where puan_id = ?");
            pst.setInt(1, puanlar.getPuan_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(puanlar puanlar) {
        
        try {
            pst = this.getConnection().prepareStatement("update puanlar set puan_degeri = ? , film_id = ? where puan_id = ? ");
            pst.setInt(1, puanlar.getPuanDegeri());
            pst.setInt(2, puanlar.getFilm().getFilm_id());
            pst.setInt(3, puanlar.getPuan_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public filmlerDAO getFdao() {
        if(this.fdao == null){
            this.fdao = new filmlerDAO();
        }
        return fdao;
    }
    
}
