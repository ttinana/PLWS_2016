
package rs.crhov.tijanap.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrivredniSubjektiUlazniPodaci complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrivredniSubjektiUlazniPodaci">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="privredniSubjekti" type="{http://BusinessEntityDataMediationModule/serviceExport/BusinessEntityDataInterface/}PrivredniSubjekatMaticniBroj" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrivredniSubjektiUlazniPodaci", propOrder = {
    "privredniSubjekti"
})
public class PrivredniSubjektiUlazniPodaci {

    protected PrivredniSubjekatMaticniBroj privredniSubjekti;

    /**
     * Gets the value of the privredniSubjekti property.
     * 
     * @return
     *     possible object is
     *     {@link PrivredniSubjekatMaticniBroj }
     *     
     */
    public PrivredniSubjekatMaticniBroj getPrivredniSubjekti() {
        return privredniSubjekti;
    }

    /**
     * Sets the value of the privredniSubjekti property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivredniSubjekatMaticniBroj }
     *     
     */
    public void setPrivredniSubjekti(PrivredniSubjekatMaticniBroj value) {
        this.privredniSubjekti = value;
    }

}
