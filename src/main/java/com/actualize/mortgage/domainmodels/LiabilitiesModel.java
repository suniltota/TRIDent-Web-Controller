package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

public class LiabilitiesModel implements Serializable{

	private static final long serialVersionUID = 5179234670256309537L;
	
	private String type;
	private String payoffAmount;
	private String fullName;
	private String label;
	private String IDSection;
	private String description;
	private String securedBySubjectProperty;
	private boolean PayoffPartialIndicator;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPayoffAmount() {
		return payoffAmount;
	}
	public void setPayoffAmount(String payoffAmount) {
		this.payoffAmount = payoffAmount;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getIDSection() {
		return IDSection;
	}
	public void setIDSection(String iDSection) {
		IDSection = iDSection;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSecuredBySubjectProperty() {
		return securedBySubjectProperty;
	}
	public void setSecuredBySubjectProperty(String securedBySubjectProperty) {
		this.securedBySubjectProperty = securedBySubjectProperty;
	}
	public boolean isPayoffPartialIndicator() {
		return PayoffPartialIndicator;
	}
	public void setPayoffPartialIndicator(boolean payoffPartialIndicator) {
		PayoffPartialIndicator = payoffPartialIndicator;
	}
	
	

}
