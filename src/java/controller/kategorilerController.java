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

    public void updateForm(kategoriler kat) {
        this.kategoriler = kat;
    }

    public void clearForm() {
        this.kategoriler = new kategoriler();
    }

    public void update()  {
        this.getKdao().update(this.kategoriler);
        this.clearForm();
    }

    public void delete()  {
        this.getKdao().delete(this.kategoriler);
        this.clearForm();
    }

    public void create() {
        this.getKdao().create(this.kategoriler);
        this.clearForm();
    }

    public void deleteConfirm(kategoriler kat) {
        this.kategoriler = kat;
    }

    public List<kategoriler> getKlist() {
        this.klist = this.getKdao().getKategori();
        return klist;
    }

    public void setKlist(List<kategoriler> klist) {
        this.klist = klist;
    }

    public kategorilerDAO getKdao() {
        if (this.kdao == null) {
            this.kdao = new kategorilerDAO();
        }
        return kdao;
    }

    public void setKdao(kategorilerDAO kdao) {
        this.kdao = kdao;
    }

    public kategoriler getKategoriler() {
        if (this.kategoriler == null) {
            this.kategoriler = new kategoriler();
        }
        return kategoriler;
    }

    public void setKategoriler(kategoriler kategoriler) {
        this.kategoriler = kategoriler;
    }

}
