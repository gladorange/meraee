package com.seprokof.usercard.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import com.seprokof.usercard.dao.UserCard;

/**
 * Converter for {@link UserCard}.
 * 
 * @author seprokof
 *
 */
@FacesConverter(value = "ucConverter")
public class UserCardPickListConverter implements Converter {
	private static final Pattern ID_PARSER = Pattern.compile("\\((.*?)\\)");

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		Object ret = null;
		if (component instanceof PickList) {
			PickList p = (PickList) component;
			DualListModel dualList = (DualListModel) p.getValue();
			Long id = Long.valueOf(value);
			Optional<UserCard> c = searchInList(dualList.getSource(), id);
			if (!c.isPresent()) {
				c = searchInList(dualList.getTarget(), id);
				if (c.isPresent()) {
					ret = c.get();
				} else {
					throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Unable to restore UserCard object by ", String.valueOf(id)));
				}
			} else {
				ret = c.get();
			}
		}
		return ret;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		String ret = null;
		if (component instanceof PickList) {
			if (value instanceof UserCard) {
				UserCard card = (UserCard) value;
				ret = String.valueOf(card.getId());
			}
		}
		return ret;
	}

	private Optional<UserCard> searchInList(List<UserCard> source, Long id) {
		return source.stream().filter(item -> id.equals(item.getId())).findFirst();
	}

}
