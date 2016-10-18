package evilorange.rs;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cats")
public class CatsResourse {

    private static List<Cat> cats = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cat> getCat() {
        return cats;
    }

    @POST
    @Consumes("application/cat")
    public void saveCat(Cat catToAdd) {
        cats.add(catToAdd);
    }

    public static class Cat {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
