package JlibPdewWdum.api.soap.sample;

import org.jdom.xpath.XPath;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

/**
 * Endpoint class that to handle incoming XML messages.
 * Created by Wladimir du Manoir, droit on 18/04/15.
 */

@Endpoint
public class MovieEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080/myapp/";

    private XPath idomdb;
    private XPath techno;
    private XPath localisation;

}
