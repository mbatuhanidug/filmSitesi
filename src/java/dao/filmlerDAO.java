package dao;

import entity.filmler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


public class filmlerDAO {
    private kategorilerDAO kdao;
    
    
    
    public List<filmler> findAll() throws InstantiationException, IllegalAccessException, SQLException{
        List<filmler> flist = new ArrayList();
        
        DBConnection db = new DBConnection();
        Connection conn = db.connect();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from filmler");
            while(rs.next()){
                filmler tmp = new filmler();
                tmp.setFilm_id(rs.getInt("film_id"));
                tmp.setFilm_isim(rs.getString("film_isim"));
                tmp.setFilm_tanimi(rs.getString("film_tanimi"));
                tmp.setCikis_yili(rs.getInt("cikis_yili"));
                tmp.setYonetmen(rs.getString("yonetmen"));
               
                tmp.setKategori(this.getKdao().find(rs.getInt("kategori_id")));
                
                flist.add(tmp);
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       return flist; 
    }

    public kategorilerDAO getKdao() {
        if(this.kdao == null ){
            this.kdao = new kategorilerDAO();
        }
        return kdao;
    }

}
