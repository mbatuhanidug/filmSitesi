/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.uyelerDAO;
import entity.uyeler;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class yetkiController implements Serializable {

    private uyeler uyeler;
    private uyelerDAO uyelerDao;

    public String giris() {
        uyeler = this.getUyelerDao().giris(this.uyeler.getEmail(), this.uyeler.getSifre());
        if (uyeler != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.uyeler);
            return "/XHTML/film/filmler.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı kullanıcı adı ya da şifre."));
            return "/XHTML/panel/giris.xhtml";
        }

    }
    public uyelerDAO getUyelerDao() {
        return uyelerDao == null ? uyelerDao = new uyelerDAO() : uyelerDao;
    }

    public void setUyelerDao(uyelerDAO uyelerDao) {
        this.uyelerDao = uyelerDao;
    }

    public uyeler getUyeler() {
        return uyeler == null ? uyeler = new uyeler() : uyeler;
    }

    public void setUyeler(uyeler uyeler) {
        this.uyeler = uyeler;
    }
}
