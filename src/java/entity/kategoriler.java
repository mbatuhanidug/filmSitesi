package entity;

import java.util.Objects;

public class kategoriler {

    private int kategori_id;
    private String kategori_ad;

    public kategoriler() {
    }

    public kategoriler(int kategori_id, String kategori_ad) {
        this.kategori_id = kategori_id;
        this.kategori_ad = kategori_ad;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getKategori_ad() {
        return kategori_ad;
    }

    public void setKategori_ad(String kategori_ad) {
        this.kategori_ad = kategori_ad;
    }

    @Override
    public String toString() {
        return "kategoriler{" + "kategori_id=" + kategori_id + ", kategori_ad=" + kategori_ad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.kategori_id;
        hash = 59 * hash + Objects.hashCode(this.kategori_ad);
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
        final kategoriler other = (kategoriler) obj;
        if (this.kategori_id != other.kategori_id) {
            return false;
        }
        if (!Objects.equals(this.kategori_ad, other.kategori_ad)) {
            return false;
        }
        return true;
    }

}
