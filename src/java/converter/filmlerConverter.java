
package converter;
import dao.filmlerDAO;
import entity.filmler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "filmlerConverter")
public class filmlerConverter implements Converter {
    
     private filmlerDAO fdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getFdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        filmler f = (filmler) o;
        return String.valueOf(f.getFilm_id());
    }

    public filmlerDAO getFdao() {
        if (this.fdao == null) {
            this.fdao = new filmlerDAO();
        }
        return fdao;
    }
}
