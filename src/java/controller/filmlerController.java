package controller;

import dao.filmlerDAO;
import entity.filmler;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class filmlerController implements Serializable {

    private List<filmler> flist;
    private filmler filmler;
    private filmlerDAO filmDAO;

    public filmler getFilmler() {
        if (this.filmler == null) {
            this.filmler = new filmler();
        }
        return filmler;
    }

    public List<filmler> getFlist() throws InstantiationException, IllegalAccessException, SQLException {
        this.flist  = this.getFilmDAO().findAll();
        return flist;
    }

    public void setFlist(List<filmler> flist) {
        this.flist = flist;
    }

    public filmlerDAO getFilmDAO() {
        if(this.filmDAO == null){
            this.filmDAO = new filmlerDAO();
        }
        return filmDAO;
    }

    public void setFilmDAO(filmlerDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

}
