
package entity;

import java.util.Objects;


public class puanlar {

    private int puanDegeri;
    private int puan_id;
    
    private filmler film;
    
    public puanlar() {
    }

    public puanlar(int puan_id, int puanDegeri) {
        this.puanDegeri = puanDegeri;
        this.puan_id = puan_id;
    }

 
    public int getPuanDegeri() {
        return puanDegeri;
    }

    public void setPuanDegeri(int puanDegeri) {
        this.puanDegeri = puanDegeri;
    }

    public int getPuan_id() {
        return puan_id;
    }

    public void setPuan_id(int puan_id) {
        this.puan_id = puan_id;
    }

    public filmler getFilm() {
        return film;
    }

    public void setFilm(filmler film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "puanlar{" + "puanDegeri=" + puanDegeri + ", puan_id=" + puan_id + ", film=" + film + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.puanDegeri;
        hash = 61 * hash + this.puan_id;
        hash = 61 * hash + Objects.hashCode(this.film);
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
        final puanlar other = (puanlar) obj;
        if (this.puanDegeri != other.puanDegeri) {
            return false;
        }
        if (this.puan_id != other.puan_id) {
            return false;
        }
        if (!Objects.equals(this.film, other.film)) {
            return false;
        }
        return true;
    }

}
