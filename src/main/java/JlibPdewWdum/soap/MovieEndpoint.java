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

        return response;
    }
}
