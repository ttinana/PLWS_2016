
package rs.crhov.tijanap.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrivredniSubjekat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrivredniSubjekat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grupa" type="{http://BusinessEntityDataMediationModule/serviceExport/BusinessEntityDataInterface/}Grupa" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="tip" use="required" type="{http://BusinessEntityDataMediationModule/serviceExport/BusinessEntityDataInterface/}PrivredniSubjekatMaticniBrojTip" />
 *       &lt;attribute name="maticniBroj" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrivredniSubjekat", propOrder = {
    "grupa"
})
public class PrivredniSubjekat {

    protected List<Grupa> grupa;
    @XmlAttribute(name = "tip", required = true)
    protected String tip;
    @XmlAttribute(name = "maticniBroj")
    protected String maticniBroj;

    /**
     * Gets the value of the grupa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grupa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrupa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Grupa }
     * 
     * 
     */
    public List<Grupa> getGrupa() {
        if (grupa == null) {
            grupa = new ArrayList<Grupa>();
        }
        return this.grupa;
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

}
