/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.dosyaDAO;
import entity.dosya;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("dosyaConverter")
public class dosyaConverter implements Converter {

    private dosyaDAO ddao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getDocumentDAO().find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        dosya y = (dosya) arg2;
        return String.valueOf(y.getId());
        
    }

    public dosyaDAO getDocumentDAO() {
        if (this.ddao == null) {
            this.ddao = new dosyaDAO();
        }
        return ddao;
    }

}
