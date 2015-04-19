package JlibPdewWdum.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by jlibert on 19/04/2015.
 */

@Endpoint
public class MovieEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRoomsRequest")
    @ResponsePayload
    public RoomsResponse getCountry(@RequestPayload RoomsRequest request) {
        RoomsResponse response = new RoomsResponse();
        //response.setCountry(countryRepository.findCountry(request.getName()));
        response.setIdOmdb("tt0987654");
        RoomsResponse.Room room = new RoomsResponse.Room();
        room.setIdRoom("1");
        room.setLocalisation("VOSTFR");
        room.setTechno("IMAX");
        response.room.add(room);
        return response;
    }
}
