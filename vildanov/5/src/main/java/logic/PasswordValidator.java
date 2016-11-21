package logic;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Objects;

/**
 * Created by svildan on 25.10.2016.
 */
@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {
    public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
        String confirmedPassword = value.toString();
        final UIComponent userForm = facesContext.getViewRoot().findComponent("reg_form");
        final UIComponent passwordField = userForm.findComponent("password");
        final String password = ((UIInput) passwordField).getValue().toString();

        if (!Objects.equals(password,confirmedPassword)) {
            FacesMessage msg = new FacesMessage("Passwords are not the same", "Invalid password.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
