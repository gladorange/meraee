package evilorange.rs;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import evilorange.ws.WsExampleInterface;
import evilorange.ws.WsRequest;

@Path("test")
public class TestJaxRS {


    @GET
    public String testWs() throws MalformedURLException {
        URL url = new URL("http://localhost:8080/build/HelloServ?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://ws.evilorange/", "HelloServ");

        Service service = Service.create(url, qname);

        WsExampleInterface hello = service.getPort(WsExampleInterface.class);

        final WsRequest wsRequest = new WsRequest();
        wsRequest.setCount(5);
        return hello.generateRandomNumbers(wsRequest).getNumbers().toString();
    }

    @POST
    @Produces("application/v1+json")
    public void produceJSON() {
        System.out.println("v1");
    }


    @POST
    @Produces("application/v2+json")
    public void produceXML() {
        System.out.println("v2");
    }
}
