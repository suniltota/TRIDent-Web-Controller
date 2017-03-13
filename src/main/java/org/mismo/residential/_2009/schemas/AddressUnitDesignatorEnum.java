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
 * An additional address designation that further defines the delivery location. Example: Apartment, Building, Condo, Suite, Room, Mail Stop, Unit, etc.  This list is based on the USPS Publication 28 on Postal Addressing Standards with the addition of Condo based on mortgage industry need.
 * 
 * <p>Java class for AddressUnitDesignatorEnum complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressUnitDesignatorEnum">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.mismo.org/residential/2009/schemas>AddressUnitDesignatorBase">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressUnitDesignatorEnum", propOrder = {
    "value"
})
public class AddressUnitDesignatorEnum {

    @XmlValue
    protected AddressUnitDesignatorBase value;

    /**
     * Term: Address Unit Designator Type Definition: An additional address designation that further defines the delivery location. Example: Apartment, Building, Condo, Suite, Room, Mail Stop, Unit, etc.  This list is based on the USPS Publication 28 on Postal Addressing Standards with the addition of Condo based on mortgage industry need.
     * 
     * @return
     *     possible object is
     *     {@link AddressUnitDesignatorBase }
     *     
     */
    public AddressUnitDesignatorBase getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressUnitDesignatorBase }
     *     
     */
    public void setValue(AddressUnitDesignatorBase value) {
        this.value = value;
    }

}
