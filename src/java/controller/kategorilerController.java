package controller;

import dao.kategorilerDAO;
import entity.kategoriler;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;


import javax.inject.Named;

@Named
@SessionScoped
public class kategorilerController implements Serializable {
    private List<kategoriler> klist;
    private kategorilerDAO kdao;
    
    private kategoriler kategoriler;
    
    
    
    public String updateForm(kategoriler kat){
        this.kategoriler = kat;
        return "index";
    }
    
    public String update() throws InstantiationException, IllegalAccessException, SQLException{
        this.getKdao().update(this.kategoriler);
        return "index";
    }
    
    public String delete(kategoriler kat) throws InstantiationException, SQLException, IllegalAccessException{ 
        this.getKdao().delete(kat);
        return "index"; 
    }
    
    public String create() throws InstantiationException, IllegalAccessException, SQLException{ 
        this.getKdao().create(this.kategoriler); 
        return "index";   
    }

    public List<kategoriler> getKlist() throws InstantiationException, IllegalAccessException, SQLException  {
        this.klist = this.getKdao().getKategori();
        return klist;
    }

    public void setKlist(List<kategoriler> klist) {
        this.klist = klist;
    }

    public kategorilerDAO getKdao() {
        if(this.kdao ==null){
            this.kdao = new kategorilerDAO();
        }
        return kdao;
    }

    public void setKdao(kategorilerDAO kdao) {
        this.kdao = kdao;
    }

    public kategoriler getKategoriler() {
        if(this.kategoriler == null){
            this.kategoriler = new kategoriler();
        }
        return kategoriler;
    }

    public void setKategoriler(kategoriler kategoriler) {
        this.kategoriler = kategoriler;
    }
    
    
}
