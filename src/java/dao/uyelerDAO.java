package dao;

import entity.uyeler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class uyelerDAO extends superDAO {

    PreparedStatement pst;
    ResultSet rs = null;

    public uyeler giris(String mail, String sifre) {
        uyeler temp = null;
        try {
            pst = this.getConnection().prepareStatement("select * from uyeler where email = ? and sifre = ?");
            pst.setString(1, mail);
            pst.setString(2, sifre);
            rs = pst.executeQuery();

            while (rs.next()) {
                temp = new uyeler();
                temp.setUye_id(rs.getInt("uye_id"));
                temp.setUye_ad(rs.getString("uye_ad"));
                temp.setUye_soyad(rs.getString("uye_soyad"));
                temp.setEmail(rs.getString("email"));
                temp.setTelefon(rs.getString("telefon"));
                temp.setSifre(rs.getString("sifre"));
                temp.setAdmin(rs.getBoolean("admin"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    public List<uyeler> getYorumUyeler(int uye_id) {
        List<uyeler> yorum_uye = new ArrayList<>();
        try {
            PreparedStatement pst1 = this.getConnection().prepareStatement("select * from yorum_uye where uye_id = ?");
            pst1.setInt(1, uye_id);
            ResultSet rs1 = pst1.executeQuery();
            while (rs1.next()) {
                yorum_uye.add(this.find(rs1.getInt("uye_id")));
            }
        } catch (SQLException ex) {
            System.out.println("AKTORDAO(getFilmAktor hata)" + ex.getMessage());
        }
        return yorum_uye;
    }

    public void create(uyeler uyeler) {
        try {
            pst = this.getConnection().prepareStatement("insert into uyeler (uye_ad,uye_soyad,email,telefon,sifre,admin) values (?,?,?,?,?,0)");
            pst.setString(1, uyeler.getUye_ad());
            pst.setString(2, uyeler.getUye_soyad());
            pst.setString(3, uyeler.getEmail());
            pst.setString(4, uyeler.getTelefon());
            pst.setString(5, uyeler.getSifre());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(uyelerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(uyeler uyeler) {
        try {
            pst = this.getConnection().prepareStatement("delete from uyeler where email=?");
            pst.setString(1, uyeler.getEmail());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(uyelerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<uyeler> findAll() {
        List<uyeler> ulist = new ArrayList();
        try {
            pst = this.getConnection().prepareStatement("Select * from uyeler ORDER BY uye_id ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                uyeler temp = new uyeler();
                temp.setUye_id(rs.getInt("uye_id"));
                temp.setUye_ad(rs.getString("uye_ad"));
                temp.setUye_soyad(rs.getString("uye_soyad"));
                temp.setEmail(rs.getString("email"));
                temp.setTelefon(rs.getString("telefon"));
                temp.setUye_id(rs.getInt("uye_id"));
                temp.setSifre(rs.getString("sifre"));
                ulist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ulist;
    }

    public uyeler find(int id) {
        uyeler uyeler = null;
        try {
            pst = this.getConnection().prepareStatement("select * from uyeler where uye_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                uyeler = new uyeler();
                uyeler.setUye_id(rs.getInt("uye_id"));
                uyeler.setUye_ad(rs.getString("uye_ad"));
                uyeler.setUye_soyad(rs.getString("uye_soyad"));
                uyeler.setEmail(rs.getString("email"));
                uyeler.setTelefon(rs.getString("telefon"));
                uyeler.setUye_id(rs.getInt("uye_id"));
                uyeler.setSifre(rs.getString("sifre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(uyelerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return uyeler;
    }

    public void update(uyeler uyeler) {
        try {
            pst = this.getConnection().prepareStatement("update uyeler set  uye_ad=? , uye_soyad=? , email=? , telefon=? , sifre=? , admin=0 where uye_id=?");
            pst.setString(1, uyeler.getUye_ad());
            pst.setString(2, uyeler.getUye_soyad());
            pst.setString(3, uyeler.getEmail());
            pst.setString(4, uyeler.getTelefon());
            pst.setString(5, uyeler.getSifre());
            pst.setInt(6, uyeler.getUye_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(uyelerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
