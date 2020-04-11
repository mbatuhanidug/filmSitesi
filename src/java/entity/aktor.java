package entity;


public class aktor {
    private int aktor_id;
    private String aktor_ad;
    private String aktor_soyad;

    public aktor() {
    }

    public aktor(int aktor_id, String aktor_ad, String aktor_soyad) {
        this.aktor_id = aktor_id;
        this.aktor_ad = aktor_ad;
        this.aktor_soyad = aktor_soyad;
    }

    public int getAktor_id() {
        return aktor_id;
    }

    public void setAktor_id(int aktor_id) {
        this.aktor_id = aktor_id;
    }

    public String getAktor_ad() {
        return aktor_ad;
    }

    public void setAktor_ad(String aktor_ad) {
        this.aktor_ad = aktor_ad;
    }

    public String getAktor_soyad() {
        return aktor_soyad;
    }

    public void setAktor_soyad(String aktor_soyad) {
        this.aktor_soyad = aktor_soyad;
    }

    @Override
    public String toString() {
        return "aktor{" + "aktor_id=" + aktor_id + ", aktor_ad=" + aktor_ad + ", aktor_soyad=" + aktor_soyad + '}';
    }
    
}
