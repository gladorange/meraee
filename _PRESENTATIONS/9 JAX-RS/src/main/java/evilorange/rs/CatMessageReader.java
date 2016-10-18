package evilorange.rs;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import evilorange.rs.CatsResourse.Cat;

@Provider
@Consumes("application/cat")
public class CatMessageReader implements MessageBodyReader<Cat>{
    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public Cat readFrom(Class<Cat> type, Type genericType, Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
        try (final JsonReader reader = Json.createReader(entityStream)) {
            final JsonObject jsonObject = reader.readObject();
            String name = jsonObject.getString("name");
            Cat cat = new Cat();
            cat.setName(name);
            return cat;
        }
    }
}
