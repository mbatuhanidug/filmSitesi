
package entity;


public class puanlar {

    private int puanDegeri;
    private int puan_id;

    public puanlar() {
    }

    public puanlar(int puan_id, int puanDegeri) {
        this.puanDegeri = puanDegeri;
        this.puan_id = puan_id;
    }

    @Override
    public String toString() {
        return "puanlar{" + "puan_degeri=" + puanDegeri + "puan_id=" + puan_id + '}';
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

}
