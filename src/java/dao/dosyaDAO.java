package dao;

import entity.dosya;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dosyaDAO extends superDAO {

    PreparedStatement pst;
    ResultSet rs;

    public void insert(dosya dosya) {

        try {
            pst = this.getConnection().prepareStatement("insert into dosya(dosya_isim, dosya_path, dosya_tipi) values(?,?,?)");
            pst.setString(1, dosya.getDosya_isim());
            pst.setString(2, dosya.getDosya_path());
            pst.setString(3, dosya.getDosya_tipi());

            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" DosyaDAO (İnsert): " + ex.getMessage());
        }
    }

    public void delete(dosya dosya) {

        try {
            pst = this.getConnection().prepareStatement("delete from dosya where dosya_id=?");
            pst.setInt(1, dosya.getId());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" DosyaDAO (Delete): " + ex.getMessage());
        }
    }

    public List<dosya> findAll(int page, int pageSize) {
        List<dosya> dlist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            pst = this.getConnection().prepareStatement("select * from dosya order by dosya_id ASC limit " + start + "," + pageSize);

            rs = pst.executeQuery();

            while (rs.next()) {
                dosya temp = new dosya(rs.getInt("dosya_id"), rs.getString("dosya_isim"), rs.getString("dosya_path"), rs.getString("dosya_tipi"));
                dlist.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("DosyaDAO (FindAll):" + ex.getMessage());
        }
        return dlist;
    }

    public dosya find(int id) {
        dosya d = null;
        try {
            pst = this.getConnection().prepareStatement("select * from dosya where dosya_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            d = new dosya(rs.getInt("dosya_id"), rs.getString("dosya_isim"), rs.getString("dosya_path"), rs.getString("dosya_tipi"));

        } catch (SQLException ex) {
            System.out.println("DosyaDAO (FİND) :" + ex.getMessage());
        }
        return d;
    }

    public int count() {

        int count = 0;
        try {

            pst = this.getConnection().prepareStatement("SELECT count(dosya_id) as dosya_count from dosya ");
            rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("dosya_count");

        } catch (SQLException ex) {
            System.out.println("dosyaDAO HATA(ReadAll):" + ex.getMessage());
        }
        return count;
    }

    public void update(dosya dosya) {

        try {
            pst = this.getConnection().prepareStatement("update dosya set dosya_isim=?,dosya_path=?,dosya_tipi=? where dosya_id=?");
            pst.setString(1, dosya.getDosya_isim());
            pst.setString(2, dosya.getDosya_path());
            pst.setString(3, dosya.getDosya_tipi());
            pst.setInt(4, dosya.getId());

            pst.executeUpdate();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("DosyaDAO Update): " + ex.getMessage());
        }
    }

}
