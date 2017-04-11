package com.actualize.mortgage.leservices.impl;

import com.actualize.mortgage.domainmodels.NameModel;
import com.actualize.mortgage.ledatamodels.Address;
import com.actualize.mortgage.ledatamodels.Construction;
import com.actualize.mortgage.ledatamodels.Deal;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureDetail;
import com.actualize.mortgage.ledatamodels.LegalEntityDetail;
import com.actualize.mortgage.ledatamodels.LoanDetail;
import com.actualize.mortgage.ledatamodels.LoanIdentifier;
import com.actualize.mortgage.ledatamodels.Locks;
import com.actualize.mortgage.ledatamodels.MaturityRule;
import com.actualize.mortgage.ledatamodels.Name;
import com.actualize.mortgage.ledatamodels.Parties;
import com.actualize.mortgage.ledatamodels.PropertyDetail;
import com.actualize.mortgage.ledatamodels.PropertyValuationDetail;
import com.actualize.mortgage.ledatamodels.SalesContractDetail;
import com.actualize.mortgage.ledatamodels.TermsOfLoan;
import com.actualize.mortgage.lepagemodels.LoanEstimateSection;
import com.actualize.mortgage.lepagemodels.LoanEstimateSectionBorrower;
import com.actualize.mortgage.lepagemodels.LoanEstimateSectionRateLock;
import com.actualize.mortgage.leservices.LoanEstimatePageOneService;
import com.actualize.mortgage.utils.StringFormatter;

import leform.Formatter;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Element;

/**
 * 
 * @author sboragala
 *
 */

public class LoanEstimatePageOneServiceImpl implements LoanEstimatePageOneService {
	/*
	 * (non-Javadoc)
	 * @see com.actualize.mortgage.leservices.LoanEstimatePageOneService#createLoanEstimateSection(com.actualize.mortgage.ledatamodels.Deal)
	 */
	@Override
	public LoanEstimateSection createLoanEstimateSection(Deal deal) throws Exception {
		
		LoanEstimateSection loanEstimateSection = new LoanEstimateSection();
		// Data query helper strings
		String loan = "LOANS/LOAN";
		String lender = "PARTIES/PARTY[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='NotePayTo'][LEGAL_ENTITY]";
		String subjectProperty = "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY";
		String propertyValuation = subjectProperty + "/PROPERTY_VALUATIONS/PROPERTY_VALUATION";
		String salesContract = subjectProperty + "/SALES_CONTRACTS/SALES_CONTRACT";
		// Data containers
		Address lenderAddress = new Address((Element)deal.getElementAddNS(lender + "/ADDRESSES/ADDRESS[AddressType='Mailing']"));
		Address propertyAddress = new Address((Element)deal.getElementAddNS(subjectProperty + "/ADDRESS"));
		Parties borrowerParties = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='Borrower']");
		Construction construction = new Construction((Element)deal.getElementAddNS(loan + "/CONSTRUCTION"));
		IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS(loan + "/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
		LegalEntityDetail lenderDetail = new LegalEntityDetail((Element)deal.getElementAddNS(lender + "/LEGAL_ENTITY/LEGAL_ENTITY_DETAIL"));
		LoanDetail loanDetail = new LoanDetail((Element)deal.getElementAddNS(loan + "/LOAN_DETAIL"));
		LoanIdentifier loanIdentifier = new LoanIdentifier((Element)deal.getElementAddNS(loan + "/LOAN_IDENTIFIERS/LOAN_IDENTIFIER[LoanIdentifierType='LenderLoan']"));
		Locks locks = new Locks((Element)deal.getElementAddNS(loan + "/LOAN_PRODUCT/LOCKS"));
		MaturityRule maturityRule = new MaturityRule((Element)deal.getElementAddNS(loan + "/MATURITY/MATURITY_RULE[LoanMaturityPeriodType='Month']"));
		PropertyDetail propertyDetail = new PropertyDetail((Element)deal.getElementAddNS(subjectProperty + "/PROPERTY_DETAIL"));
		PropertyValuationDetail propertyValuationDetail = new PropertyValuationDetail((Element)deal.getElementAddNS(propertyValuation + "/PROPERTY_VALUATION_DETAIL"));
		SalesContractDetail salesContractDetail = new SalesContractDetail((Element)deal.getElementAddNS(salesContract + "/SALES_CONTRACT_DETAIL"));
		TermsOfLoan loanTerms = new TermsOfLoan((Element)deal.getElementAddNS(loan + "/TERMS_OF_LOAN"));
		String loanType = loanTerms.MortgageType;
		
		loanEstimateSection.setLenderFullName(StringFormatter.STRINGCLEAN.formatString(lenderDetail.FullName));
		loanEstimateSection.setLenderAddress(toAddressModel(lenderAddress));
		loanEstimateSection.setDateIssued(Formatter.DATE.format(idDetail.IntegratedDisclosureIssuedDate));
		loanEstimateSection.setApplicants(applicants(borrowerParties));
		loanEstimateSection.setEstimatedPropValue(Formatter.ZEROTRUNCDOLLARS.format(salePrice(loanTerms, salesContractDetail, propertyValuationDetail, propertyDetail)));
		loanEstimateSection.setLoanTerm(Formatter.YEARSMONTHS.format(loanTerm(loanDetail, maturityRule, construction)));
		loanEstimateSection.setPurpose(loanTerms.LoanPurposeType);
		loanEstimateSection.setProduct(idDetail.IntegratedDisclosureLoanProductDescription);
		loanEstimateSection.setLoanType("Other".equalsIgnoreCase(loanType) ? loanTerms.MortgageTypeOtherDescription :loanType);
		loanEstimateSection.setLoanId(loanIdentifier.LoanIdentifier);
		loanEstimateSection.setLoanEstimateSectionRateLock(rateLock(locks, idDetail));
		
		return loanEstimateSection;

	}
	
	/**
	 * calculates the salePrice
	 * @param loanTerms
	 * @param salesContractDetail
	 * @param propertyValuationDetail
	 * @param propertyDetail
	 * @return saleprice as a String
	 */
	private static String salePrice(TermsOfLoan loanTerms, SalesContractDetail salesContractDetail, PropertyValuationDetail propertyValuationDetail, PropertyDetail propertyDetail) {
		if (!loanTerms.LoanPurposeType.equalsIgnoreCase("Purchase"))
			if (propertyValuationDetail.PropertyValuationAmount.equals(""))
				return propertyDetail.PropertyEstimatedValueAmount;
			else
				return propertyValuationDetail.PropertyValuationAmount;		
		if (salesContractDetail.PersonalPropertyIncludedIndicator.equalsIgnoreCase("true"))
			return salesContractDetail.RealPropertyAmount;
		return salesContractDetail.SalesContractAmount;
	}
	
	/**
	 * fetch the Name Model from XML
	 * @param name
	 * @return name detail
	 */
	private static NameModel getNameModel(Name name) {
		NameModel nameModel = new NameModel();
		
		if (!name.FullName.equals(""))
			nameModel.setFullName(name.FullName);
		if (!name.MiddleName.equals("")) 
			nameModel.setMiddleName(name.MiddleName);
		if (!name.LastName.equals("")) 
			nameModel.setLastName(name.LastName);
		if (!name.SuffixName.equals("")) 
			nameModel.setSuffixName(name.SuffixName);
		
		return nameModel;
	}
	
	/**
	 * fetch the address model from XML
	 * @param address
	 * @return address Model
	 */
	private static com.actualize.mortgage.domainmodels.Address toAddressModel(Address address) {
	com.actualize.mortgage.domainmodels.Address addressModel = new com.actualize.mortgage.domainmodels.Address();
		
		if (!address.CityName.equals(""))
			addressModel.setCityName(address.CityName);
		if (!address.AddressLineText.equals(""))
			addressModel.setAddressLineText(address.AddressLineText);
		if (!address.StateCode.equals(""))
			addressModel.setStateCode(address.StateCode);
		if (!address.PostalCode.equals("")) 
			addressModel.setPostalCode(address.PostalCode);
		
		return addressModel;
	}
	
	/**
	 * calculates the loan term
	 * @param loanDetail
	 * @param maturityRule
	 * @param construction
	 * @return loanTerm as a string
	 */
	private static String loanTerm(LoanDetail loanDetail, MaturityRule maturityRule, Construction construction) {
		if (loanDetail.ConstructionLoanIndicator.equalsIgnoreCase("true")) {
			if (construction.ConstructionLoanType.equalsIgnoreCase("ConstructionOnly"))
				return construction.ConstructionPeriodNumberOfMonthsCount;
			return construction.ConstructionLoanTotalTermMonthsCount;
		}
		return maturityRule.LoanMaturityPeriodCount;
	}
	
	/**
	 * fetches the list of borrowers from the XMl 
	 * @param borrowers
	 * @return borrowers List
	 */
	private static List<LoanEstimateSectionBorrower> applicants(Parties borrowers) {
		
		List<LoanEstimateSectionBorrower> loanEstimateSectionBorrowers = new LinkedList<>();
		if (borrowers.parties.length > 0) {
			LoanEstimateSectionBorrower loanEstimateSectionBorrower = new LoanEstimateSectionBorrower();
			NameModel applicant = new NameModel();
			com.actualize.mortgage.domainmodels.Address addressModel = new com.actualize.mortgage.domainmodels.Address();
			if (!borrowers.parties[0].legalEntity.legalEntityDetail.FullName.equals(""))
				applicant.setFullName(borrowers.parties[0].legalEntity.legalEntityDetail.FullName);
			else
				applicant = getNameModel(borrowers.parties[0].individual.name);
			addressModel = toAddressModel(new Address((Element)borrowers.parties[0].getElementAddNS("ADDRESSES/ADDRESS[AddressType='Mailing']")));
			loanEstimateSectionBorrower.setName(applicant);
			loanEstimateSectionBorrower.setAddress(addressModel);
			loanEstimateSectionBorrowers.add(loanEstimateSectionBorrower);
			}
		return loanEstimateSectionBorrowers;
	}
	
	/**
	 * calculates the rateLock
	 * @param locks
	 * @param idDetail
	 * @return LoanEstimateSectionRateLock object
	 */
	public static LoanEstimateSectionRateLock rateLock(Locks locks, IntegratedDisclosureDetail idDetail) {
	
		LoanEstimateSectionRateLock loanEstimateSectionRateLock = new LoanEstimateSectionRateLock();
		// Get lock date/time
		String time = "";
		String timezone = "";
		if (locks.locks.length > 0)
			if (locks.locks[locks.locks.length - 1].LockStatusType.equalsIgnoreCase("Locked")) {
				loanEstimateSectionRateLock.setUntillDate(Formatter.DATETIME.format(locks.locks[locks.locks.length - 1].LockExpirationDatetime)) ;
				loanEstimateSectionRateLock.setUntillTimeZone(locks.locks[locks.locks.length - 1].extension.other.LockExpirationTimezoneType);
			}
	
		// Build first line
		time = loanEstimateSectionRateLock.getExpireDate();
		if (("").equals(time))
			loanEstimateSectionRateLock.setRateLock("false");
		else
			loanEstimateSectionRateLock.setRateLock("true");
	
		
		// Append subsequent lines
		timezone = idDetail.extension.other.IntegratedDisclosureEstimatedClosingCostsExpirationTimezoneType;
		String formattedTimezone = timezone.equals("") ? "" : (" " + timezone);
			loanEstimateSectionRateLock.setExpireDate(Formatter.DATE.format(idDetail.IntegratedDisclosureEstimatedClosingCostsExpirationDatetime));
			loanEstimateSectionRateLock.setExpireTime(Formatter.TIME.format(idDetail.IntegratedDisclosureEstimatedClosingCostsExpirationDatetime));
			loanEstimateSectionRateLock.setExpireTimeZone(formattedTimezone);
	
		return loanEstimateSectionRateLock;
	}
}
