
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
    
    @Inject
    private filmlerController filmlerController;

    public void updateForm(yorumlar yorumlar) {
        this.yorumlar = yorumlar;
        
    }
    
    public void clearForm() {
        this.yorumlar = new yorumlar();
    }

    public void update()  {
        this.getYdao().update(this.yorumlar);
        this.clearForm();
        
    }

    public void delete( )  {
        this.getYdao().delete(this.yorumlar);
        this.clearForm();
    }

    public void create()  {
        this.getYdao().create(this.yorumlar);
        this.clearForm();
    }

    public List<yorumlar> getYlist()  {
        this.ylist = this.getYdao().getYorumlar();
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
