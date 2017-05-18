/**
 * 
 */
package com.actualize.mortgage.domainmodels;

import java.io.Serializable;

/**
 * this class defines LoanCalculationsQualifiedMortgage in JSON response
 * @author sboragala
 *
 */
public class LoanCalculationsQualifiedMortgage implements Serializable {

	private static final long serialVersionUID = 3253437764724780003L;
	
	private LoanCalculationModel loanCalculationModel;
	private QualifiedMortgageModel qualifiedMortgageModel;
	
	/**
	 * @return the loanCalculationModel
	 */
	public LoanCalculationModel getLoanCalculationModel() {
		return loanCalculationModel;
	}
	/**
	 * @param loanCalculationModel the loanCalculationModel to set
	 */
	public void setLoanCalculationModel(LoanCalculationModel loanCalculationModel) {
		this.loanCalculationModel = loanCalculationModel;
	}
	/**
	 * @return the qualifiedMortgage
	 */
	public QualifiedMortgageModel getQualifiedMortgage() {
		return qualifiedMortgageModel;
	}
	/**
	 * @param qualifiedMortgageModel the qualifiedMortgage to set
	 */
	public void setQualifiedMortgage(QualifiedMortgageModel qualifiedMortgageModel) {
		this.qualifiedMortgageModel = qualifiedMortgageModel;
	}
	

}
