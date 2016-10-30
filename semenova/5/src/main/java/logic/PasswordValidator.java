package logic;

import org.apache.commons.lang3.StringUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by ansemen on 06.10.2016.
 */
@FacesValidator("userPasswordValidator")
public class PasswordValidator implements Validator{


    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String confirmedPassword = o.toString();
        final UIComponent userForm = facesContext.getViewRoot().findComponent("userForm");
        final UIComponent passwordField = userForm.findComponent("passwordField");
        final String password = ((UIInput)passwordField).getValue().toString();

        if(!StringUtils.equals(password,confirmedPassword)) {
            throw new ValidatorException(new FacesMessage("Password doesn't equal to confirmed password"));
        }
    }
}
