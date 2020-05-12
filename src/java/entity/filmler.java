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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.film_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final filmler other = (filmler) obj;
        if (this.film_id != other.film_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "filmler{" + "film_id=" + film_id + ", film_isim=" + film_isim + ", film_tanimi=" + film_tanimi + ", cikis_yili=" + cikis_yili + ", yonetmen=" + yonetmen + ", kategori=" + kategori + '}';
    }

}
