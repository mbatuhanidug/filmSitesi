package controller;

import dao.filmlerDAO;
import entity.filmler;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import javax.inject.Named;

@Named
@SessionScoped
public class filmlerController implements Serializable {

    private List<filmler> flist;
    private filmler filmler;
    private filmlerDAO filmDAO;

    @Inject
    private aktorController aktorController;
    @Inject
    private kategorilerController kategorilerController;

    public void updateForm(filmler film) {
        this.filmler = film;
    }

    public void clearForm() {
        this.filmler = new filmler();
    }

    public void create()  {

        this.getFilmDAO().insert(this.filmler);

        this.clearForm();
    }

    public void deleteConfirm(filmler film) {
        this.filmler = film;
    }

    public void delete()  {
        this.getFilmDAO().delete(filmler);
        this.clearForm();
    }

    public void update() {
        this.getFilmDAO().update(filmler);
        this.clearForm();
    }

    public List<filmler> getFlist() {
        this.flist = this.getFilmDAO().findAll();
        return flist;
    }

    public void setFlist(List<filmler> flist) {
        this.flist = flist;
    }

    public filmler getFilmler() {
        if (this.filmler == null) {
            this.filmler = new filmler();
        }
        return filmler;
    }

    public void setFilmler(filmler film) {
        this.filmler = film;
    }

    public filmlerDAO getFilmDAO() {
        if (this.filmDAO == null) {
            this.filmDAO = new filmlerDAO();
        }
        return filmDAO;
    }

    public void setFilmDAO(filmlerDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    public aktorController getAktorController() {
        return aktorController;
    }

    public kategorilerController getKategorilerController() {
        return kategorilerController;
    }

}
