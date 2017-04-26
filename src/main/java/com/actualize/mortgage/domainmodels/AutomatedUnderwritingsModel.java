/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * 
 * @author sboragala
 *
 */
public class AutomatedUnderwritingsModel implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3912293383777860056L;
	
	private String automatedUnderwritingCaseIdentifier;
	private String automatedUnderwritingSystemType;
	private String automatedUnderwritingSystemTypeOtherDescription;
	
	/**
	 * @return the automatedUnderwritingCaseIdentifier
	 */
	public String getAutomatedUnderwritingCaseIdentifier() {
		return automatedUnderwritingCaseIdentifier;
	}
	/**
	 * @param automatedUnderwritingCaseIdentifier the automatedUnderwritingCaseIdentifier to set
	 */
	public void setAutomatedUnderwritingCaseIdentifier(String automatedUnderwritingCaseIdentifier) {
		this.automatedUnderwritingCaseIdentifier = automatedUnderwritingCaseIdentifier;
	}
	/**
	 * @return the automatedUnderwritingSystemType
	 */
	public String getAutomatedUnderwritingSystemType() {
		return automatedUnderwritingSystemType;
	}
	/**
	 * @param automatedUnderwritingSystemType the automatedUnderwritingSystemType to set
	 */
	public void setAutomatedUnderwritingSystemType(String automatedUnderwritingSystemType) {
		this.automatedUnderwritingSystemType = automatedUnderwritingSystemType;
	}
	/**
	 * @return the automatedUnderwritingSystemTypeOtherDescription
	 */
	public String getAutomatedUnderwritingSystemTypeOtherDescription() {
		return automatedUnderwritingSystemTypeOtherDescription;
	}
	/**
	 * @param automatedUnderwritingSystemTypeOtherDescription the automatedUnderwritingSystemTypeOtherDescription to set
	 */
	public void setAutomatedUnderwritingSystemTypeOtherDescription(String automatedUnderwritingSystemTypeOtherDescription) {
		this.automatedUnderwritingSystemTypeOtherDescription = automatedUnderwritingSystemTypeOtherDescription;
	}
	
	

}
