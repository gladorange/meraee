package org.arvios.jpaapps.validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by artem-ostrovsky on 19.10.2016.
 */
@FacesValidator("userPasswordValidator")
public class UserPasswordValidator implements Validator {
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String passwordStr = (String) uiComponent.getAttributes().get("attConfirmPassword");
        UIInput passwordComponent = (UIInput) facesContext.getViewRoot().findComponent(passwordStr);
        String password = (String) passwordComponent.getValue();

        String confirmPassword = (String) o;

        if (password == null || password.isEmpty()
                || confirmPassword == null || confirmPassword.isEmpty()) {
            return;
        }

        if (!password.equals(confirmPassword)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwords are not equal", null));
        }
    }
}
