
package converter;

import dao.yorumlarDAO;
import entity.yorumlar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "yorumlarConverter")
public class yorumlarConverter implements Converter {
    
    private yorumlarDAO ydao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getYdao().find(Integer.valueOf(string));
    }
    
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        yorumlar y = (yorumlar) o;
        return String.valueOf(y.getYorum_id());
    }

    public yorumlarDAO getYdao() {
        if (this.ydao == null) {
            this.ydao = new yorumlarDAO();
        }
        return ydao;
    }
 
}
