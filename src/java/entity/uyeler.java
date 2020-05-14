
package entity;


public class uyeler extends kullanicilar{
    private int uye_id;
    private String uye_sifre;
    
   
    public uyeler (){
        
    }

    public uyeler(int uye_id, String uye_sifre) {
        this.uye_id = uye_id;
        this.uye_sifre = uye_sifre;
       
    }

    public int getUye_id() {
        return uye_id;
    }

    public void setUye_id(int uye_id) {
        this.uye_id = uye_id;
    }

    public String getUye_sifre() {
        return uye_sifre;
    }

    public void setUye_sifre(String uye_sifre) {
        this.uye_sifre = uye_sifre;
    }

   

    @Override
    public String toString() {
        return "uyeler{" + "uye_id=" + uye_id + ", uye_sifre=" + uye_sifre + '}';
    }

}

 