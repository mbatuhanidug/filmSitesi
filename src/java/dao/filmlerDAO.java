package dao;

import entity.filmler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

public class filmlerDAO {

    private kategorilerDAO kdao;
    private aktorDAO adao;

    public List<filmler> findAll() throws InstantiationException, IllegalAccessException, SQLException {
        List<filmler> flist = new ArrayList();

        DBConnection db = new DBConnection();
        Connection conn = db.connect();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from filmler");
            //select film_id,film_isim,film_tanimi,cikis_yili,yonetmen,kategori_ad from filmler inner join  kategoriler on kategoriler.kategori_id = filmler.kategori_id
            while (rs.next()) {
                filmler tmp = new filmler();
                tmp.setFilm_id(rs.getInt("film_id"));
                tmp.setFilm_isim(rs.getString("film_isim"));
                tmp.setFilm_tanimi(rs.getString("film_tanimi"));
                tmp.setCikis_yili(rs.getInt("cikis_yili"));
                tmp.setYonetmen(rs.getString("yonetmen"));
                
                tmp.setFilmAktor(this.getAdao().getFilmAktor(tmp.getFilm_id()));

                tmp.setKategori(this.getKdao().find(rs.getInt("kategori_id")));

                flist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return flist;
    }

    public kategorilerDAO getKdao() {
        if (this.kdao == null) {
            this.kdao = new kategorilerDAO();
        }
        return kdao;
    }

    public aktorDAO getAdao() {
        if(this.adao == null){
           this.adao = new aktorDAO(); 
        }
        return adao;
    }
    
    

    public void create(filmler filmler, int selectedKategori) throws InstantiationException, IllegalAccessException, SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("insert into filmler (film_isim,film_tanimi,cikis_yili,yonetmen,kategori_id) values ('" + filmler.getFilm_isim() + "','" + filmler.getFilm_tanimi() + "'," + filmler.getCikis_yili() + ",'" + filmler.getYonetmen() + "'," + selectedKategori + ")");
        } catch (SQLException ex) {
            Logger.getLogger(filmlerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void update(filmler film) throws InstantiationException, IllegalAccessException, SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("update filmler set film_isim = '"+film.getFilm_isim()+"',film_tanimi ='"+film.getFilm_tanimi()+"', cikis_yili = "+film.getCikis_yili()+",yonetmen='"+film.getYonetmen()+"' where film_id= "+film.getFilm_id());
        } catch (SQLException ex) {
            Logger.getLogger(filmlerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void delete(filmler film)  throws InstantiationException, SQLException, IllegalAccessException{
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("delete from filmler where film_isim = '"+film.getFilm_isim()+"'");
        } catch (SQLException ex) {
            Logger.getLogger(kategorilerDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
