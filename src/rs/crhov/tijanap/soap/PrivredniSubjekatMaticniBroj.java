
package rs.crhov.tijanap.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrivredniSubjekatMaticniBroj complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrivredniSubjekatMaticniBroj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maticniBroj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tip" type="{http://BusinessEntityDataMediationModule/serviceExport/BusinessEntityDataInterface/}PrivredniSubjekatMaticniBrojTip"/>
 *         &lt;element name="gp" type="{http://BusinessEntityDataMediationModule/serviceExport/BusinessEntityDataInterface/}PrivredniSubjekatGrupaPodataka" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrivredniSubjekatMaticniBroj", propOrder = {
    "maticniBroj",
    "tip",
    "gp"
})
public class PrivredniSubjekatMaticniBroj {

    protected String maticniBroj;
    @XmlElement(required = true)
    protected String tip;
    protected List<PrivredniSubjekatGrupaPodataka> gp;

    /**
     * Gets the value of the maticniBroj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaticniBroj() {
        return maticniBroj;
    }

    /**
     * Sets the value of the maticniBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaticniBroj(String value) {
        this.maticniBroj = value;
    }

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTip(String value) {
        this.tip = value;
    }

    /**
     * Gets the value of the gp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrivredniSubjekatGrupaPodataka }
     * 
     * 
     */
    public List<PrivredniSubjekatGrupaPodataka> getGp() {
        if (gp == null) {
            gp = new ArrayList<PrivredniSubjekatGrupaPodataka>();
        }
        return this.gp;
    }

}
