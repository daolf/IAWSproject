//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.04.19 à 06:52:26 PM CEST 
//


package JlibPdewWdum.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour RoomsResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="RoomsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idOmdb" type="{http://JlibPdewWdum/soap/}idOmdbType"/>
 *         &lt;element name="Room" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="idRoom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="techno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="localisation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomsResponse", propOrder = {
    "idOmdb",
    "room"
})
public class RoomsResponse {

    @XmlElement(required = true)
    protected String idOmdb;
    @XmlElement(name = "Room")
    protected List<RoomsResponse.Room> room;

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

    /**
     * Gets the value of the room property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the room property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomsResponse.Room }
     * 
     * 
     */
    public List<RoomsResponse.Room> getRoom() {
        if (room == null) {
            room = new ArrayList<RoomsResponse.Room>();
        }
        return this.room;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="idRoom" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="techno" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="localisation" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "idRoom",
        "techno",
        "localisation"
    })
    public static class Room {

        @XmlElement(required = true)
        protected String idRoom;
        @XmlElement(required = true)
        protected String techno;
        @XmlElement(required = true)
        protected String localisation;

        /**
         * Obtient la valeur de la propriété idRoom.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdRoom() {
            return idRoom;
        }

        /**
         * Définit la valeur de la propriété idRoom.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdRoom(String value) {
            this.idRoom = value;
        }

        /**
         * Obtient la valeur de la propriété techno.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTechno() {
            return techno;
        }

        /**
         * Définit la valeur de la propriété techno.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTechno(String value) {
            this.techno = value;
        }

        /**
         * Obtient la valeur de la propriété localisation.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocalisation() {
            return localisation;
        }

        /**
         * Définit la valeur de la propriété localisation.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocalisation(String value) {
            this.localisation = value;
        }

    }

}
