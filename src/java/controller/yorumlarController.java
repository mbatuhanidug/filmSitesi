package controller;

import dao.yorumlarDAO;
import entity.yorumlar;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import javax.inject.Named;

@Named
@SessionScoped
public class yorumlarController implements Serializable {

    private List<yorumlar> ylist;
    private yorumlarDAO ydao;
    private yorumlar yorumlar;
    private int page = 1;
    private int pageSize = 10;
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
        this.pageCount = (int) Math.ceil(this.getYdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    @Inject
    private filmlerController filmlerController;

    public void updateForm(yorumlar yorumlar) {
        this.yorumlar = yorumlar;

    }

    public void clearForm() {
        this.yorumlar = new yorumlar();
    }

    public void update() {
        this.getYdao().update(this.yorumlar);
        this.clearForm();

    }

    public void delete() {
        this.getYdao().delete(this.yorumlar);
        this.clearForm();
    }

    public void create() {
        this.getYdao().create(this.yorumlar);
        this.clearForm();
    }

    public List<yorumlar> getYlist() {
        this.ylist = this.getYdao().getYorumlar(page, pageSize);
        return ylist;
    }

    public void setYlist(List<yorumlar> ylist) {
        this.ylist = ylist;
    }

    public yorumlarDAO getYdao() {
        if (this.ydao == null) {
            this.ydao = new yorumlarDAO();
        }
        return ydao;
    }

    public void setYdao(yorumlarDAO ydao) {
        this.ydao = ydao;
    }

    public yorumlar getYorumlar() {
        if (this.yorumlar == null) {
            this.yorumlar = new yorumlar();
        }
        return yorumlar;
    }

    public void setYorumlar(yorumlar yorumlar) {
        this.yorumlar = yorumlar;
    }

    public filmlerController getFilmlerController() {
        return filmlerController;
    }

    public void setFilmlerController(filmlerController filmlerController) {
        this.filmlerController = filmlerController;
    }

}
