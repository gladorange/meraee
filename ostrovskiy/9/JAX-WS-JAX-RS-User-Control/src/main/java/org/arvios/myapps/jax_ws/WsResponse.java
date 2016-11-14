package org.arvios.myapps.jax_ws;

import org.arvios.myapps.data.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by artem-ostrovsky on 13.11.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="wsResponse", propOrder = {"users"})
public class WsResponse {
    @XmlElement(nillable = true)
    protected Map<String, User> users;

    public List<User> getUsers() {
        if (users == null) {
            return new ArrayList<User>();
        }

        return (List<User>)this.users.values();
    }

    public User getUserById(String id) {
        if (!users.containsKey(id)) {
            users.put(id, new User());
        }

        return this.users.get(id);
    }
}
