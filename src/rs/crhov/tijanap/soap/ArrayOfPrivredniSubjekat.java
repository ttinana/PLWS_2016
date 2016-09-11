
package rs.crhov.tijanap.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPrivredniSubjekat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPrivredniSubjekat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrivredniSubjekat" type="{http://BusinessEntityDataMediationModule/serviceExport/BusinessEntityDataInterface/}PrivredniSubjekat" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPrivredniSubjekat", propOrder = {
    "privredniSubjekat"
})
public class ArrayOfPrivredniSubjekat {

    @XmlElement(name = "PrivredniSubjekat", nillable = true)
    protected List<PrivredniSubjekat> privredniSubjekat;

    /**
     * Gets the value of the privredniSubjekat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the privredniSubjekat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrivredniSubjekat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrivredniSubjekat }
     * 
     * 
     */
    public List<PrivredniSubjekat> getPrivredniSubjekat() {
        if (privredniSubjekat == null) {
            privredniSubjekat = new ArrayList<PrivredniSubjekat>();
        }
        return this.privredniSubjekat;
    }

}
