package evilorange.ws;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "Hello",portName = "HelloPort",serviceName = "HelloServ",endpointInterface = "evilorange.ws.WsExampleInterface")
public class WsExample implements WsExampleInterface {


    @Override
    @WebMethod
    public WsResponse generateRandomNumbers(WsRequest request) {
        WsResponse r = new WsResponse();
        Random rnd = new Random();
        for (int i = 0; i < request.getCount(); i++) {
            r.getNumbers().add(String.valueOf(rnd.nextInt()));
        }
        return r;
    }
}
