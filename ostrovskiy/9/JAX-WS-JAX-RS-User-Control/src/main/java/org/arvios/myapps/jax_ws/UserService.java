package org.arvios.myapps.jax_ws;

import org.arvios.myapps.data.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by artem-ostrovsky on 13.11.2016.
 */
@WebService
public class UserService {

    @WebMethod
    public List<User> getUsers(WsRequest req) {
        WsResponse resp = new WsResponse();
        return resp.getUsers();
    }

    @WebMethod
    public User getUserById(WsRequest req) {
        WsResponse resp = new WsResponse();
        return resp.getUserById(req.getId());
    }
}
