
package rs.crhov.tijanap.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Podatak complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Podatak">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="vrednost" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tip" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Podatak")
public class Podatak {

    @XmlAttribute(name = "naziv")
    protected String naziv;
    @XmlAttribute(name = "vrednost")
    protected String vrednost;
    @XmlAttribute(name = "tip")
    protected String tip;

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the vrednost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrednost() {
        return vrednost;
    }

    /**
     * Sets the value of the vrednost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrednost(String value) {
        this.vrednost = value;
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

}
