//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.04.19 à 06:52:26 PM CEST 
//


package JlibPdewWdum.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jlibpdewwdum.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RoomsResponse_QNAME = new QName("http://JlibPdewWdum/soap", "RoomsResponse");
    private final static QName _RoomsRequest_QNAME = new QName("http://JlibPdewWdum/soap", "RoomsRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jlibpdewwdum.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RoomsResponse }
     * 
     */
    public RoomsResponse createRoomsResponse() {
        return new RoomsResponse();
    }

    /**
     * Create an instance of {@link RoomsRequest }
     * 
     */
    public RoomsRequest createRoomsRequest() {
        return new RoomsRequest();
    }

    /**
     * Create an instance of {@link RoomsResponse.Room }
     * 
     */
    public RoomsResponse.Room createRoomsResponseRoom() {
        return new RoomsResponse.Room();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoomsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://JlibPdewWdum/soap", name = "RoomsResponse")
    public JAXBElement<RoomsResponse> createRoomsResponse(RoomsResponse value) {
        return new JAXBElement<RoomsResponse>(_RoomsResponse_QNAME, RoomsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoomsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://JlibPdewWdum/soap", name = "RoomsRequest")
    public JAXBElement<RoomsRequest> createRoomsRequest(RoomsRequest value) {
        return new JAXBElement<RoomsRequest>(_RoomsRequest_QNAME, RoomsRequest.class, null, value);
    }

}
