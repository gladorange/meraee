package kyunysh.validators;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("UrlValidator")
public class UrlValidator implements Validator {

	public UrlValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validate(final FacesContext context, final UIComponent component, final Object value)
			throws ValidatorException {
		try {
			new URL(value.toString());
		} catch (final MalformedURLException e) {
			final FacesMessage msg = new FacesMessage("URL validation failed", "Invalid URL format");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

}
