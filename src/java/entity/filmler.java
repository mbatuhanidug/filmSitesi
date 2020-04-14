package entity;

import java.util.List;

public class filmler {
    private int film_id;
    private String film_isim;
    private String film_tanimi;
    private int cikis_yili;
    private String yonetmen;
 
    private kategoriler kategori;
    private List<aktor> filmAktor; 
    
    private List<yorumlar> yorum_film;
    
    private List<puanlar> puan_film;
    
    
    public filmler() {
    }

    public filmler(int film_id, String film_isim, String film_tanimi, int cikis_yili, String yonetmen, kategoriler kategori) {
        this.film_id = film_id;
        this.film_isim = film_isim;
        this.film_tanimi = film_tanimi;
        this.cikis_yili = cikis_yili;
        this.yonetmen = yonetmen;
    
        this.kategori = kategori;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_isim() {
        return film_isim;
    }

    public void setFilm_isim(String film_isim) {
        this.film_isim = film_isim;
    }

    public String getFilm_tanimi() {
        return film_tanimi;
    }

    public void setFilm_tanimi(String film_tanimi) {
        this.film_tanimi = film_tanimi;
    }

    public int getCikis_yili() {
        return cikis_yili;
    }

    public void setCikis_yili(int cikis_yili) {
        this.cikis_yili = cikis_yili;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(String yonetmen) {
        this.yonetmen = yonetmen;
    }


    public kategoriler getKategori() {
        return kategori;
    }

    public void setKategori(kategoriler kategori) {
        this.kategori = kategori;
    }

    public List<aktor> getFilmAktor() {
        return filmAktor;
    }

    public void setFilmAktor(List<aktor> filmAktor) {
        this.filmAktor = filmAktor;
    }

    public List<yorumlar> getYorum_film() {
        return yorum_film;
    }

    public void setYorum_film(List<yorumlar> yorum_film) {
        this.yorum_film = yorum_film;
    }
    
    
    public List<puanlar> getPuan_film() {
        return puan_film;
    }

    public void setPuan_film(List<puanlar> puan_film) {
        this.puan_film = puan_film;
    }

    @Override
    public String toString() {
        return "filmler{" + "film_id=" + film_id + ", film_isim=" + film_isim + ", film_tanimi=" + film_tanimi + ", cikis_yili=" + cikis_yili + ", yonetmen=" + yonetmen + ", kategori=" + kategori +'}';
    }
    
}