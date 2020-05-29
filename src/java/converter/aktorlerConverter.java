package converter;

import dao.aktorDAO;
import entity.aktor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "aktorlerConverter")
public class aktorlerConverter implements Converter {

    private aktorDAO adao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getAdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        aktor a = (aktor) o;
        return String.valueOf(a.getAktor_id());
    }

    public aktorDAO getAdao() {
        if (this.adao == null) {
            this.adao = new aktorDAO();
        }
        return adao;
    }
}
