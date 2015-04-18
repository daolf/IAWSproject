package JlibPdewWdum.api.soap.ws;

import JlibPdewWdum.api.soap.services.MovieODBService;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

/**
 * Endpoint class that to handle incoming XML messages.
 *
 * Created by Wladimir du Manoir, droit on 18/04/15.
 */

// Following the tutorial of :
//http://docs.spring.io/spring-ws/site/reference/html/tutorial.html#tutorial.implementing.endpoint

@Endpoint
public class MovieEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080/myapp/soap/schemas";

    private XPath idomdbExpression;
    private XPath technoExpression;
    private XPath localisationExpression;
    private MovieODBService movieODBService;

    //TODO put in wsdl file <wsdl:service name="MovieODBService">
    @Autowired
    public MovieEndpoint(MovieODBService movieODBService)
            throws JDOMException {
        this.movieODBService = movieODBService;
        Namespace namespace = Namespace.getNamespace("saop", NAMESPACE_URI);

        idomdbExpression = XPath.newInstance("//soap:Idomdb");
        idomdbExpression.addNamespace(namespace);

        technoExpression = XPath.newInstance("//soap:Techno");
        technoExpression.addNamespace(namespace);

        localisationExpression = XPath.newInstance("//soap:Localisation");
        localisationExpression.addNamespace(namespace);

    }
        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "MovieRequest")
        public void handleMovieRequest(@RequestPayload Element movieRequest) throws JDOMException {

            String idomdb = idomdbExpression.valueOf(movieRequest);
            String techno = technoExpression.valueOf(movieRequest);
            String localisation = localisationExpression.valueOf(movieRequest);

            movieODBService.FindByMovie(idomdb);
            movieODBService.FindByTechno(techno);
            movieODBService.FindByLocalisation(localisation);
        }

}
