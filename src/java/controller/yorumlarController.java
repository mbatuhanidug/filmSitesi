
package controller;

import dao.yorumlarDAO;
import entity.yorumlar;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;


import javax.inject.Named;


@Named
@SessionScoped
public class yorumlarController implements Serializable {

    private List<yorumlar> ylist;
    private yorumlarDAO ydao;
    private yorumlar yorumlar;
    
    
    public String updateForm(yorumlar yorumlar) {
        this.yorumlar = yorumlar;
        return "index";
    }

    public String update() throws InstantiationException, IllegalAccessException, SQLException {
        this.getYdao().update(this.yorumlar);
        return "index";
    }

    public String delete(yorumlar yorum) throws InstantiationException, SQLException, IllegalAccessException {
        this.getYdao().delete(yorum);
        return "index";
    }

    public String create() throws InstantiationException, IllegalAccessException, SQLException {
        this.getYdao().create(this.yorumlar);
        return "index";
    }

    public List<yorumlar> getYlist() throws InstantiationException, IllegalAccessException, SQLException {
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

}
