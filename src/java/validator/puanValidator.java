package validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("puanvalidator")
@SessionScoped
public class puanValidator implements Serializable {

    private Collection<FacesMessage> msgList = new ArrayList<>();
    
     public boolean validatePuan(FacesContext fc, UIComponent uı, Object v) {

        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        if (value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Puan Değeri Giriniz ! "));
            isValid = false;
        } else if (value.length() < 0 || value.length() > 11) {
            msgList.add(new FacesMessage("Verilen Puan Değeri 1' den Küçük 10' dan Büyük Olamaz !"));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);
        } else {
            return true;
        }

    }
     
    public Collection<FacesMessage> getMsgList() {
        return msgList;
    }

    public void setMsgList(Collection<FacesMessage> msgList) {
        this.msgList = msgList;
    }

}
