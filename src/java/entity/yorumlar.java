package entity;

/**
 *
 * @author asus
 */
public class yorumlar {

    private int yorum_id;
    private String yorumMetni;
    
    

    public yorumlar() {
    }

    @Override
    public String toString() {
        return "yorumlar{" + "yorum_id=" + yorum_id + ", yorumMetni=" + yorumMetni +'}';
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



}
