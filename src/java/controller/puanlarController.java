
package controller;

import dao.puanlarDAO;
import entity.puanlar;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;


import javax.inject.Named;


@Named
@SessionScoped
public class puanlarController implements Serializable {

    private List<puanlar> plist;
    private puanlarDAO pdao;
    private puanlar puanlar;

    public String updateForm(puanlar puan) {
        this.puanlar = puan;
        return "index";
    }

    public String update() throws InstantiationException, IllegalAccessException, SQLException {
        this.getPdao().update(this.puanlar);
        return "index";
    }

    public String delete(puanlar puan) throws InstantiationException, SQLException, IllegalAccessException {
        this.getPdao().delete(puan);
        return "index";
    }

    public String create() throws InstantiationException, IllegalAccessException, SQLException {
        this.getPdao().create(this.puanlar);
        return "index";
    }

    public List<puanlar> getPlist() throws InstantiationException, IllegalAccessException, SQLException {
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

}
