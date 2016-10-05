package com.seprokof.usercard.service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Simple picture URL validator.
 * 
 * @author seprokof
 *
 */
@FacesValidator("pictureValidator")
public class PictureValidator implements Validator {

	/**
	 * Validates URL for the picture.
	 * 
	 * @param context
	 * @param componentToValidate
	 * @param value
	 * @throws ValidatorException
	 */
	@Override
	public void validate(FacesContext context, UIComponent componentToValidate, Object value)
			throws ValidatorException {
		String url = String.valueOf(value);
		if (url != null && !url.isEmpty()) {
			try {
				new URL(url);
			} catch (MalformedURLException e) {
				throw new ValidatorException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect picture URL", null));
			}
		}
	}

}
