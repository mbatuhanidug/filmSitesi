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

    public void updateForm(aktor akt) {
        this.aktor = akt;

    }

    public void clearForm() {
        this.aktor = new aktor();
    }

    public void update() throws SQLException {
        this.getAdao().update(aktor);
        this.clearForm();
    }

    public void delete() throws SQLException {
        this.getAdao().delete(aktor);
    }

    public void create() throws SQLException {
        this.getAdao().create(aktor);
        this.clearForm();
    }

    public void deleteConfirm(aktor aktor) {
        this.aktor = aktor;
    }

    public List<aktor> getAlist() throws SQLException {
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
