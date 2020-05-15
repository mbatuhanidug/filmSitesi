package entity;

public class kullanicilar {

    private int kullanici_id;
    private String kullanici_ad;
    private String kullanici_soyad;
    private String email;
    private String telefon;
    private boolean admin;
    private String sifre;

    public kullanicilar() {
    }

    public kullanicilar(int kullanici_id, String kullanici_ad, String kullanici_soyad, String email, String telefon, boolean admin, String sifre) {
        this.kullanici_id = kullanici_id;
        this.kullanici_ad = kullanici_ad;
        this.kullanici_soyad = kullanici_soyad;
        this.email = email;
        this.telefon = telefon;
        this.admin = admin;
        this.sifre = sifre;
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

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKullanici_ad() {
        return kullanici_ad;
    }

    public void setKullanici_ad(String kullanici_ad) {
        this.kullanici_ad = kullanici_ad;
    }

    public String getKullanici_soyad() {
        return kullanici_soyad;
    }

    public void setKullanici_soyad(String kullanici_soyad) {
        this.kullanici_soyad = kullanici_soyad;
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

    @Override
    public String toString() {
        return "kullanicilar{" + "kullanici_id=" + kullanici_id + ", kullanici_ad=" + kullanici_ad + ", kullanici_soyad=" + kullanici_soyad + ", email=" + email + ", telefon=" + telefon + ", admin=" + admin + ", sifre=" + sifre + '}';
    }

    

}
