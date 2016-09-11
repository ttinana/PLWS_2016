
package rs.crhov.tijanap.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrivredniSubjekatGrupaPodataka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrivredniSubjekatGrupaPodataka">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grupa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrivredniSubjekatGrupaPodataka", propOrder = {
    "grupa"
})
public class PrivredniSubjekatGrupaPodataka {

    protected String grupa;

    /**
     * Gets the value of the grupa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrupa() {
        return grupa;
    }

    /**
     * Sets the value of the grupa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrupa(String value) {
        this.grupa = value;
    }

}
