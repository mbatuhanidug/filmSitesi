
package dao;

import entity.yorumlar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class yorumlarDAO extends superDAO{

    PreparedStatement pst;
    ResultSet rs = null;

    public yorumlar find(int id)  {

        yorumlar y = null;

        try {
            pst = this.getConnection().prepareStatement("select * from yorumlar where yorum_id = ?");
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

    public List<yorumlar> getYorumlar()  {
        List<yorumlar> ylist = new ArrayList();

        try {
            pst= this.getConnection().prepareStatement("select * from yorumlar");
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

    public void create(yorumlar yorumlar)  {

        try {
            pst = this.getConnection().prepareStatement("insert into yorumlar (yorum_metni) values (?)");
            pst.setString(1, yorumlar.getYorumMetni());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(yorumlar yorumlar)  {

        try {
            pst = this.getConnection().prepareStatement("delete from yorumlar where yorum_metni = ?");
            pst.setString(1, yorumlar.getYorumMetni());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(yorumlar yorumlar) {
 
        try {
            pst = this.getConnection().prepareStatement("update yorumlar set yorum_metni=? where yorum_id=? ");
            pst.setString(1, yorumlar.getYorumMetni());
            pst.setInt(2, yorumlar.getYorum_id());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
