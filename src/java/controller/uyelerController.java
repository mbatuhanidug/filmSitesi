package controller;
import dao.uyelerDAO;
import entity.uyeler;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class uyelerController implements Serializable {
    private List<uyeler> uyelist;
    private uyelerDAO uyedao;
    private uyeler uye;

    public void updateForm(uyeler uye) {
        this.uye = uye;
    }

    public void clearForm() {
        this.uye = new uyeler();
    }

    public void create() {
        this.getUyedao().create(this.uye);
        this.clearForm();
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
        this.uyelist = this.getUyedao().findAll();
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
