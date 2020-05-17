package dao;

import entity.yorumlar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class yorumlarDAO extends superDAO {
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private filmlerDAO fdao;

    public yorumlar find(int id) {
        
        yorumlar y = null;
        
        try {
            pst = this.getConnection().prepareStatement("select * from yorumlar where yorum_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                y = new yorumlar();
                y.setYorum_id(rs.getInt("yorum_id"));
                y.setYorumMetni(rs.getString("yorum_metni"));
                y.setFilm(this.getFdao().find(rs.getInt("film_id")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return y;
    }
    
    public List<yorumlar> getYorumlar() {
        List<yorumlar> ylist = new ArrayList();
        
        try {
            pst = this.getConnection().prepareStatement("select * from yorumlar ORDER BY film_id ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                yorumlar tmp = new yorumlar();
                tmp.setYorum_id(rs.getInt("yorum_id"));
                tmp.setYorumMetni(rs.getString("yorum_metni"));
                tmp.setFilm(this.getFdao().find(rs.getInt("film_id")));
                ylist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ylist;
    }
    
    public void create(yorumlar yorumlar) {
        
        try {
            pst = this.getConnection().prepareStatement("insert into yorumlar (yorum_metni, film_id) values (?,?)");
            pst.setString(1, yorumlar.getYorumMetni());
            pst.setInt(2, yorumlar.getFilm().getFilm_id());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(yorumlarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(yorumlar yorumlar) {
        
        try {
            pst = this.getConnection().prepareStatement("delete from yorumlar where yorum_id = ?");
            pst.setInt(1, yorumlar.getYorum_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(yorumlarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(yorumlar yorumlar) {
        
        try {
            pst = this.getConnection().prepareStatement("update yorumlar set yorum_metni=? , film_id=? where yorum_id=? ");
            pst.setString(1, yorumlar.getYorumMetni());
            pst.setInt(2, yorumlar.getFilm().getFilm_id());
            pst.setInt(3, yorumlar.getYorum_id());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(yorumlarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public filmlerDAO getFdao() {
        if (this.fdao == null) {
            this.fdao = new filmlerDAO();
        }
        return fdao;
    }
    
}
