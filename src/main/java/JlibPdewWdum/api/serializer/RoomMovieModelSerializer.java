package JlibPdewWdum.api.serializer;

import JlibPdewWdum.api.core.Constants;
import JlibPdewWdum.api.model.RoomMovieModel;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

/**
 * Created by daolf on 20/04/15.
 */
public class RoomMovieModelSerializer extends JsonSerializer<RoomMovieModel> {

    public static final String path = Constants.path;

    @Override
    public void serialize(RoomMovieModel o, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeStringField("room", path + "/room/" + Integer.toString(o.getRoom().getIdRoom()));
        jgen.writeStringField("movie", path + "/movie/" + o.getMovie());
        jgen.writeNumberField("nbPlaceUsed", o.getNbPlaceUsed());
        jgen.writeStringField("date", o.getDate().toString());
        jgen.writeStringField("localisation", o.getLocalisation().getIntitule());
        jgen.writeStringField("technologie", o.getTechno().getIntitule());
        jgen.writeEndObject();
    }
}
