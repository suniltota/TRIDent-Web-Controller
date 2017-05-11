/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * @author sboragala
 *
 */
public class DocumentClassificationModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6033855861747719873L;
	
	private String documentType;
	private String documentTypeOtherDescription;
	private String documentFormIssuingEntityNameType;
	private String documentFormIssuingEntityVersionIdentifier;
	private boolean documentSignatureRequiredIndicator;
	
	/**
	 * @return the documentType
	 */
	public String getDocumentType() {
		return documentType;
	}
	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	/**
	 * @return the documentTypeOtherDescription
	 */
	public String getDocumentTypeOtherDescription() {
		return documentTypeOtherDescription;
	}
	/**
	 * @param documentTypeOtherDescription the documentTypeOtherDescription to set
	 */
	public void setDocumentTypeOtherDescription(String documentTypeOtherDescription) {
		this.documentTypeOtherDescription = documentTypeOtherDescription;
	}
	/**
	 * @return the documentFormIssuingEntityNameType
	 */
	public String getDocumentFormIssuingEntityNameType() {
		return documentFormIssuingEntityNameType;
	}
	/**
	 * @param documentFormIssuingEntityNameType the documentFormIssuingEntityNameType to set
	 */
	public void setDocumentFormIssuingEntityNameType(String documentFormIssuingEntityNameType) {
		this.documentFormIssuingEntityNameType = documentFormIssuingEntityNameType;
	}
	/**
	 * @return the documentFormIssuingEntityVersionIdentifier
	 */
	public String getDocumentFormIssuingEntityVersionIdentifier() {
		return documentFormIssuingEntityVersionIdentifier;
	}
	/**
	 * @param documentFormIssuingEntityVersionIdentifier the documentFormIssuingEntityVersionIdentifier to set
	 */
	public void setDocumentFormIssuingEntityVersionIdentifier(String documentFormIssuingEntityVersionIdentifier) {
		this.documentFormIssuingEntityVersionIdentifier = documentFormIssuingEntityVersionIdentifier;
	}
	/**
	 * @return the documentSignatureRequiredIndicator
	 */
	public boolean isDocumentSignatureRequiredIndicator() {
		return documentSignatureRequiredIndicator;
	}
	/**
	 * @param documentSignatureRequiredIndicator the documentSignatureRequiredIndicator to set
	 */
	public void setDocumentSignatureRequiredIndicator(boolean documentSignatureRequiredIndicator) {
		this.documentSignatureRequiredIndicator = documentSignatureRequiredIndicator;
	} 
	
	

}
