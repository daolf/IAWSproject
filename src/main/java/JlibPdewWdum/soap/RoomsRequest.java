//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.04.19 à 06:52:26 PM CEST 
//


package JlibPdewWdum.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour RoomsRequest complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="RoomsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idOmdb" type="{http://JlibPdewWdum/soap/}idOmdbType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomsRequest", propOrder = {
    "idOmdb"
})
public class RoomsRequest {

    @XmlElement(required = true)
    protected String idOmdb;

    /**
     * Obtient la valeur de la propriété idOmdb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdOmdb() {
        return idOmdb;
    }

    /**
     * Définit la valeur de la propriété idOmdb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdOmdb(String value) {
        this.idOmdb = value;
    }

}
