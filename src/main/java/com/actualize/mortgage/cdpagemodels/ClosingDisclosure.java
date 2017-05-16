/*
 * @(#)ClosingDisclosure.java 1.0 04/10/2017
 * 
 */

package com.actualize.mortgage.cdpagemodels;

import java.io.Serializable;
import java.util.List;

import com.actualize.mortgage.domainmodels.CashToClose;
import com.actualize.mortgage.domainmodels.ClosingAdjustmentItemModel;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsLoanCosts;
import com.actualize.mortgage.domainmodels.ClosingCostDetailsOtherCosts;
import com.actualize.mortgage.domainmodels.ClosingCostFundModel;
import com.actualize.mortgage.domainmodels.ClosingCostsTotal;
import com.actualize.mortgage.domainmodels.ClosingInformationDetailModel;
import com.actualize.mortgage.domainmodels.ClosingInformationModel;
import com.actualize.mortgage.domainmodels.ConstructionModel;
import com.actualize.mortgage.domainmodels.ContactInformationModel;
import com.actualize.mortgage.domainmodels.DocumentClassificationModel;
import com.actualize.mortgage.domainmodels.ETIASection;
import com.actualize.mortgage.domainmodels.IntegratedDisclosureDetailModel;
import com.actualize.mortgage.domainmodels.InterestOnlyModel;
import com.actualize.mortgage.domainmodels.InterestRateAdjustmentModel;
import com.actualize.mortgage.domainmodels.LateChargeRuleModel;
import com.actualize.mortgage.domainmodels.LiabilityModel;
import com.actualize.mortgage.domainmodels.LoanCalculationsQualifiedMortgage;
import com.actualize.mortgage.domainmodels.LoanDetailModel;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.MIDataDetailModel;
import com.actualize.mortgage.domainmodels.MaturityRuleModel;
import com.actualize.mortgage.domainmodels.NegativeAmortizationModel;
import com.actualize.mortgage.domainmodels.PaymentModel;
import com.actualize.mortgage.domainmodels.PrincipalAndInterestPaymentAdjustmentModel;
import com.actualize.mortgage.domainmodels.ProjectedPaymentsDetails;
import com.actualize.mortgage.domainmodels.ProrationModel;
import com.actualize.mortgage.domainmodels.SalesContractDetailModel;
import com.actualize.mortgage.domainmodels.SummariesofTransactions;
import com.actualize.mortgage.domainmodels.TermsOfLoanModel;
import com.actualize.mortgage.domainmodels.TransactionInformation;
import com.actualize.mortgage.ledatamodels.PayoffsAndPayments;

/**
 * This class represents the all the pages present in Closing Disclosure
 * 
 * @author rsudula
 * @version 1.0
 * 
 */
public class ClosingDisclosure implements Serializable {

    private static final long serialVersionUID = 3808831045060865597L;
    private ClosingDisclosureDocumentDetails closingDisclosureDocType;
    private LoanDetailModel loanDetail;
    private TermsOfLoanModel termsOfLoan;
    private DocumentClassificationModel documentClassification;
    private ClosingInformationModel closingInformation;
    private ClosingInformationDetailModel closingInformationDetail;
    private ConstructionModel construction;
    private MIDataDetailModel miDataDetail;
    private TransactionInformation transactionInformation;
    private LoanInformation loanInformation;
    private SalesContractDetailModel salesContractDetail;
    private IntegratedDisclosureDetailModel integratedDisclosureDetail;
    private NegativeAmortizationModel negativeAmortization;
    private InterestOnlyModel interestOnly;
    private MaturityRuleModel maturityRule;
    private LoanTerms loanTerms;
    private ProjectedPaymentsDetails projectedPayments;
    private ETIASection etiaSection;
    //private CostsAtClosing costsAtClosing;
    private ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts;
    private ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts;
    private ClosingCostsTotal closingCostsTotal;
    private CashToClose cashToCloses;
    private List<ProrationModel> prorationsList;
    private List<LiabilityModel> liabilityList;
    private List<ClosingAdjustmentItemModel> closingAdjustmentItemList;
    private List<ClosingCostFundModel> closingCostFundList; 
    private SummariesofTransactions summariesofTransactions;
    private PayoffsAndPayments payoffsAndPayments;
    private InterestRateAdjustmentModel interestRateAdjustment; //AIR TABLE
    private PrincipalAndInterestPaymentAdjustmentModel principalAndInterestPaymentAdjustment;
    private PaymentModel payment;
    private LateChargeRuleModel lateChargeRule;
    private LoanCalculationsQualifiedMortgage loanCalculationsQualifiedMortgage;
    private ContactInformationModel contactInformation;
	/**
	 * @return the closingDisclosureDocType
	 */
	public ClosingDisclosureDocumentDetails getClosingDisclosureDocType() {
		return closingDisclosureDocType;
	}
	/**
	 * @param closingDisclosureDocType the closingDisclosureDocType to set
	 */
	public void setClosingDisclosureDocType(ClosingDisclosureDocumentDetails closingDisclosureDocType) {
		this.closingDisclosureDocType = closingDisclosureDocType;
	}
	/**
	 * @return the loanDetail
	 */
	public LoanDetailModel getLoanDetail() {
		return loanDetail;
	}
	/**
	 * @param loanDetail the loanDetail to set
	 */
	public void setLoanDetail(LoanDetailModel loanDetail) {
		this.loanDetail = loanDetail;
	}
	/**
	 * @return the termsOfLoan
	 */
	public TermsOfLoanModel getTermsOfLoan() {
		return termsOfLoan;
	}
	/**
	 * @param termsOfLoan the termsOfLoan to set
	 */
	public void setTermsOfLoan(TermsOfLoanModel termsOfLoan) {
		this.termsOfLoan = termsOfLoan;
	}
	/**
	 * @return the documentClassification
	 */
	public DocumentClassificationModel getDocumentClassification() {
		return documentClassification;
	}
	/**
	 * @param documentClassification the documentClassification to set
	 */
	public void setDocumentClassification(DocumentClassificationModel documentClassification) {
		this.documentClassification = documentClassification;
	}
	/**
	 * @return the closingInformation
	 */
	public ClosingInformationModel getClosingInformation() {
		return closingInformation;
	}
	/**
	 * @param closingInformation the closingInformation to set
	 */
	public void setClosingInformation(ClosingInformationModel closingInformation) {
		this.closingInformation = closingInformation;
	}
	/**
	 * @return the transactionInformation
	 */
	public TransactionInformation getTransactionInformation() {
		return transactionInformation;
	}
	/**
	 * @param transactionInformation the transactionInformation to set
	 */
	public void setTransactionInformation(TransactionInformation transactionInformation) {
		this.transactionInformation = transactionInformation;
	}
	/**
	 * @return the loanInformation
	 */
	public LoanInformation getLoanInformation() {
		return loanInformation;
	}
	/**
	 * @param loanInformation the loanInformation to set
	 */
	public void setLoanInformation(LoanInformation loanInformation) {
		this.loanInformation = loanInformation;
	}
	/**
	 * @return the integratedDisclosureDetail
	 */
	public IntegratedDisclosureDetailModel getIntegratedDisclosureDetail() {
		return integratedDisclosureDetail;
	}
	/**
	 * @param integratedDisclosureDetail the integratedDisclosureDetail to set
	 */
	public void setIntegratedDisclosureDetail(IntegratedDisclosureDetailModel integratedDisclosureDetail) {
		this.integratedDisclosureDetail = integratedDisclosureDetail;
	}
	/**
	 * @return the loanTerms
	 */
	public LoanTerms getLoanTerms() {
		return loanTerms;
	}
	/**
	 * @param loanTerms the loanTerms to set
	 */
	public void setLoanTerms(LoanTerms loanTerms) {
		this.loanTerms = loanTerms;
	}
	/**
	 * @return the projectedPayments
	 */
	public ProjectedPaymentsDetails getProjectedPayments() {
		return projectedPayments;
	}
	/**
	 * @param projectedPayments the projectedPayments to set
	 */
	public void setProjectedPayments(ProjectedPaymentsDetails projectedPayments) {
		this.projectedPayments = projectedPayments;
	}
	/**
	 * @return the etiaSection
	 */
	public ETIASection getEtiaSection() {
		return etiaSection;
	}
	/**
	 * @param etiaSection the etiaSection to set
	 */
	public void setEtiaSection(ETIASection etiaSection) {
		this.etiaSection = etiaSection;
	}
	/**
	 * @return the closingCostDetailsLoanCosts
	 */
	public ClosingCostDetailsLoanCosts getClosingCostDetailsLoanCosts() {
		return closingCostDetailsLoanCosts;
	}
	/**
	 * @param closingCostDetailsLoanCosts the closingCostDetailsLoanCosts to set
	 */
	public void setClosingCostDetailsLoanCosts(ClosingCostDetailsLoanCosts closingCostDetailsLoanCosts) {
		this.closingCostDetailsLoanCosts = closingCostDetailsLoanCosts;
	}
	/**
	 * @return the closingCostDetailsOtherCosts
	 */
	public ClosingCostDetailsOtherCosts getClosingCostDetailsOtherCosts() {
		return closingCostDetailsOtherCosts;
	}
	/**
	 * @param closingCostDetailsOtherCosts the closingCostDetailsOtherCosts to set
	 */
	public void setClosingCostDetailsOtherCosts(ClosingCostDetailsOtherCosts closingCostDetailsOtherCosts) {
		this.closingCostDetailsOtherCosts = closingCostDetailsOtherCosts;
	}
	/**
	 * @return the closingCostsTotal
	 */
	public ClosingCostsTotal getClosingCostsTotal() {
		return closingCostsTotal;
	}
	/**
	 * @param closingCostsTotal the closingCostsTotal to set
	 */
	public void setClosingCostsTotal(ClosingCostsTotal closingCostsTotal) {
		this.closingCostsTotal = closingCostsTotal;
	}
	/**
	 * @return the cashToCloses
	 */
	public CashToClose getCashToCloses() {
		return cashToCloses;
	}
	/**
	 * @param cashToCloses the cashToCloses to set
	 */
	public void setCashToCloses(CashToClose cashToCloses) {
		this.cashToCloses = cashToCloses;
	}
	/**
	 * @return the prorationsList
	 */
	public List<ProrationModel> getProrationsList() {
		return prorationsList;
	}
	/**
	 * @param prorationsList the prorationsList to set
	 */
	public void setProrationsList(List<ProrationModel> prorationsList) {
		this.prorationsList = prorationsList;
	}
	/**
	 * @return the liabilityList
	 */
	public List<LiabilityModel> getLiabilityList() {
		return liabilityList;
	}
	/**
	 * @param liabilityList the liabilityList to set
	 */
	public void setLiabilityList(List<LiabilityModel> liabilityList) {
		this.liabilityList = liabilityList;
	}
	/**
	 * @return the closingAdjustmentItemList
	 */
	public List<ClosingAdjustmentItemModel> getClosingAdjustmentItemList() {
		return closingAdjustmentItemList;
	}
	/**
	 * @param closingAdjustmentItemList the closingAdjustmentItemList to set
	 */
	public void setClosingAdjustmentItemList(List<ClosingAdjustmentItemModel> closingAdjustmentItemList) {
		this.closingAdjustmentItemList = closingAdjustmentItemList;
	}
	/**
	 * @return the closingCostFundList
	 */
	public List<ClosingCostFundModel> getClosingCostFundList() {
		return closingCostFundList;
	}
	/**
	 * @param closingCostFundList the closingCostFundList to set
	 */
	public void setClosingCostFundList(List<ClosingCostFundModel> closingCostFundList) {
		this.closingCostFundList = closingCostFundList;
	}
	/**
	 * @return the summariesofTransactions
	 */
	public SummariesofTransactions getSummariesofTransactions() {
		return summariesofTransactions;
	}
	/**
	 * @param summariesofTransactions the summariesofTransactions to set
	 */
	public void setSummariesofTransactions(SummariesofTransactions summariesofTransactions) {
		this.summariesofTransactions = summariesofTransactions;
	}
	/**
	 * @return the payoffsAndPayments
	 */
	public PayoffsAndPayments getPayoffsAndPayments() {
		return payoffsAndPayments;
	}
	/**
	 * @param payoffsAndPayments the payoffsAndPayments to set
	 */
	public void setPayoffsAndPayments(PayoffsAndPayments payoffsAndPayments) {
		this.payoffsAndPayments = payoffsAndPayments;
	}
	/**
	 * @return the interestRateAdjustment
	 */
	public InterestRateAdjustmentModel getInterestRateAdjustment() {
		return interestRateAdjustment;
	}
	/**
	 * @param interestRateAdjustment the interestRateAdjustment to set
	 */
	public void setInterestRateAdjustment(InterestRateAdjustmentModel interestRateAdjustment) {
		this.interestRateAdjustment = interestRateAdjustment;
	}
	/**
	 * @return the principalAndInterestPaymentAdjustment
	 */
	public PrincipalAndInterestPaymentAdjustmentModel getPrincipalAndInterestPaymentAdjustment() {
		return principalAndInterestPaymentAdjustment;
	}
	/**
	 * @param principalAndInterestPaymentAdjustment the principalAndInterestPaymentAdjustment to set
	 */
	public void setPrincipalAndInterestPaymentAdjustment(
			PrincipalAndInterestPaymentAdjustmentModel principalAndInterestPaymentAdjustment) {
		this.principalAndInterestPaymentAdjustment = principalAndInterestPaymentAdjustment;
	}
	/**
	 * @return the payment
	 */
	public PaymentModel getPayment() {
		return payment;
	}
	/**
	 * @param payment the payment to set
	 */
	public void setPayment(PaymentModel payment) {
		this.payment = payment;
	}
	/**
	 * @return the lateChargeRule
	 */
	public LateChargeRuleModel getLateChargeRule() {
		return lateChargeRule;
	}
	/**
	 * @param lateChargeRule the lateChargeRule to set
	 */
	public void setLateChargeRule(LateChargeRuleModel lateChargeRule) {
		this.lateChargeRule = lateChargeRule;
	}
	/**
	 * @return the loanCalculationsQualifiedMortgage
	 */
	public LoanCalculationsQualifiedMortgage getLoanCalculationsQualifiedMortgage() {
		return loanCalculationsQualifiedMortgage;
	}
	/**
	 * @param loanCalculationsQualifiedMortgage the loanCalculationsQualifiedMortgage to set
	 */
	public void setLoanCalculationsQualifiedMortgage(LoanCalculationsQualifiedMortgage loanCalculationsQualifiedMortgage) {
		this.loanCalculationsQualifiedMortgage = loanCalculationsQualifiedMortgage;
	}
	/**
	 * @return the contactInformation
	 */
	public ContactInformationModel getContactInformation() {
		return contactInformation;
	}
	/**
	 * @param contactInformation the contactInformation to set
	 */
	public void setContactInformation(ContactInformationModel contactInformation) {
		this.contactInformation = contactInformation;
	}
	/**
	 * @return the salesContractDetail
	 */
	public SalesContractDetailModel getSalesContractDetail() {
		return salesContractDetail;
	}
	/**
	 * @param salesContractDetail the salesContractDetail to set
	 */
	public void setSalesContractDetail(SalesContractDetailModel salesContractDetail) {
		this.salesContractDetail = salesContractDetail;
	}
	/**
	 * @return the closingInformationDetail
	 */
	public ClosingInformationDetailModel getClosingInformationDetail() {
		return closingInformationDetail;
	}
	/**
	 * @param closingInformationDetail the closingInformationDetail to set
	 */
	public void setClosingInformationDetail(ClosingInformationDetailModel closingInformationDetail) {
		this.closingInformationDetail = closingInformationDetail;
	}
	/**
	 * @return the construction
	 */
	public ConstructionModel getConstruction() {
		return construction;
	}
	/**
	 * @param construction the construction to set
	 */
	public void setConstruction(ConstructionModel construction) {
		this.construction = construction;
	}
	/**
	 * @return the miDataDetail
	 */
	public MIDataDetailModel getMiDataDetail() {
		return miDataDetail;
	}
	/**
	 * @param miDataDetail the miDataDetail to set
	 */
	public void setMiDataDetail(MIDataDetailModel miDataDetail) {
		this.miDataDetail = miDataDetail;
	}
	/**
	 * @return the negativeAmortization
	 */
	public NegativeAmortizationModel getNegativeAmortization() {
		return negativeAmortization;
	}
	/**
	 * @param negativeAmortization the negativeAmortization to set
	 */
	public void setNegativeAmortization(NegativeAmortizationModel negativeAmortization) {
		this.negativeAmortization = negativeAmortization;
	}
	/**
	 * @return the interestOnly
	 */
	public InterestOnlyModel getInterestOnly() {
		return interestOnly;
	}
	/**
	 * @param interestOnly the interestOnly to set
	 */
	public void setInterestOnly(InterestOnlyModel interestOnly) {
		this.interestOnly = interestOnly;
	}
	/**
	 * @return the maturityRule
	 */
	public MaturityRuleModel getMaturityRule() {
		return maturityRule;
	}
	/**
	 * @param maturityRule the maturityRule to set
	 */
	public void setMaturityRule(MaturityRuleModel maturityRule) {
		this.maturityRule = maturityRule;
	}
	
	
}
