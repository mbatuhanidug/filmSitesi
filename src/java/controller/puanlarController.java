package controller;

import dao.puanlarDAO;
import entity.puanlar;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class puanlarController implements Serializable {

    private List<puanlar> plist;
    private puanlarDAO pdao;
    private puanlar puanlar;
    
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
        this.pageCount = (int) Math.ceil(this.getPdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    @Inject
    private filmlerController filmlerController;
    
    @Inject
    private uyelerController uyelerController;

    public void updateForm(puanlar puan) {
        this.puanlar = puan;
    }

    public void clearForm() {
        this.puanlar = new puanlar();
    }

    public void update() {
        this.getPdao().update(this.puanlar);
        this.clearForm();

    }

    public void delete() {
        this.getPdao().delete(puanlar);
        this.clearForm();

    }

    public void create() {
        this.getPdao().create(this.puanlar);
        this.clearForm();
    }

    public void deleteConfirm(puanlar puan) {
        this.puanlar = puan;
    }

    public List<puanlar> getPlist() {
        this.plist = this.getPdao().getPuanlar(page, pageSize);
        return plist;
    }

    public void setPlist(List<puanlar> plist) {
        this.plist = plist;
    }

    public puanlarDAO getPdao() {
        if (this.pdao == null) {
            this.pdao = new puanlarDAO();
        }
        return pdao;
    }

    public void setPdao(puanlarDAO pdao) {
        this.pdao = pdao;
    }

    public puanlar getPuanlar() {
        if (this.puanlar == null) {
            this.puanlar = new puanlar();
        }
        return puanlar;
    }

    public void setPuanlar(puanlar puanlar) {
        this.puanlar = puanlar;
    }

    public filmlerController getFilmlerController() {
        return filmlerController;
    }

    public void setFilmlerController(filmlerController filmlerController) {
        this.filmlerController = filmlerController;
    }

    public uyelerController getUyelerController() {
        return uyelerController;
    }

    public void setUyelerController(uyelerController uyelerController) {
        this.uyelerController = uyelerController;
    }

}
