package controller;

import dao.puanlarDAO;
import entity.puanlar;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
/*
<h:inputText styleClass ="form-control"   value="#{puanlarController.puanlar.puanDegeri}"/>
*/
@Named
@SessionScoped
public class puanlarController implements Serializable {

    private List<puanlar> plist;
    private puanlarDAO pdao;
    private puanlar puanlar;
    
    @Inject
    private filmlerController filmlerController;

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
        this.plist = this.getPdao().getPuanlar();
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

}
