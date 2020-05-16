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

@Named("yorumvalidator")
@SessionScoped
public class yorumValidator implements Serializable{
    
    private Collection<FacesMessage> msgList = new ArrayList<>();
    
    public boolean validateYorumMetni(FacesContext fc, UIComponent uı, Object v) {

        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        if (value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Yorum Giriniz ! "));
            isValid = false;
        } else if (value.length() < 3 || value.length() > 500) {
            msgList.add(new FacesMessage("Yorum Metni 3 Karakterden Küçük 500 Karakterden Büyük Olamaz!"));
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
