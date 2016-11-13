package org.arvios.myapps.jax_ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by artem-ostrovsky on 13.11.2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="wsRequest", propOrder = {"id"})
public class WsRequest {
    protected String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
