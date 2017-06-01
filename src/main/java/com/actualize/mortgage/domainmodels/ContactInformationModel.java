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
	
	private ContactInformationDetailModel lender;
	private ContactInformationDetailModel mortagageBroker;
	private ContactInformationDetailModel realEstateBrokerB;
	private ContactInformationDetailModel realEstateBrokerS;
	private ContactInformationDetailModel settlementAgent;
	
	/**
	 * @return the lender
	 */
	public ContactInformationDetailModel getLender() {
		return lender;
	}
	/**
	 * @param lender the lender to set
	 */
	public void setLender(ContactInformationDetailModel lender) {
		this.lender = lender;
	}
	/**
	 * @return the mortagageBroker
	 */
	public ContactInformationDetailModel getMortagageBroker() {
		return mortagageBroker;
	}
	/**
	 * @param mortagageBroker the mortagageBroker to set
	 */
	public void setMortagageBroker(ContactInformationDetailModel mortagageBroker) {
		this.mortagageBroker = mortagageBroker;
	}
	/**
	 * @return the realEstateBrokerB
	 */
	public ContactInformationDetailModel getRealEstateBrokerB() {
		return realEstateBrokerB;
	}
	/**
	 * @param realEstateBrokerB the realEstateBrokerB to set
	 */
	public void setRealEstateBrokerB(ContactInformationDetailModel realEstateBrokerB) {
		this.realEstateBrokerB = realEstateBrokerB;
	}
	/**
	 * @return the realEstateBrokerS
	 */
	public ContactInformationDetailModel getRealEstateBrokerS() {
		return realEstateBrokerS;
	}
	/**
	 * @param realEstateBrokerS the realEstateBrokerS to set
	 */
	public void setRealEstateBrokerS(ContactInformationDetailModel realEstateBrokerS) {
		this.realEstateBrokerS = realEstateBrokerS;
	}
	/**
	 * @return the settlementAgent
	 */
	public ContactInformationDetailModel getSettlementAgent() {
		return settlementAgent;
	}
	/**
	 * @param settlementAgent the settlementAgent to set
	 */
	public void setSettlementAgent(ContactInformationDetailModel settlementAgent) {
		this.settlementAgent = settlementAgent;
	}
	
}
