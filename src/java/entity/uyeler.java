package entity;

import java.util.Objects;

public class uyeler extends kullanicilar {
    
   private int uye_id;


    public uyeler() {
    }

    public uyeler(int uye_id, int kullanici_id, String kullanici_ad, String kullanici_soyad, String email, String telefon, boolean admin, String sifre) {
        super(kullanici_id, kullanici_ad, kullanici_soyad, email, telefon, admin, sifre);
        this.uye_id = uye_id;
    }


    public int getUye_id() {
        return uye_id;
    }

    public void setUye_id(int uye_id) {
        this.uye_id = uye_id;
    }

    @Override
    public String toString() {
        return "uyeler{" + "uye_id=" + uye_id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.uye_id;
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
        final uyeler other = (uyeler) obj;
        if (this.uye_id != other.uye_id) {
            return false;
        }
        return true;
    }


}
