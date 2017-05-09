/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines ContactInformation in JSON response
 * @author sboragala
 *
 */
public class ContactInformationModel implements Serializable {

	private static final long serialVersionUID = -7662263979240332066L;
	
	private ContactInformationDetail lender;
	private ContactInformationDetail mortagageBroker;
	private ContactInformationDetail realEstateBrokerB;
	private ContactInformationDetail realEstateBrokerS;
	private ContactInformationDetail settlementAgent;
	
	/**
	 * @return the lender
	 */
	public ContactInformationDetail getLender() {
		return lender;
	}
	/**
	 * @param lender the lender to set
	 */
	public void setLender(ContactInformationDetail lender) {
		this.lender = lender;
	}
	/**
	 * @return the mortagageBroker
	 */
	public ContactInformationDetail getMortagageBroker() {
		return mortagageBroker;
	}
	/**
	 * @param mortagageBroker the mortagageBroker to set
	 */
	public void setMortagageBroker(ContactInformationDetail mortagageBroker) {
		this.mortagageBroker = mortagageBroker;
	}
	/**
	 * @return the realEstateBrokerB
	 */
	public ContactInformationDetail getRealEstateBrokerB() {
		return realEstateBrokerB;
	}
	/**
	 * @param realEstateBrokerB the realEstateBrokerB to set
	 */
	public void setRealEstateBrokerB(ContactInformationDetail realEstateBrokerB) {
		this.realEstateBrokerB = realEstateBrokerB;
	}
	/**
	 * @return the realEstateBrokerS
	 */
	public ContactInformationDetail getRealEstateBrokerS() {
		return realEstateBrokerS;
	}
	/**
	 * @param realEstateBrokerS the realEstateBrokerS to set
	 */
	public void setRealEstateBrokerS(ContactInformationDetail realEstateBrokerS) {
		this.realEstateBrokerS = realEstateBrokerS;
	}
	/**
	 * @return the settlementAgent
	 */
	public ContactInformationDetail getSettlementAgent() {
		return settlementAgent;
	}
	/**
	 * @param settlementAgent the settlementAgent to set
	 */
	public void setSettlementAgent(ContactInformationDetail settlementAgent) {
		this.settlementAgent = settlementAgent;
	}
	
}
