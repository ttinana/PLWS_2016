
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
 *         &lt;element name="privredniSubjektiPromenePoDatumuUlazniPodaci" type="{http://BusinessEntityDataMediationModule/serviceExport/BusinessEntityDataInterface/}PrivredniSubjektiPromenePoDatumu" minOccurs="0"/>
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
    "privredniSubjektiPromenePoDatumuUlazniPodaci"
})
@XmlRootElement(name = "PreuzmiPromenePodatakaOPrivrednimSubjektima")
public class PreuzmiPromenePodatakaOPrivrednimSubjektima {

    protected PrivredniSubjektiPromenePoDatumu privredniSubjektiPromenePoDatumuUlazniPodaci;

    /**
     * Gets the value of the privredniSubjektiPromenePoDatumuUlazniPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link PrivredniSubjektiPromenePoDatumu }
     *     
     */
    public PrivredniSubjektiPromenePoDatumu getPrivredniSubjektiPromenePoDatumuUlazniPodaci() {
        return privredniSubjektiPromenePoDatumuUlazniPodaci;
    }

    /**
     * Sets the value of the privredniSubjektiPromenePoDatumuUlazniPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivredniSubjektiPromenePoDatumu }
     *     
     */
    public void setPrivredniSubjektiPromenePoDatumuUlazniPodaci(PrivredniSubjektiPromenePoDatumu value) {
        this.privredniSubjektiPromenePoDatumuUlazniPodaci = value;
    }

}
