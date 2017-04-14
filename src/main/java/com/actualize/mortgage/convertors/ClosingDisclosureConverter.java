/**
 * @(#)ClosingDisclosureConverter.java 1.0 04/11/2017
 */

package com.actualize.mortgage.convertors;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.actualize.mortgage.cdpagemodels.ClosingDisclosure;
import com.actualize.mortgage.cdpagemodels.ClosingDisclosurePageOne;
import com.actualize.mortgage.domainmodels.Borrower;
import com.actualize.mortgage.domainmodels.ClosingInformation;
import com.actualize.mortgage.domainmodels.LoanInformation;
import com.actualize.mortgage.domainmodels.LoanInformationLoanIdentifier;
import com.actualize.mortgage.domainmodels.LoanTerms;
import com.actualize.mortgage.domainmodels.LoanTermsBalloonPayment;
import com.actualize.mortgage.domainmodels.LoanTermsETIA;
import com.actualize.mortgage.domainmodels.LoanTermsEscrowAccount;
import com.actualize.mortgage.domainmodels.LoanTermsInterestRate;
import com.actualize.mortgage.domainmodels.LoanTermsIntialEscrow;
import com.actualize.mortgage.domainmodels.LoanTermsLoanAmount;
import com.actualize.mortgage.domainmodels.LoanTermsPI;
import com.actualize.mortgage.domainmodels.LoanTermsPrepaymentPenalty;
import com.actualize.mortgage.domainmodels.NameModel;
import com.actualize.mortgage.domainmodels.PropertyValuationDetailModel;
import com.actualize.mortgage.domainmodels.SalesContractDetailModel;
import com.actualize.mortgage.domainmodels.TransactionInformation;
import com.actualize.mortgage.ledatamodels.Address;
import com.actualize.mortgage.ledatamodels.AmortizationRule;
import com.actualize.mortgage.ledatamodels.BuydownOccurence;
import com.actualize.mortgage.ledatamodels.BuydownRule;
import com.actualize.mortgage.ledatamodels.ClosingInformationDetail;
import com.actualize.mortgage.ledatamodels.Construction;
import com.actualize.mortgage.ledatamodels.Deal;
import com.actualize.mortgage.ledatamodels.Document;
import com.actualize.mortgage.ledatamodels.IntegratedDisclosureDetail;
import com.actualize.mortgage.ledatamodels.LegalEntity;
import com.actualize.mortgage.ledatamodels.LegalEntityDetail;
import com.actualize.mortgage.ledatamodels.LoanDetail;
import com.actualize.mortgage.ledatamodels.LoanIdentifier;
import com.actualize.mortgage.ledatamodels.LoanIdentifiers;
import com.actualize.mortgage.ledatamodels.MIDataDetail;
import com.actualize.mortgage.ledatamodels.MISMODocument;
import com.actualize.mortgage.ledatamodels.MaturityRule;
import com.actualize.mortgage.ledatamodels.Name;
import com.actualize.mortgage.ledatamodels.NegativeAmortizationRule;
import com.actualize.mortgage.ledatamodels.Other;
import com.actualize.mortgage.ledatamodels.Parties;
import com.actualize.mortgage.ledatamodels.PropertyDetail;
import com.actualize.mortgage.ledatamodels.PropertyValuationDetail;
import com.actualize.mortgage.ledatamodels.SalesContractDetail;
import com.actualize.mortgage.ledatamodels.TermsOfLoan;
import com.actualize.mortgage.lepagemodels.LoanEstimateSectionBorrower;
import com.actualize.mortgage.utils.Convertor;

import leform.Formatter;

/**
 * This class will map all the Closing Disclosure XPATH elements to JSON Objects and its attributes 
 * @author rsudula
 * @version 1.0
 * 
 */

public class ClosingDisclosureConverter {
	String loanId = "";
	String loanMic = "";
    public ClosingDisclosure convertXmltoJSON(MISMODocument mismodoc) {
        ClosingDisclosure closingDisclosure = new ClosingDisclosure();
      
        // Page -1 method
     // Page -2 method
     // Page -3 method
     // Page -4 method
     // Page -5 method
        
        //PAGE - 1 Closing Information Section Mapping
       
        
        ClosingDisclosurePageOne closingDisclosurePageOne = new ClosingDisclosurePageOne();
        closingDisclosurePageOne.setClosingInformation(createClosingInformation(mismodoc));
        closingDisclosurePageOne.setTransactionInformation(createTransactionInformation(mismodoc));
        closingDisclosurePageOne.setLoanInformation(createLoanInformation(mismodoc));
        closingDisclosure.setClosingDisclosurePageOne(closingDisclosurePageOne);
        return closingDisclosure;
    }
 
    /**
     * extracts ClosingInformation from xml and converts to JSON
     * @param mismodoc
     * @return closingInformationSection of PageOne
     */
    private ClosingInformation createClosingInformation(MISMODocument mismodoc)
    {
    	  Document document = null;
  		  LegalEntityDetail legalEntityDetail = null;
          NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
          String subjectProperty = "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY";
          String salesContract = subjectProperty + "/SALES_CONTRACTS/SALES_CONTRACT";
          String loan = "LOANS/LOAN";
          String propertyValuation = subjectProperty + "/PROPERTY_VALUATIONS/PROPERTY_VALUATION";
          SalesContractDetailModel salesContractDetailModel = new SalesContractDetailModel();
          PropertyValuationDetailModel propertyValuationDetailModel = new PropertyValuationDetailModel();
          if (nodes.getLength() > 0)
              document = new Document(Document.NS, (Element)nodes.item(0));
          Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));
          ClosingInformation closingInformationSection = new ClosingInformation();
          IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
          ClosingInformationDetail closingInformationDetail = new ClosingInformationDetail((Element)deal.getElementAddNS("LOANS/LOAN/CLOSING_INFORMATION/CLOSING_INFORMATION_DETAIL"));
          Address propertyAddress = new Address((Element)deal.getElementAddNS(subjectProperty + "/ADDRESS"));
          PropertyDetail propertyDetail = new PropertyDetail((Element)deal.getElementAddNS(subjectProperty + "/PROPERTY_DETAIL"));
  		  PropertyValuationDetail propertyValuationDetail = new PropertyValuationDetail((Element)deal.getElementAddNS(propertyValuation + "/PROPERTY_VALUATION_DETAIL"));
  		  SalesContractDetail salesContractDetail = new SalesContractDetail((Element)deal.getElementAddNS(salesContract + "/SALES_CONTRACT_DETAIL"));
  		  TermsOfLoan loanTerms = new TermsOfLoan((Element)deal.getElementAddNS(loan + "/TERMS_OF_LOAN"));
  		  Parties closingAgent = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='ClosingAgent']");
  		  String loanType = loanTerms.MortgageType;

  		  for(int i=0; i<closingAgent.parties.length;i++)
  		  {
  			  if(null != new LegalEntityDetail((Element)closingAgent.parties[i].getElementAddNS("LEGAL_ENTITY/LEGAL_ENTITY_DETAIL")).element)
  				  legalEntityDetail = new LegalEntityDetail((Element)closingAgent.parties[i].getElementAddNS("LEGAL_ENTITY/LEGAL_ENTITY_DETAIL"));
  		  }
          closingInformationSection.setClosingDate(closingInformationDetail.ClosingDate);
          closingInformationSection.setDateIssued(idDetail.IntegratedDisclosureIssuedDate);
          closingInformationSection.setDisbursementDate(closingInformationDetail.DisbursementDate);
          closingInformationSection.setFileNo(closingInformationDetail.ClosingAgentOrderNumberIdentifier);
          closingInformationSection.setProperty(toAddressModel(propertyAddress));
          closingInformationSection.setSalePrice(Formatter.ZEROTRUNCDOLLARS.format(salePrice(loanTerms, salesContractDetail, propertyValuationDetail, propertyDetail)));
          	salesContractDetailModel.setPersonalPropertyAmount(salesContractDetail.PersonalPropertyAmount);
          	salesContractDetailModel.setPersonalPropertyIndicator(Convertor.stringToBoolean(salesContractDetail.PersonalPropertyIncludedIndicator));
          	salesContractDetailModel.setRealPropertyAmount(salesContractDetail.RealPropertyAmount);
          	salesContractDetailModel.setSaleContractAmount(salesContractDetail.SalesContractAmount);
          closingInformationSection.setSalesContractDetail(salesContractDetailModel);
          closingInformationSection.setSettlementAgent(legalEntityDetail.FullName);
          	propertyValuationDetailModel.setPropertyEstimatedValueAmount(propertyValuationDetail.PropertyValuationAmount);
          	propertyValuationDetailModel.setPropertyValuationAmount(propertyValuationDetail.PropertyValuationAmount);
          	propertyValuationDetailModel.setPropertyValuationMethodType(propertyValuationDetail.PropertyValuationMethodType);
          	propertyValuationDetailModel.setPropertyValuationMethodTypeOtherDescription(propertyValuationDetail.PropertyValuationMethodTypeOtherDescription);
          closingInformationSection.setPropertyValuationDetail(propertyValuationDetailModel);
        return closingInformationSection;
    }
    
    private TransactionInformation createTransactionInformation(MISMODocument mismodoc)
    {
    	TransactionInformation transactionInformation = new TransactionInformation();
    	Document document = null;
    	LegalEntityDetail legalEntityDetail = null;
        NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
        String subjectProperty = "COLLATERALS/COLLATERAL/SUBJECT_PROPERTY";
        String loan = "LOANS/LOAN";
        if (nodes.getLength() > 0)
            document = new Document(Document.NS, (Element)nodes.item(0));
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));
        
    	Parties borrowerParties = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='Borrower']");
    	Parties sellerParties = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='PropertySeller']");
    	Parties lenders = new Parties((Element)deal.getElementAddNS("PARTIES"), "[ROLES/ROLE/ROLE_DETAIL/PartyRoleType='NotePayTo']");
    	LoanIdentifiers loanIdentifier = new LoanIdentifiers((Element)deal.getElementAddNS("LOANS/LOAN/LOAN_IDENTIFIERS"));
    	
    	transactionInformation.setBorrower(createBorrowers(borrowerParties));
    	transactionInformation.setSeller(createBorrowers(sellerParties));
    	transactionInformation.setLender(createBorrowers(lenders));
		return transactionInformation;
    	
    }
    /**
     * Creates Loan Information from MISMODocument
     * @param mismodoc
     * @return
     */
    private LoanInformation createLoanInformation(MISMODocument mismodoc)
    {
    	LoanInformation loanInformationSection = new LoanInformation();
    	String loanTotalTerm = "";  
 	    String loanPurpose = "";
 	    String loanType = "";
 	    String loanProduct = "";
    	Document document = null;
        NodeList nodes = mismodoc.getElementsAddNS("//DOCUMENT");
        String loan = "LOANS/LOAN";
        if (nodes.getLength() > 0)
            document = new Document(Document.NS, (Element)nodes.item(0));
        Deal deal = new Deal(Deal.NS, (Element)document.getElementAddNS("DEAL_SETS/DEAL_SET/DEALS/DEAL"));
        IntegratedDisclosureDetail idDetail = new IntegratedDisclosureDetail((Element)deal.getElementAddNS("LOANS/LOAN/DOCUMENT_SPECIFIC_DATA_SETS/DOCUMENT_SPECIFIC_DATA_SET/INTEGRATED_DISCLOSURE/INTEGRATED_DISCLOSURE_DETAIL"));
        MaturityRule maturityRule = new MaturityRule((Element)deal.getElementAddNS(loan + "/MATURITY/MATURITY_RULE"));
        Construction construction = new Construction((Element)deal.getElementAddNS(loan + "/CONSTRUCTION"));
 	    TermsOfLoan loanTerms = new TermsOfLoan((Element)deal.getElementAddNS(loan + "/TERMS_OF_LOAN"));
        LoanDetail loanDetail = new LoanDetail((Element)deal.getElementAddNS("LOANS/LOAN/LOAN_DETAIL"));
        
        MIDataDetail miDataDetail = new MIDataDetail((Element)deal.getElementAddNS(loan + "/MI_DATA/MI_DATA_DETAIL"));
        AmortizationRule amortization = new AmortizationRule((Element)deal.getElementAddNS(loan + "/AMORTIZATION/AMORTIZATION_RULE"));
        
        LoanIdentifiers loanidentifiers = new LoanIdentifiers((Element)deal.getElementAddNS(loan + "/LOAN_IDENTIFIERS"));
        List<LoanInformationLoanIdentifier> loanInformationLoanIdentifiers = new LinkedList<>();
        if(loanidentifiers.loanIdentifieries.length>0)
        for(int i=0; i<loanidentifiers.loanIdentifieries.length;i++)
 	    {
        	LoanInformationLoanIdentifier loanInformationLoanIdentifier = new LoanInformationLoanIdentifier();
 	  			loanInformationLoanIdentifier.setLoanIdentifier(loanidentifiers.loanIdentifieries[i].LoanIdentifier);
 	  			loanInformationLoanIdentifier.setLoanIdentifierType(loanidentifiers.loanIdentifieries[i].LoanIdentifierType);
 	  		loanInformationLoanIdentifiers.add(loanInformationLoanIdentifier);
 	  	}
        
 	  	
 	    //Loan Term
 	  	if(null != loanDetail.ConstructionLoanIndicator && null != construction && "ConstructionToPermanent".equalsIgnoreCase(construction.ConstructionLoanType))
		{
			loanTotalTerm = Convertor.convertMonthsToDisplayFormat(Integer.parseInt(construction.ConstructionLoanTotalTermMonthsCount));
		}
		else if(null != maturityRule.LoanMaturityPeriodType && "Year".equalsIgnoreCase(maturityRule.LoanMaturityPeriodType))
		{
			loanTotalTerm = maturityRule.LoanMaturityPeriodCount + " Year";
		}
		else if("Month".equalsIgnoreCase(maturityRule.LoanMaturityPeriodType) && !("").equalsIgnoreCase(maturityRule.LoanMaturityPeriodCount))
		{
			loanTotalTerm = Convertor.convertMonthsToDisplayFormat(Integer.parseInt(maturityRule.LoanMaturityPeriodCount));
		}
 	    //Loan Purpose
		if(("Purchase").equalsIgnoreCase(loanTerms.LoanPurposeType))
			loanPurpose = "Purchase";
		else if(loanDetail.ConstructionLoanIndicator == "true")
			loanPurpose = "Construction";
		else if(idDetail.IntegratedDisclosureHomeEquityLoanIndicator == "true")
			loanPurpose = "Home Equity Loan";
		else
			loanPurpose = "Refinance"; 	  	
		//Loan Type
		loanType = loanTerms.MortgageType;
		//Loan Product
		loanProduct = idDetail.IntegratedDisclosureLoanProductDescription;
		//Loan Mic && Loan Id
		if("true".equalsIgnoreCase(loanDetail.MIRequiredIndicator)){
			if("Conventional".equalsIgnoreCase(loanTerms.MortgageType)){
				loanMic = miDataDetail.MICertificateIdentifier;
			}
			else
			{
				loanInformationLoanIdentifiers.forEach(loanidentifierdata ->{
					if("AgencyCase".equalsIgnoreCase(loanidentifierdata.getLoanIdentifierType()))
						loanMic = loanidentifierdata.getLoanIdentifier();
				});
			}
		}
		loanInformationLoanIdentifiers.forEach(loanidentifierdata ->{
			if("LenderLoan".equalsIgnoreCase(loanidentifierdata.getLoanIdentifierType()))
				loanId = loanidentifierdata.getLoanIdentifier();
		});
		
 	    loanInformationSection.setLoanTerm(loanTotalTerm); 
 	    loanInformationSection.setPurpose(loanPurpose); 
 	    loanInformationSection.setProduct(loanProduct); 
 	    loanInformationSection.setLoanType(loanType);
 	    loanInformationSection.setLoanId(loanId);
 	    loanInformationSection.setMic(loanMic);
 	    loanInformationSection.setConstructionLoanType(construction.ConstructionLoanType);
 	    loanInformationSection.setConstructionPeriodNumberOfMonthsCount(construction.ConstructionPeriodNumberOfMonthsCount);
 	    loanInformationSection.setConstructionLoanTotalTermMonthsCount(construction.ConstructionLoanTotalTermMonthsCount); 
 	    loanInformationSection.setLoanMaturityPeriodType(maturityRule.LoanMaturityPeriodType);
 	    loanInformationSection.setLoanMaturityPeriodCount(maturityRule.LoanMaturityPeriodCount);
 	    loanInformationSection.setIntegratedDisclosureHomeEquityLoanIndicator(idDetail.IntegratedDisclosureHomeEquityLoanIndicator);
 	    loanInformationSection.setLienPriorityType(loanTerms.LienPriorityType);
 	    loanInformationSection.setIntegratedDisclosureLoanProductDescription(idDetail.IntegratedDisclosureLoanProductDescription);
 	    loanInformationSection.setMortgageType(loanTerms.MortgageType);
 	    loanInformationSection.setMortgageTypeOtherDescription(loanTerms.MortgageTypeOtherDescription);
 	    loanInformationSection.setMiRequiredIndicator(loanDetail.MIRequiredIndicator);
 	    loanInformationSection.setMiCertificateIdentifier(miDataDetail.MICertificateIdentifier);
 	    loanInformationSection.setLoanIdentifiers(loanInformationLoanIdentifiers);
 	    loanInformationSection.setAmortizationType(amortization.AmortizationType);	     
        return loanInformationSection;
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
	private static NameModel toNameModel(Name name) {
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
		
		if (!"".equals(address.AddressType))
			addressModel.setAddressType(address.AddressType);
		if (!"".equals(address.CityName))
			addressModel.setCityName(address.CityName);
		if (!"".equals(address.AddressLineText))
			addressModel.setAddressLineText(address.AddressLineText);
		if (!"".equals(address.StateCode))
			addressModel.setStateCode(address.StateCode);
		if (!"".equals(address.PostalCode)) 
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
     * fetches the list of sellers from the XMl
     * @param borrowers
     * @return borrowers list as JSON
     */
	private static List<Borrower> createBorrowers(Parties borrowers) {
		
		List<Borrower> borrowersList = new LinkedList<>();
		if (borrowers.parties.length > 0) {
			Borrower borrower = new Borrower();
			NameModel applicant = new NameModel();
			com.actualize.mortgage.domainmodels.Address addressModel = new com.actualize.mortgage.domainmodels.Address();
			if (!borrowers.parties[0].legalEntity.legalEntityDetail.FullName.equals(""))
			{	
				applicant.setFullName(borrowers.parties[0].legalEntity.legalEntityDetail.FullName);
				borrower.setType("O");
			}
			else
			{
				applicant = toNameModel(borrowers.parties[0].individual.name);
				borrower.setType("I");
			}
			addressModel = toAddressModel(new Address((Element)borrowers.parties[0].getElementAddNS("ADDRESSES/ADDRESS[AddressType='Mailing']")));
			borrower.setNameModel(applicant);
			borrower.setAddress(addressModel);
			borrowersList.add(borrower);
			}
		return borrowersList;
	}
}
