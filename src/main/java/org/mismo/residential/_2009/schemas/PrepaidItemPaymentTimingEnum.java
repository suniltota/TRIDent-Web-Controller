//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.01 at 06:02:48 PM IST 
//


package org.mismo.residential._2009.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Defines the point in time during the origination process when the prepaid item payment was paid.
 * 
 * <p>Java class for PrepaidItemPaymentTimingEnum complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrepaidItemPaymentTimingEnum">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.mismo.org/residential/2009/schemas>PrepaidItemPaymentTimingBase">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrepaidItemPaymentTimingEnum", propOrder = {
    "value"
})
public class PrepaidItemPaymentTimingEnum {

    @XmlValue
    protected PrepaidItemPaymentTimingBase value;

    /**
     * Term: Prepaid Item Payment Timing Type Definition: Defines the point in time during the origination process when the prepaid item payment was paid.
     * 
     * @return
     *     possible object is
     *     {@link PrepaidItemPaymentTimingBase }
     *     
     */
    public PrepaidItemPaymentTimingBase getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrepaidItemPaymentTimingBase }
     *     
     */
    public void setValue(PrepaidItemPaymentTimingBase value) {
        this.value = value;
    }

}
