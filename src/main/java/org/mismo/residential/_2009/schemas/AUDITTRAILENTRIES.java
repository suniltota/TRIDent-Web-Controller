//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.01 at 06:02:48 PM IST 
//


package org.mismo.residential._2009.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AUDIT_TRAIL_ENTRIES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AUDIT_TRAIL_ENTRIES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AUDIT_TRAIL_ENTRY" type="{http://www.mismo.org/residential/2009/schemas}AUDIT_TRAIL_ENTRY" maxOccurs="100" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUDIT_TRAIL_ENTRIES", propOrder = {
    "audittrailentry"
})
public class AUDITTRAILENTRIES {

    @XmlElement(name = "AUDIT_TRAIL_ENTRY")
    protected List<AUDITTRAILENTRY> audittrailentry;

    /**
     * Gets the value of the audittrailentry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the audittrailentry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAUDITTRAILENTRY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUDITTRAILENTRY }
     * 
     * 
     */
    public List<AUDITTRAILENTRY> getAUDITTRAILENTRY() {
        if (audittrailentry == null) {
            audittrailentry = new ArrayList<AUDITTRAILENTRY>();
        }
        return this.audittrailentry;
    }

}
