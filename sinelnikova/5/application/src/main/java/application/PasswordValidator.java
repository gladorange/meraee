package application;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by Viktoria on 05-Oct-16.
 */
@FacesValidator("userPasswordValidator")
public class PasswordValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        UIComponent userForm = context.getViewRoot().findComponent("userForm");
        UIComponent passwField = userForm.findComponent("passwField");
        String passw = ((UIInput) passwField).getValue().toString();
        System.out.println("passw" + passw);
        System.out.println("value.toString" + value.toString());
        if (!passw.equals(value.toString())) {
            FacesMessage message = new FacesMessage("Wrong password, try again.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

    }
}
