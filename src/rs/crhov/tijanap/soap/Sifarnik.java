
package rs.crhov.tijanap.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Sifarnik complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Sifarnik">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zapis" type="{http://BusinessEntityDataMediationModule/serviceExport/BusinessEntityDataInterface/}Zapis" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sifarnik", propOrder = {
    "zapis"
})
public class Sifarnik {

    protected List<Zapis> zapis;

    /**
     * Gets the value of the zapis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zapis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZapis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Zapis }
     * 
     * 
     */
    public List<Zapis> getZapis() {
        if (zapis == null) {
            zapis = new ArrayList<Zapis>();
        }
        return this.zapis;
    }

}
