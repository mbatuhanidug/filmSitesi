package converter;

import dao.uyelerDAO;
import entity.uyeler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "uyelerConverter")
public class uyelerConverter implements Converter {

    private uyelerDAO udao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
        return this.getUdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object o) {
        uyeler u = (uyeler) o;
        return String.valueOf(u.getUye_id());
    }

    public uyelerDAO getUdao() {
        if (this.udao == null) {
            this.udao = new uyelerDAO();
        }
        return udao;
    }

    public void setUdao(uyelerDAO udao) {
        this.udao = udao;
    }

}
