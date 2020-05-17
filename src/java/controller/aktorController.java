package controller;

import dao.aktorDAO;
import entity.aktor;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

@Named
@SessionScoped
public class aktorController implements Serializable {

    private List<aktor> alist;
    private aktorDAO adao;
    private aktor aktor;
    
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
        this.pageCount = (int) Math.ceil(this.getAdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void updateForm(aktor akt) {
        this.aktor = akt;

    }

    public void clearForm() {
        this.aktor = new aktor();
    }

    public void update()  {
        this.getAdao().update(aktor);
        this.clearForm();
    }

    public void delete()  {
        this.getAdao().delete(aktor);
    }

    public void create()  {
        this.getAdao().create(aktor);
        this.clearForm();
    }

    public void deleteConfirm(aktor aktor) {
        this.aktor = aktor;
    }

    public List<aktor> getAlist()   {
        this.alist = this.getAdao().getAktor(page , pageSize);
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
