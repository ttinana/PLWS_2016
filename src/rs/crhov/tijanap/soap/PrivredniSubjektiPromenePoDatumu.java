
package rs.crhov.tijanap.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PrivredniSubjektiPromenePoDatumu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrivredniSubjektiPromenePoDatumu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datumOd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="datumDo" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrivredniSubjektiPromenePoDatumu", propOrder = {
    "datumOd",
    "datumDo"
})
public class PrivredniSubjektiPromenePoDatumu {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumOd;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumDo;

    /**
     * Gets the value of the datumOd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumOd() {
        return datumOd;
    }

    /**
     * Sets the value of the datumOd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumOd(XMLGregorianCalendar value) {
        this.datumOd = value;
    }

    /**
     * Gets the value of the datumDo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumDo() {
        return datumDo;
    }

    /**
     * Sets the value of the datumDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumDo(XMLGregorianCalendar value) {
        this.datumDo = value;
    }

}
