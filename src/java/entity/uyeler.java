package entity;

import java.util.Objects;

public class uyeler {
    
   private int uye_id;
   private String uye_ad;
   private String uye_soyad;
   private String email;
   private String telefon;
   private String sifre;
   private boolean admin;
   
   
    public uyeler() {
    }
    
 
    public uyeler(int uye_id, String uye_ad, String uye_soyad, String email, String telefon, String sifre, boolean admin) {
        this.uye_id = uye_id;
        this.uye_ad = uye_ad;
        this.uye_soyad = uye_soyad;
        this.email = email;
        this.telefon = telefon;
        this.sifre = sifre;
        this.admin = admin;
    }

    public int getUye_id() {
        return uye_id;
    }

    public void setUye_id(int uye_id) {
        this.uye_id = uye_id;
    }

    public String getUye_ad() {
        return uye_ad;
    }

    public void setUye_ad(String uye_ad) {
        this.uye_ad = uye_ad;
    }

    public String getUye_soyad() {
        return uye_soyad;
    }

    public void setUye_soyad(String uye_soyad) {
        this.uye_soyad = uye_soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "uyeler{" + "uye_id=" + uye_id + ", uye_ad=" + uye_ad + ", uye_soyad=" + uye_soyad + ", email=" + email + ", telefon=" + telefon + ", sifre=" + sifre + ", admin=" + admin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.uye_id;
        hash = 73 * hash + Objects.hashCode(this.uye_ad);
        hash = 73 * hash + Objects.hashCode(this.uye_soyad);
        hash = 73 * hash + Objects.hashCode(this.email);
        hash = 73 * hash + Objects.hashCode(this.telefon);
        hash = 73 * hash + Objects.hashCode(this.sifre);
        hash = 73 * hash + (this.admin ? 1 : 0);
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
        if (this.admin != other.admin) {
            return false;
        }
        if (!Objects.equals(this.uye_ad, other.uye_ad)) {
            return false;
        }
        if (!Objects.equals(this.uye_soyad, other.uye_soyad)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefon, other.telefon)) {
            return false;
        }
        if (!Objects.equals(this.sifre, other.sifre)) {
            return false;
        }
        return true;
    }

    


}
