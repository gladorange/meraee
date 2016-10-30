package kyunysh.converters;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("UrlConverter")
public class UrlConverter implements Converter {

	public UrlConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(final FacesContext arg0, final UIComponent arg1, final String arg2) {
		Object result = arg2;
		try {
			result = new URL(arg2);
		} catch (final MalformedURLException e) {
			// Ignore it. Just return it for validation as is.
		}
		return result;
	}

	@Override
	public String getAsString(final FacesContext arg0, final UIComponent arg1, final Object arg2) {
		return arg2.toString();
	}

}
