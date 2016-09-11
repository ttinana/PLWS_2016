
package rs.crhov.tijanap.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="privredniSubjektiPodaci" type="{http://BusinessEntityDataMediationModule/serviceExport/BusinessEntityDataInterface/}ArrayOfPrivredniSubjekat" minOccurs="0"/>
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
    "privredniSubjektiPodaci"
})
@XmlRootElement(name = "PreuzmiPromenePodatakaOPrivrednimSubjektimaResponse")
public class PreuzmiPromenePodatakaOPrivrednimSubjektimaResponse {

    protected ArrayOfPrivredniSubjekat privredniSubjektiPodaci;

    /**
     * Gets the value of the privredniSubjektiPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPrivredniSubjekat }
     *     
     */
    public ArrayOfPrivredniSubjekat getPrivredniSubjektiPodaci() {
        return privredniSubjektiPodaci;
    }

    /**
     * Sets the value of the privredniSubjektiPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPrivredniSubjekat }
     *     
     */
    public void setPrivredniSubjektiPodaci(ArrayOfPrivredniSubjekat value) {
        this.privredniSubjektiPodaci = value;
    }

}
