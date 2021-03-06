package com.aryabin.lesson5;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class PasswordValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		String password = (String) value;
		
		UIInput confirmComponent = (UIInput) component.getAttributes().get("confirmPassword");
		String confirmPassword = confirmComponent.getSubmittedValue().toString();
		
		if (password == null || password.isEmpty() || confirmPassword == null || confirmPassword.isEmpty())
			return;
		
		if (!password.equals(confirmPassword)) {
			confirmComponent.setValid(false);
			throw new ValidatorException(new FacesMessage("Please enter equals passwords"));
		}
	}

}
