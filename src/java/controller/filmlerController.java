package controller;

import dao.dosyaDAO;
import dao.filmlerDAO;
import entity.filmler;
import java.io.Serializable;
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

    private String bul="";

    private dosyaDAO ddao;


    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getFilmDAO().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Inject
    private aktorController aktorController;
    @Inject
    private kategorilerController kategorilerController;
    @Inject
    private dosyaController dosyaController;

    public void updateForm(filmler film) {
        this.filmler = film;
    }

    public void clearForm() {
        this.filmler = new filmler();
    }

    public void create() {

        this.getFilmDAO().insert(this.filmler);

        this.clearForm();
    }

    public void deleteConfirm(filmler film) {
        this.filmler = film;
    }

    public void delete() {
        this.getFilmDAO().delete(filmler);
        this.clearForm();
    }

    public void update() {
        this.getFilmDAO().update(filmler);
        this.clearForm();
    }

    public List<filmler> getFlist() {
        this.flist = this.getFilmDAO().findAll(this.bul,this.page, this.pageSize);
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


    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public dosyaController getDosyaController() {
        return dosyaController;
    }

    public void setDosyaController(dosyaController dosyaController) {
        this.dosyaController = dosyaController;
    }

    public dosyaDAO getDdao() {
        if (this.ddao == null) {
            this.ddao = new dosyaDAO();    
        }
        return ddao;
    }

    public void setDdao(dosyaDAO ddao) {
        this.ddao = ddao;
    }
    

    
}
