package controller;

import dao.kategorilerDAO;
import entity.kategoriler;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

@Named
@SessionScoped
public class kategorilerController implements Serializable {

    private List<kategoriler> klist;
    private kategorilerDAO kdao;

    private kategoriler kategoriler;

     
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
        this.pageCount = (int) Math.ceil(this.getKdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    
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
        this.klist = this.getKdao().getKategori(page, pageSize);
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
