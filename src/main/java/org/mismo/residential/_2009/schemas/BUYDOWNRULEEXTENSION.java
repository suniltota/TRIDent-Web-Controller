//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.01 at 06:02:48 PM IST 
//


package org.mismo.residential._2009.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BUYDOWN_RULE_EXTENSION complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BUYDOWN_RULE_EXTENSION">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OTHER" type="{http://www.mismo.org/residential/2009/schemas}OTHER_BUYDOWN_RULE_EXTENSION" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BUYDOWN_RULE_EXTENSION", propOrder = {
    "other"
})
public class BUYDOWNRULEEXTENSION {

    @XmlElement(name = "OTHER")
    protected OTHERBUYDOWNRULEEXTENSION other;

    /**
     * Gets the value of the other property.
     * 
     * @return
     *     possible object is
     *     {@link OTHERBUYDOWNRULEEXTENSION }
     *     
     */
    public OTHERBUYDOWNRULEEXTENSION getOTHER() {
        return other;
    }

    /**
     * Sets the value of the other property.
     * 
     * @param value
     *     allowed object is
     *     {@link OTHERBUYDOWNRULEEXTENSION }
     *     
     */
    public void setOTHER(OTHERBUYDOWNRULEEXTENSION value) {
        this.other = value;
    }

}
