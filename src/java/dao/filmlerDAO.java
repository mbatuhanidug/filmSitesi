package dao;

import entity.aktor;
import entity.filmler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class filmlerDAO extends superDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    private kategorilerDAO kdao;
    private aktorDAO adao;

    public void insert(filmler film) {

        try {
            pst = this.getConnection().prepareStatement("insert into filmler (film_isim,film_tanimi,cikis_yili,yonetmen, kategori_id,imbd)"
                    + " values (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, film.getFilm_isim());
            pst.setString(2, film.getFilm_tanimi());
            pst.setInt(3, film.getCikis_yili());
            pst.setString(4, film.getYonetmen());
            pst.setInt(5, film.getKategori().getKategori_id());
            pst.setDouble(6, film.getImbd());

            pst.executeUpdate();
//******************************************************Film_aktor tablosuna insert işlemi
          int film_id = 0;
            ResultSet gk = pst.getGeneratedKeys();

            if (gk.next()) {
                film_id = gk.getInt(1);
            }

            
            for (aktor ak : film.getFilmAktor()) {

                pst = this.getConnection().prepareStatement("INSERT INTO  film_aktor (film_id,aktor_id) values (?,?)");
                pst.setInt(1, film_id);
                pst.setInt(2, ak.getAktor_id());
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(" FilmlerDAO HATA(Create): " + ex.getMessage());
        }
    }
    
  
    public void delete(filmler film) {

        try {

            pst = this.getConnection().prepareStatement("DELETE FROM filmler WHERE film_id=?");
            pst.setInt(1, film.getFilm_id());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(" FilmlerDAO HATA(Delete): " + ex.getMessage());
        }
    }

    public List<filmler> findAll() {

        List<filmler> flist = new ArrayList();
        try {

            pst = this.getConnection().prepareStatement("SELECT * FROM filmler ORDER BY film_isim ASC");
            rs = pst.executeQuery();
            while (rs.next()) {
                filmler temp = new filmler();

                temp.setFilm_id(rs.getInt("film_id"));
                temp.setFilm_isim(rs.getString("film_isim"));
                temp.setFilm_tanimi(rs.getString("film_tanimi"));
                temp.setCikis_yili(rs.getInt("cikis_yili"));
                temp.setYonetmen(rs.getString("yonetmen"));
                temp.setImbd(rs.getDouble("imbd"));
               
                temp.setKategori(this.getKdao().find(rs.getInt("kategori_id")));
                temp.setFilmAktor(this.getAdao().getFilmAktor(rs.getInt("film_id")));
                
                flist.add(temp);
            }
            //System.out.println("***************************Liste Boyutu:"+flist.get(0).getFilmAktor().toString());
        } catch (SQLException ex) {
            System.out.println("filmlerDAO HATA(ReadAll):" + ex.getMessage());
        }
        return flist;
    }


    public void update(filmler f) {

        try {

            pst = this.getConnection().prepareStatement("UPDATE filmler SET film_isim=?,film_tanimi=?,cikis_yili=?,"
                    + "yonetmen=?,kategori_id=?, imbd=? where film_id=?");
            pst.setString(1, f.getFilm_isim());
            pst.setString(2, f.getFilm_tanimi());
            pst.setInt(3, f.getCikis_yili());
            pst.setString(4, f.getYonetmen());
            pst.setInt(5, f.getKategori().getKategori_id());
            pst.setDouble(6, f.getImbd());
            pst.setInt(7, f.getFilm_id());

            pst.executeUpdate();

            //Önce 3. tablodan servisleri siliyoruz.
            pst = this.getConnection().prepareStatement("DELETE FROM film_aktor where film_id=?");
            pst.setInt(1, f.getFilm_id());
            pst.executeUpdate();
            //Burada tekrar ekliyoruz.
            for (aktor ak : f.getFilmAktor()) {

                pst = this.getConnection().prepareStatement("INSERT INTO  film_aktor (film_id,aktor_id) values (?,?)");
                pst.setInt(1, f.getFilm_id());
                pst.setInt(2, ak.getAktor_id());
                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println("filmlerDAO HATA(Update): " + ex.getMessage());
        }
    }

    public filmler find(int id) {

        filmler temp = null;
        try {

            pst = this.getConnection().prepareStatement("SELECT * FROM filmler WHERE film_id=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                temp = new filmler();
                temp.setFilm_id(rs.getInt("film_id"));
                temp.setFilm_isim(rs.getString("film_isim"));
                temp.setFilm_tanimi(rs.getString("film_tanimi"));
                temp.setCikis_yili(rs.getInt("cikis_yili"));
                temp.setYonetmen(rs.getString("yonetmen"));
                temp.setImbd(rs.getDouble("imbd"));
                temp.setKategori(this.getKdao().find(rs.getInt("kategori_id")));
                temp.setFilmAktor(this.getAdao().getFilmAktor(rs.getInt("film_id")));   //Buraya dikkat buradan patlayabilir!
            }

        } catch (SQLException ex) {
            System.out.println("filmlerDAO HATA(FİND) :" + ex.getMessage());
        }
        return temp;
    }

    public kategorilerDAO getKdao() {
        if (this.kdao == null) {
            this.kdao = new kategorilerDAO();
        }
        return kdao;
    }

    public void setKdao(kategorilerDAO kdao) {
        this.kdao = kdao;
    }

    public aktorDAO getAdao() {
        if (this.adao == null) {
            this.adao = new aktorDAO();
        }
        return adao;
    }

    public void setAdao(aktorDAO adao) {
        this.adao = adao;
    }

}
