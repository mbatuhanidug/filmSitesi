
package controller;

import dao.uyelerDAO;
import entity.uyeler;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
 
@Named
@SessionScoped
public class uyelerController {
    
    private List<uyeler> uyelist;
    private uyeler uyeler;
    private uyelerDAO uyeDAO;
    
    public String updateForm(uyeler uye) {
        this.uyeler = uye;
        return "index";
    }

    public String update() throws InstantiationException, IllegalAccessException, SQLException {
        this.getuyeDAO().update(uyeler);
        return "index";
    }

    public String delete(uyeler uye) throws InstantiationException, SQLException, IllegalAccessException {
        this.getuyeDAO().delete(uyeler);
        return "index";
    }

    public String create() throws InstantiationException, IllegalAccessException, SQLException {
        this.getuyeDAO().create(uyeler);
        return "index";
    }

    public List<uyeler> getUyelist() throws InstantiationException, IllegalAccessException, SQLException {
        this.uyelist=this.getuyeDAO().findAll();
        return uyelist;
    }

    public void setUyelist(List<uyeler> uyelist) {
        this.uyelist = uyelist;
    }

    public uyeler getUyeler() {
         if (this.uyeler == null)
        {
            this.uyeler = new uyeler();
        }
        return uyeler;
    }

    public void setUyeler(uyeler uyeler) {
        this.uyeler = uyeler;
    }

    public uyelerDAO getuyeDAO() {
        if (this.uyeDAO == null)
        {
            this.uyeDAO = new uyelerDAO();
        }
        return uyeDAO;
    }

    public void setUyeDAO(uyelerDAO uyeDAO) {
        this.uyeDAO = uyeDAO;
    }
    
}


