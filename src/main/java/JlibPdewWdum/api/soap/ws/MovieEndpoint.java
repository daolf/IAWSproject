package JlibPdewWdum.api.soap.ws;

import JlibPdewWdum.api.soap.services.MovieODBService;
import org.jdom.JDOMException;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

/**
 * Endpoint class that to handle incoming XML messages.
 *
 * Created by Wladimir du Manoir, droit on 18/04/15.
 */

// Following the tutorial of :
//http://docs.spring.io/spring-ws/site/reference/html/tutorial.html#tutorial.implementing.endpoint

@Endpoint
public class MovieEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080/myapp/soap";

    private XPath idomdb;
    private XPath techno;
    private XPath localisation;

    //TODO put in wsdl file <wsdl:service name="MovieODBService">
    @Autowired
    public MovieEndpoint(MovieODBService movieODBService)
            throws JDOMException {

    }
}
