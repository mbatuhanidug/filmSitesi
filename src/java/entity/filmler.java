package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class filmler {

    private int film_id;
    private String film_isim;
    private String film_tanimi;
    private int cikis_yili;
    private String yonetmen;
    private double imbd;
    private String fragman;

    private dosya dosya;
    private kategoriler kategori;
    private List<aktor> filmAktor;

    public filmler() {

    }

    public filmler(int film_id, String film_isim, String film_tanimi, int cikis_yili, String yonetmen, double imbd, String fragman, kategoriler kategori) {
        this.film_id = film_id;
        this.film_isim = film_isim;
        this.film_tanimi = film_tanimi;
        this.cikis_yili = cikis_yili;
        this.yonetmen = yonetmen;
        this.imbd = imbd;
        this.fragman = fragman;
        this.kategori = kategori;
    }

    public dosya getDosya() {
        return dosya;
    }

    public void setDosya(dosya dosya) {
        this.dosya = dosya;
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
        if (this.filmAktor == null) {
            this.filmAktor = new ArrayList<>();
        }
        return filmAktor;
    }

    public void setFilmAktor(List<aktor> filmAktor) {
        this.filmAktor = filmAktor;
    }

    public double getImbd() {
        return imbd;
    }

    public void setImbd(double imbd) {
        this.imbd = imbd;
    }

    public String getFragman() {
        return fragman;
    }

    public void setFragman(String fragman) {
        this.fragman = fragman;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.film_id;
        hash = 37 * hash + Objects.hashCode(this.film_isim);
        hash = 37 * hash + Objects.hashCode(this.film_tanimi);
        hash = 37 * hash + this.cikis_yili;
        hash = 37 * hash + Objects.hashCode(this.yonetmen);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.imbd) ^ (Double.doubleToLongBits(this.imbd) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.fragman);
        hash = 37 * hash + Objects.hashCode(this.dosya);
        hash = 37 * hash + Objects.hashCode(this.kategori);
        hash = 37 * hash + Objects.hashCode(this.filmAktor);
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
        if (this.cikis_yili != other.cikis_yili) {
            return false;
        }
        if (Double.doubleToLongBits(this.imbd) != Double.doubleToLongBits(other.imbd)) {
            return false;
        }
        if (!Objects.equals(this.film_isim, other.film_isim)) {
            return false;
        }
        if (!Objects.equals(this.film_tanimi, other.film_tanimi)) {
            return false;
        }
        if (!Objects.equals(this.yonetmen, other.yonetmen)) {
            return false;
        }
        if (!Objects.equals(this.fragman, other.fragman)) {
            return false;
        }
        if (!Objects.equals(this.dosya, other.dosya)) {
            return false;
        }
        if (!Objects.equals(this.kategori, other.kategori)) {
            return false;
        }
        if (!Objects.equals(this.filmAktor, other.filmAktor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "filmler{" + "film_id=" + film_id + ", film_isim=" + film_isim + ", film_tanimi=" + film_tanimi + ", cikis_yili=" + cikis_yili + ", yonetmen=" + yonetmen + ", imbd=" + imbd + ", fragman=" + fragman + ", dosya=" + dosya + ", kategori=" + kategori + ", filmAktor=" + filmAktor + '}';
    }

}
