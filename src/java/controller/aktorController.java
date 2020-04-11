package controller;

import dao.aktorDAO;
import entity.aktor;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;



import javax.inject.Named;

@Named
@SessionScoped
public class aktorController implements Serializable {

    private List<aktor> alist;
    private aktorDAO adao;

    private aktor aktor;

    public String updateForm(aktor akt) {
        this.aktor = akt;
        return "index";
    }

    public String update() throws InstantiationException, IllegalAccessException, SQLException {
        this.getAdao().update(this.aktor);
        return "index";
    }

    public String delete(aktor akt) throws InstantiationException, SQLException, IllegalAccessException {
        this.getAdao().delete(akt);
        return "index";
    }

    public String create() throws InstantiationException, IllegalAccessException, SQLException {
        this.getAdao().create(this.aktor);
        return "index";
    }

    public List<aktor> getAlist() throws InstantiationException, IllegalAccessException, SQLException {
        this.alist = this.getAdao().getAktor();
        return alist;
    }

    public void setAlist(List<aktor> alist) {
        this.alist = alist;
    }

    public aktorDAO getAdao() {
        if (this.adao == null) {
            this.adao = new aktorDAO();
        }

        return adao;
    }

    public void setAdao(aktorDAO adao) {
        this.adao = adao;
    }

    public aktor getAktor() {
        if (this.aktor == null) {
            this.aktor = new aktor();
        }
        return aktor;
    }

    public void setAktor(aktor aktor) {
        this.aktor = aktor;
    }

}
