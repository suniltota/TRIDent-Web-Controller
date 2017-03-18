package com.actualize.mortgage.domainmodels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.mismo.residential._2009.schemas.ABOUTVERSIONS;
import org.mismo.residential._2009.schemas.DOCUMENTSETS;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MESSAGE", propOrder = {
    "aboutversions",
    "documentsets"
})
@XmlRootElement(name = "MESSAGE", namespace = "http://www.mismo.org/residential/2009/schemas")
public class MESSAGEModel {
	 @XmlElement(name = "ABOUT_VERSIONS", required = true)
	    protected ABOUTVERSIONS aboutversions;
	    @XmlElement(name = "DOCUMENT_SETS", required = true)
	    protected DOCUMENTSETS documentsets;
	    @XmlAttribute(name = "MISMOReferenceModelIdentifier")
	    protected String mismoReferenceModelIdentifier;
	    @XmlAttribute(name = "xmlns:gse")
	    protected String gseNameSpace = "http://www.datamodelextension.org";
	    @XmlAttribute(name = "xmlns:xlink")
	    protected String xlinkNameSpace = "http://www.w3.org/1999/xlink";
	    
	    /**
	     * Gets the value of the aboutversions property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link ABOUTVERSIONS }
	     *     
	     */
	    public ABOUTVERSIONS getABOUTVERSIONS() {
	        return aboutversions;
	    }

	    /**
	     * Sets the value of the aboutversions property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link ABOUTVERSIONS }
	     *     
	     */
	    public void setABOUTVERSIONS(ABOUTVERSIONS value) {
	        this.aboutversions = value;
	    }

	    /**
	     * Gets the value of the documentsets property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link DOCUMENTSETS }
	     *     
	     */
	    public DOCUMENTSETS getDOCUMENTSETS() {
	        return documentsets;
	    }

	    /**
	     * Sets the value of the documentsets property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link DOCUMENTSETS }
	     *     
	     */
	    public void setDOCUMENTSETS(DOCUMENTSETS value) {
	        this.documentsets = value;
	    }

	    /**
	     * Gets the value of the mismoReferenceModelIdentifier property.
	     * 
	     * @return
	     *     possible object is
	     *     {@link String }
	     *     
	     */
	    public String getMISMOReferenceModelIdentifier() {
	        return mismoReferenceModelIdentifier;
	    }

	    /**
	     * Sets the value of the mismoReferenceModelIdentifier property.
	     * 
	     * @param value
	     *     allowed object is
	     *     {@link String }
	     *     
	     */
	    public void setMISMOReferenceModelIdentifier(String value) {
	        this.mismoReferenceModelIdentifier = value;
	    }
	    
	    /**
	     * @return the gseNameSpace
	     */
	    public String getGseNameSpace() {
	        return gseNameSpace;
	    }

	    /**
	     * @param gseNameSpace the gseNameSpace to set
	     */
	    public void setGseNameSpace(String gseNameSpace) {
	        this.gseNameSpace = gseNameSpace;
	    }

	    /**
	     * @return the xlinkNameSpace
	     */
	    public String getXlinkNameSpace() {
	        return xlinkNameSpace;
	    }

	    /**
	     * @param xlinkNameSpace the xlinkNameSpace to set
	     */
	    public void setXlinkNameSpace(String xlinkNameSpace) {
	        this.xlinkNameSpace = xlinkNameSpace;
	    }

}
