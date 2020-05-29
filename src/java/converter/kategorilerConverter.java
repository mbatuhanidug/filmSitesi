package converter;

import dao.kategorilerDAO;
import entity.kategoriler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "kategorilerConverter")
public class kategorilerConverter implements Converter {

    private kategorilerDAO kdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getKdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        kategoriler k = (kategoriler) o;
        return String.valueOf(k.getKategori_id());
    }

    public kategorilerDAO getKdao() {
        if (this.kdao == null) {
            this.kdao = new kategorilerDAO();
        }
        return kdao;
    }
}
