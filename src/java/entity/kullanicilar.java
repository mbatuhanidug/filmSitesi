package entity;

public class kullanicilar {

    private int K_id;
    private String K_Ad;
    private String K_Soyad;
    private String E_mail;
    private int Telefon_no;

    public kullanicilar() {

    }

    public kullanicilar(int K_id, String K_Ad, String K_Soyad, String E_mail, int Telefon_no) {
        this.K_id = K_id;
        this.K_Ad = K_Ad;
        this.K_Soyad = K_Soyad;
        this.E_mail = E_mail;
        this.Telefon_no = Telefon_no;

    }

    public int getK_id() {
        return K_id;
    }

    public void setK_id(int K_id) {
        this.K_id = K_id;
    }

    public String getK_Ad() {
        return K_Ad;
    }

    public void setK_Ad(String K_Ad) {
        this.K_Ad = K_Ad;
    }

    public String getK_Soyad() {
        return K_Soyad;
    }

    public void setK_Soyad(String K_Soyad) {
        this.K_Soyad = K_Soyad;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String E_mail) {
        this.E_mail = E_mail;
    }

    public int getTelefon_no() {
        return Telefon_no;
    }

    public void setTelefon_no(int Telefon_no) {
        this.Telefon_no = Telefon_no;
    }

    @Override
    public String toString() {
        return "kullanicilar{" + "K_id=" + K_id + ", K_Ad=" + K_Ad + ", K_Soyad=" + K_Soyad + ", E_mail=" + E_mail + ", Telefon_no=" + Telefon_no + '}';
    }


}
