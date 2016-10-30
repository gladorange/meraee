package evilorange;

import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("userPasswordValidator")
public class PasswordValidator  implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String confirmedPassword = value.toString();
        final UIComponent userForm = context.getViewRoot().findComponent("userForm");
        final UIComponent passwordField = userForm.findComponent("passwordField");
        final String password = ((UIInput) passwordField).getValue().toString();

        if (!Objects.equals(password,confirmedPassword)) {
            FacesMessage msg = new FacesMessage("Passwords are not the same", "Invalid password.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
