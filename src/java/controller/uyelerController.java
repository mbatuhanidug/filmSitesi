package controller;
import dao.uyelerDAO;
import entity.uyeler;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;



@Named
@SessionScoped
public class uyelerController implements Serializable {
    private List<uyeler> uyelist;
    private uyelerDAO uyedao;
    private uyeler uye;
    
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
        this.pageCount = (int) Math.ceil(this.getUyedao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void updateForm(uyeler uye) {
        this.uye = uye;
    }

    public void clearForm() {
        this.uye = new uyeler();
    }

    public void create() {
        this.getUyedao().create(this.uye);
        this.clearForm();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aramıza Hoşgeldiniz :)"));
    }

    public void delete() {
        this.getUyedao().delete(this.uye);
        this.clearForm();
    }
    
    public String deleteCik(uyeler uye){
        this.getUyedao().delete(uye);
        this.clearForm();
        return "/XHTML/panel/cikis.xhtml";
    }
    
    public void update() {
        this.getUyedao().update(this.uye);
        this.clearForm();
    }

    public List<uyeler> getUyelist() {
        this.uyelist = this.getUyedao().findAll(page, pageSize);
        return uyelist;
    }

    public void setUyelist(List<uyeler> uyelist) {
        this.uyelist = uyelist;
    }

    public uyelerDAO getUyedao() {
        if (this.uyedao == null) {
            this.uyedao = new uyelerDAO();

        }
        return uyedao;
    }

    public void setUyedao(uyelerDAO uyedao) {
        this.uyedao = uyedao;
    }

    public uyeler getUye() {
        if (this.uye == null) {
            this.uye = new uyeler();

        }
        return uye;
    }

    public void setUye(uyeler uye) {
        this.uye = uye;
    }
}
