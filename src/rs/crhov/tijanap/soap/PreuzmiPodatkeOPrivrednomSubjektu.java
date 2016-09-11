
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
 *         &lt;element name="privredniSubjektiUlazniPodaci" type="{http://BusinessEntityDataMediationModule/serviceExport/BusinessEntityDataInterface/}PrivredniSubjektiUlazniPodaci" minOccurs="0"/>
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
    "privredniSubjektiUlazniPodaci"
})
@XmlRootElement(name = "PreuzmiPodatkeOPrivrednomSubjektu")
public class PreuzmiPodatkeOPrivrednomSubjektu {

    protected PrivredniSubjektiUlazniPodaci privredniSubjektiUlazniPodaci;

    /**
     * Gets the value of the privredniSubjektiUlazniPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link PrivredniSubjektiUlazniPodaci }
     *     
     */
    public PrivredniSubjektiUlazniPodaci getPrivredniSubjektiUlazniPodaci() {
        return privredniSubjektiUlazniPodaci;
    }

    /**
     * Sets the value of the privredniSubjektiUlazniPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivredniSubjektiUlazniPodaci }
     *     
     */
    public void setPrivredniSubjektiUlazniPodaci(PrivredniSubjektiUlazniPodaci value) {
        this.privredniSubjektiUlazniPodaci = value;
    }

}
