
package controller;

import dao.kullanicilarDAO;
import entity.kullanicilar;
import entity.puanlar;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class kullanicilarController implements Serializable {

    private List<kullanicilar> kullist;
    private kullanicilar kullanicilar;
    private kullanicilarDAO kulDAO;
    
    public String updateForm(kullanicilar kullan) {
        this.kullanicilar = kullan;
        return "index";
    }

    public String update() throws InstantiationException, IllegalAccessException, SQLException {
        this.getKulDAO().update(kullanicilar);
        return "index";
    }

    public String delete(puanlar puan) throws InstantiationException, SQLException, IllegalAccessException {
        this.getKulDAO().delete(kullanicilar);
        return "index";
    }

    public String create() throws InstantiationException, IllegalAccessException, SQLException {
        this.getKulDAO().create(kullanicilar);
        return "index";
    }

    public List<kullanicilar> getKullist() throws InstantiationException, IllegalAccessException, SQLException {
        this.kullist = this.getKulDAO().findAll();
        return kullist;
    }

    public void setKullist(List<kullanicilar> kullist) {
        this.kullist = kullist;
    }

    public kullanicilar getKullanicilar() {
         if (this.kullanicilar == null)
        {
            this.kullanicilar = new kullanicilar();
        }
        return kullanicilar;
    }

    public void setKullanicilar(kullanicilar kullanicilar) {
        this.kullanicilar = kullanicilar;
    }

    public kullanicilarDAO getKulDAO() {
        if (this.kulDAO == null)
        {
            this.kulDAO = new kullanicilarDAO();
        }
        return kulDAO;
    }

    public void setKulDAO(kullanicilarDAO kulDAO) {
        this.kulDAO = kulDAO;
    }
    
}
