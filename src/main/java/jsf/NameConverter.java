package jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("userConverter")
public class NameConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        final String[] split = value.split(",");
        return new UserInfo(split[0], split[1]);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((UserInfo)value).toString();
    }
}
