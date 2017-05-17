package com.actualize.mortgage.convertors;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.domainmodels.NameModel;
import com.actualize.mortgage.ledatamodels.Address;
import com.actualize.mortgage.ledatamodels.Construction;
import com.actualize.mortgage.ledatamodels.Deal;
import com.actualize.mortgage.ledatamodels.Document;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureDetail;
import com.actualize.mortgage.ledatamodels.LegalEntityDetail;
import com.actualize.mortgage.ledatamodels.LoanDetail;
import com.actualize.mortgage.ledatamodels.LoanIdentifier;
import com.actualize.mortgage.ledatamodels.Locks;
import com.actualize.mortgage.ledatamodels.MISMODocument;
import com.actualize.mortgage.ledatamodels.MaturityRule;
import com.actualize.mortgage.ledatamodels.Name;
import com.actualize.mortgage.ledatamodels.Parties;
import com.actualize.mortgage.ledatamodels.PropertyDetail;
import com.actualize.mortgage.ledatamodels.PropertyValuationDetail;
import com.actualize.mortgage.ledatamodels.SalesContractDetail;
import com.actualize.mortgage.ledatamodels.TermsOfLoan;
import com.actualize.mortgage.lepagemodels.LoanEstimateDocument;
import com.actualize.mortgage.lepagemodels.LoanEstimatePageOne;
import com.actualize.mortgage.lepagemodels.LoanEstimateSection;
import com.actualize.mortgage.lepagemodels.LoanEstimateSectionBorrower;
import com.actualize.mortgage.lepagemodels.LoanEstimateSectionRateLock;
import com.actualize.mortgage.utils.StringFormatter;


/**
 * 
 * @author sboragala
 *
 */
public class LoanEstimateConvertor {
	/**
	 * converts xml to JSON response
	 * @param document
	 * @return
	 * @throws Exception 
	 */
	public LoanEstimateDocument convertXmltoJSON(MISMODocument mismodoc) throws Exception
	{
		LoanEstimateDocument loanEstimateDocument = new LoanEstimateDocument();
		LoanEstimatePageOne loanEstimatePageOne = new LoanEstimatePageOne();
			loanEstimatePageOne.setLoanEstimateSection(createLoanEstimateSection(mismodoc));
			loanEstimateDocument.setLoanEstimatePageOne(loanEstimatePageOne);
		return loanEstimateDocument;
	}
	
	/**
	 * creates loan estimate section 
	 * @param deal
	 * @return
	 * @throws Exception
	 */
	private LoanEstimateSection createLoanEstimateSection(MISMODocument mismodoc) throws Exception {
			
		LoanEstimateSection loanEstimateSection = new LoanEstimateSection();
		Document document = null;
		NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
        if (nodes.getLength() > 0)
            document = new Document(Document.NS, (Element)nodes.item(0));
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));
		
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
		String loanType = loanTerms.mortgageType;
		
		loanEstimateSection.setLenderFullName(StringFormatter.STRINGCLEAN.formatString(lenderDetail.fullName));
		loanEstimateSection.setLenderAddress(toAddressModel(lenderAddress));
		loanEstimateSection.setDateIssued(idDetail.integratedDisclosureIssuedDate);
		loanEstimateSection.setApplicants(applicants(borrowerParties));
		loanEstimateSection.setEstimatedPropValue(salePrice(loanTerms, salesContractDetail, propertyValuationDetail, propertyDetail));
		loanEstimateSection.setLoanTerm(loanTerm(loanDetail, maturityRule, construction));
		loanEstimateSection.setPurpose(loanTerms.loanPurposeType);
		loanEstimateSection.setProduct(idDetail.integratedDisclosureLoanProductDescription);
		loanEstimateSection.setLoanType("Other".equalsIgnoreCase(loanType) ? loanTerms.mortgageTypeOtherDescription :loanType);
		loanEstimateSection.setLoanId(loanIdentifier.LoanIdentifier);
		loanEstimateSection.setProperty(toAddressModel(propertyAddress));
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
		if (!loanTerms.loanPurposeType.equalsIgnoreCase("Purchase"))
			if (propertyValuationDetail.propertyValuationAmount.equals(""))
				return propertyDetail.propertyEstimatedValueAmount;
			else
				return propertyValuationDetail.propertyValuationAmount;		
		if (salesContractDetail.personalPropertyIncludedIndicator.equalsIgnoreCase("true"))
			return salesContractDetail.realPropertyAmount;
		return salesContractDetail.salesContractAmount;
	}
	
	/**
	 * fetch the Name Model from XML
	 * @param name
	 * @return name detail
	 */
	private static NameModel toNameModel(Name name) {
		NameModel nameModel = new NameModel();
		
		if (!name.fullName.equals(""))
			nameModel.setFullName(name.fullName);
		if (!name.middleName.equals("")) 
			nameModel.setMiddleName(name.middleName);
		if (!name.lastName.equals("")) 
			nameModel.setLastName(name.lastName);
		if (!name.suffixName.equals("")) 
			nameModel.setSuffixName(name.suffixName);
		
		return nameModel;
	}
	
	/**
	 * fetch the address model from XML
	 * @param address
	 * @return address Model
	 */
	private static com.actualize.mortgage.domainmodels.AddressModel toAddressModel(Address address) {
	com.actualize.mortgage.domainmodels.AddressModel addressModel = new com.actualize.mortgage.domainmodels.AddressModel();
		
		if (!address.cityName.equals(""))
			addressModel.setCityName(address.cityName);
		if (!address.addressLineText.equals(""))
			addressModel.setAddressLineText(address.addressLineText);
		if (!address.stateCode.equals(""))
			addressModel.setStateCode(address.stateCode);
		if (!address.postalCode.equals("")) 
			addressModel.setPostalCode(address.postalCode);
		
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
		if (loanDetail.constructionLoanIndicator.equalsIgnoreCase("true")) {
			if (construction.constructionLoanType.equalsIgnoreCase("ConstructionOnly"))
				return construction.constructionPeriodNumberOfMonthsCount;
			return construction.constructionLoanTotalTermMonthsCount;
		}
		return maturityRule.loanMaturityPeriodCount;
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
			com.actualize.mortgage.domainmodels.AddressModel addressModel = new com.actualize.mortgage.domainmodels.AddressModel();
			if (!borrowers.parties[0].legalEntity.legalEntityDetail.fullName.equals(""))
				applicant.setFullName(borrowers.parties[0].legalEntity.legalEntityDetail.fullName);
			else
				applicant = toNameModel(borrowers.parties[0].individual.name);
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
				loanEstimateSectionRateLock.setUntillDate(locks.locks[locks.locks.length - 1].LockExpirationDatetime);
				loanEstimateSectionRateLock.setUntillTimeZone(locks.locks[locks.locks.length - 1].extension.other.lockExpirationTimezoneType);
			}
	
		// Build first line
		time = loanEstimateSectionRateLock.getExpireDate();
		if (("").equals(time))
			loanEstimateSectionRateLock.setRateLock("false");
		else
			loanEstimateSectionRateLock.setRateLock("true");
	
		
		// Append subsequent lines
		timezone = idDetail.extension.other.integratedDisclosureEstimatedClosingCostsExpirationTimezoneType;
		String formattedTimezone = timezone.equals("") ? "" : (" " + timezone);
			loanEstimateSectionRateLock.setExpireDate(idDetail.integratedDisclosureEstimatedClosingCostsExpirationDatetime);
			loanEstimateSectionRateLock.setExpireTime(idDetail.integratedDisclosureEstimatedClosingCostsExpirationDatetime);
			loanEstimateSectionRateLock.setExpireTimeZone(formattedTimezone);
	
		return loanEstimateSectionRateLock;
	}
	
		
}
