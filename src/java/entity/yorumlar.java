package entity;

import java.util.Objects;

public class yorumlar {

    private int yorum_id;
    private String yorumMetni;

    private filmler film;

    public yorumlar() {
    }

    public yorumlar(int yorum_id, String yorumMetni) {
        this.yorum_id = yorum_id;
        this.yorumMetni = yorumMetni;
    }

    public int getYorum_id() {
        return yorum_id;
    }

    public void setYorum_id(int yorum_id) {
        this.yorum_id = yorum_id;
    }

    public String getYorumMetni() {
        return yorumMetni;
    }

    public void setYorumMetni(String yorumMetni) {
        this.yorumMetni = yorumMetni;
    }

    public filmler getFilm() {
        return film;
    }

    public void setFilm(filmler film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "yorumlar{" + "yorum_id=" + yorum_id + ", yorumMetni=" + yorumMetni + ", film=" + film + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.yorum_id;
        hash = 13 * hash + Objects.hashCode(this.yorumMetni);
        hash = 13 * hash + Objects.hashCode(this.film);
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
        final yorumlar other = (yorumlar) obj;
        if (this.yorum_id != other.yorum_id) {
            return false;
        }
        if (!Objects.equals(this.yorumMetni, other.yorumMetni)) {
            return false;
        }
        if (!Objects.equals(this.film, other.film)) {
            return false;
        }
        return true;
    }

}
