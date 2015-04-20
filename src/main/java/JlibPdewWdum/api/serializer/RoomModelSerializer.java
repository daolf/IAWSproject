package JlibPdewWdum.api.serializer;

import JlibPdewWdum.api.model.RoomModel;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

/**
 * Created by daolf on 20/04/15.
 */
public class RoomModelSerializer extends JsonSerializer<RoomModel> {

    public static final String path = "http://localhost:8080/myapp";

    @Override
    public void serialize(RoomModel o, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeStringField("idRoom", Integer.toString(o.getIdRoom()));
        jgen.writeStringField("cinema", path+"/cinema/"+o.getIdCinema());
        jgen.writeNumberField("nbPlace", o.getNbPlaceRoom());
        jgen.writeEndObject();
    }
}
